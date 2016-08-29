package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;

public class NetworkImageView extends ImageView {
    private int mDefaultImageId;
    private int mErrorImageId;
    private ImageContainer mImageContainer;
    private ImageLoader mImageLoader;
    private String mUrl;

    /* renamed from: com.android.volley.toolbox.NetworkImageView.1 */
    class C09021 implements ImageListener {
        final /* synthetic */ boolean val$isInLayoutPass;

        /* renamed from: com.android.volley.toolbox.NetworkImageView.1.1 */
        class C01791 implements Runnable {
            final /* synthetic */ ImageContainer val$response;

            C01791(ImageContainer imageContainer) {
                this.val$response = imageContainer;
            }

            public void run() {
                C09021.this.onResponse(this.val$response, false);
            }
        }

        C09021(boolean z) {
            this.val$isInLayoutPass = z;
        }

        public void onErrorResponse(VolleyError error) {
            if (NetworkImageView.this.mErrorImageId != 0) {
                NetworkImageView.this.setImageResource(NetworkImageView.this.mErrorImageId);
            }
        }

        public void onResponse(ImageContainer response, boolean isImmediate) {
            if (isImmediate && this.val$isInLayoutPass) {
                NetworkImageView.this.post(new C01791(response));
            } else if (response.getBitmap() != null) {
                NetworkImageView.this.setImageBitmap(response.getBitmap());
            } else if (NetworkImageView.this.mDefaultImageId != 0) {
                NetworkImageView.this.setImageResource(NetworkImageView.this.mDefaultImageId);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setImageUrl(String url, ImageLoader imageLoader) {
        this.mUrl = url;
        this.mImageLoader = imageLoader;
        loadImageIfNecessary(false);
    }

    public void setDefaultImageResId(int defaultImage) {
        this.mDefaultImageId = defaultImage;
    }

    public void setErrorImageResId(int errorImage) {
        this.mErrorImageId = errorImage;
    }

    void loadImageIfNecessary(boolean isInLayoutPass) {
        int width = getWidth();
        int height = getHeight();
        ScaleType scaleType = getScaleType();
        boolean wrapWidth = false;
        boolean wrapHeight = false;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width == -2) {
                wrapWidth = true;
            } else {
                wrapWidth = false;
            }
            if (getLayoutParams().height == -2) {
                wrapHeight = true;
            } else {
                wrapHeight = false;
            }
        }
        boolean isFullyWrapContent;
        if (wrapWidth && wrapHeight) {
            isFullyWrapContent = true;
        } else {
            isFullyWrapContent = false;
        }
        if (width != 0 || height != 0 || isFullyWrapContent) {
            if (TextUtils.isEmpty(this.mUrl)) {
                if (this.mImageContainer != null) {
                    this.mImageContainer.cancelRequest();
                    this.mImageContainer = null;
                }
                setDefaultImageOrNull();
                return;
            }
            int maxWidth;
            int maxHeight;
            if (!(this.mImageContainer == null || this.mImageContainer.getRequestUrl() == null)) {
                if (!this.mImageContainer.getRequestUrl().equals(this.mUrl)) {
                    this.mImageContainer.cancelRequest();
                    setDefaultImageOrNull();
                } else {
                    return;
                }
            }
            if (wrapWidth) {
                maxWidth = 0;
            } else {
                maxWidth = width;
            }
            if (wrapHeight) {
                maxHeight = 0;
            } else {
                maxHeight = height;
            }
            this.mImageContainer = this.mImageLoader.get(this.mUrl, new C09021(isInLayoutPass), maxWidth, maxHeight, scaleType);
        }
    }

    private void setDefaultImageOrNull() {
        if (this.mDefaultImageId != 0) {
            setImageResource(this.mDefaultImageId);
        } else {
            setImageBitmap(null);
        }
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        loadImageIfNecessary(true);
    }

    protected void onDetachedFromWindow() {
        if (this.mImageContainer != null) {
            this.mImageContainer.cancelRequest();
            setImageBitmap(null);
            this.mImageContainer = null;
        }
        super.onDetachedFromWindow();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
