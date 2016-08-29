package com.bumptech.glide.load.data;

import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.model.GlideUrl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
    private static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY;
    private static final int MAXIMUM_REDIRECTS = 5;
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private HttpURLConnection urlConnection;

    interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        private DefaultHttpUrlConnectionFactory() {
        }

        public HttpURLConnection build(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    static {
        DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    }

    public HttpUrlFetcher(GlideUrl glideUrl) {
        this(glideUrl, DEFAULT_CONNECTION_FACTORY);
    }

    HttpUrlFetcher(GlideUrl glideUrl, HttpUrlConnectionFactory connectionFactory) {
        this.glideUrl = glideUrl;
        this.connectionFactory = connectionFactory;
    }

    public InputStream loadData(Priority priority) throws Exception {
        return loadDataWithRedirects(this.glideUrl.toURL(), 0, null);
    }

    private InputStream loadDataWithRedirects(URL url, int redirects, URL lastUrl) throws IOException {
        if (redirects >= MAXIMUM_REDIRECTS) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (lastUrl != null) {
            try {
                if (url.toURI().equals(lastUrl.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException e) {
            }
        }
        this.urlConnection = this.connectionFactory.build(url);
        this.urlConnection.setConnectTimeout(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS);
        this.urlConnection.setReadTimeout(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS);
        this.urlConnection.setUseCaches(false);
        this.urlConnection.setDoInput(true);
        this.urlConnection.connect();
        if (this.isCancelled) {
            return null;
        }
        int statusCode = this.urlConnection.getResponseCode();
        if (statusCode / 100 == 2) {
            this.stream = this.urlConnection.getInputStream();
            return this.stream;
        } else if (statusCode / 100 == 3) {
            String redirectUrlString = this.urlConnection.getHeaderField("Location");
            if (!TextUtils.isEmpty(redirectUrlString)) {
                return loadDataWithRedirects(new URL(url, redirectUrlString), redirects + 1, url);
            }
            throw new IOException("Received empty or null redirect url");
        } else if (statusCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        } else {
            throw new IOException("Request failed " + statusCode + ": " + this.urlConnection.getResponseMessage());
        }
    }

    public void cleanup() {
        if (this.stream != null) {
            try {
                this.stream.close();
            } catch (IOException e) {
            }
        }
        if (this.urlConnection != null) {
            this.urlConnection.disconnect();
        }
    }

    public String getId() {
        return this.glideUrl.toString();
    }

    public void cancel() {
        this.isCancelled = true;
    }
}
