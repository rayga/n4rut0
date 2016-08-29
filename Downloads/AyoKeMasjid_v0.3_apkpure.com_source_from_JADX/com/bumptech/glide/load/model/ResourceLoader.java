package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;

public class ResourceLoader<T> implements ModelLoader<Integer, T> {
    private final Resources resources;
    private final ModelLoader<Uri, T> uriLoader;

    public ResourceLoader(Context context, ModelLoader<Uri, T> uriLoader) {
        this(context.getResources(), (ModelLoader) uriLoader);
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, T> uriLoader) {
        this.resources = resources;
        this.uriLoader = uriLoader;
    }

    public DataFetcher<T> getResourceFetcher(Integer model, int width, int height) {
        return this.uriLoader.getResourceFetcher(Uri.parse("android.resource://" + this.resources.getResourcePackageName(model.intValue()) + '/' + this.resources.getResourceTypeName(model.intValue()) + '/' + this.resources.getResourceEntryName(model.intValue())), width, height);
    }
}
