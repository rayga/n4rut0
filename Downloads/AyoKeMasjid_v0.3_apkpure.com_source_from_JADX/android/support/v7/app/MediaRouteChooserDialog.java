package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.support.v7.mediarouter.C0142R;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.bpmikc.akm.BuildConfig;

public class MediaRouteChooserDialog extends Dialog {
    private RouteAdapter mAdapter;
    private boolean mAttachedToWindow;
    private final MediaRouterCallback mCallback;
    private ListView mListView;
    private final MediaRouter mRouter;
    private ArrayList<RouteInfo> mRoutes;
    private MediaRouteSelector mSelector;

    private final class RouteAdapter extends ArrayAdapter<RouteInfo> implements OnItemClickListener {
        private final LayoutInflater mInflater;

        public RouteAdapter(Context context, List<RouteInfo> routes) {
            super(context, 0, routes);
            this.mInflater = LayoutInflater.from(context);
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public boolean isEnabled(int position) {
            return ((RouteInfo) getItem(position)).isEnabled();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = this.mInflater.inflate(C0142R.layout.mr_media_route_list_item, parent, false);
            }
            RouteInfo route = (RouteInfo) getItem(position);
            TextView text2 = (TextView) view.findViewById(16908309);
            ((TextView) view.findViewById(16908308)).setText(route.getName());
            String description = route.getDescription();
            if (TextUtils.isEmpty(description)) {
                text2.setVisibility(8);
                text2.setText(BuildConfig.FLAVOR);
            } else {
                text2.setVisibility(0);
                text2.setText(description);
            }
            view.setEnabled(route.isEnabled());
            return view;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            RouteInfo route = (RouteInfo) getItem(position);
            if (route.isEnabled()) {
                route.select();
                MediaRouteChooserDialog.this.dismiss();
            }
        }
    }

    private static final class RouteComparator implements Comparator<RouteInfo> {
        public static final RouteComparator sInstance;

        private RouteComparator() {
        }

        static {
            sInstance = new RouteComparator();
        }

        public int compare(RouteInfo lhs, RouteInfo rhs) {
            return lhs.getName().compareTo(rhs.getName());
        }
    }

    private final class MediaRouterCallback extends Callback {
        private MediaRouterCallback() {
        }

        public void onRouteAdded(MediaRouter router, RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteRemoved(MediaRouter router, RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteChanged(MediaRouter router, RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteSelected(MediaRouter router, RouteInfo route) {
            MediaRouteChooserDialog.this.dismiss();
        }
    }

    public MediaRouteChooserDialog(Context context) {
        this(context, 0);
    }

    public MediaRouteChooserDialog(Context context, int theme) {
        super(MediaRouterThemeHelper.createThemedContext(context), theme);
        this.mSelector = MediaRouteSelector.EMPTY;
        this.mRouter = MediaRouter.getInstance(getContext());
        this.mCallback = new MediaRouterCallback();
    }

    @NonNull
    public MediaRouteSelector getRouteSelector() {
        return this.mSelector;
    }

    public void setRouteSelector(@NonNull MediaRouteSelector selector) {
        if (selector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.mSelector.equals(selector)) {
            this.mSelector = selector;
            if (this.mAttachedToWindow) {
                this.mRouter.removeCallback(this.mCallback);
                this.mRouter.addCallback(selector, this.mCallback, 1);
            }
            refreshRoutes();
        }
    }

    public void onFilterRoutes(@NonNull List<RouteInfo> routes) {
        int i = routes.size();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            if (onFilterRoute((RouteInfo) routes.get(i2))) {
                i = i2;
            } else {
                routes.remove(i2);
                i = i2;
            }
        }
    }

    public boolean onFilterRoute(@NonNull RouteInfo route) {
        return !route.isDefault() && route.isEnabled() && route.matchesSelector(this.mSelector);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(3);
        setContentView(C0142R.layout.mr_media_route_chooser_dialog);
        setTitle(C0142R.string.mr_media_route_chooser_title);
        getWindow().setFeatureDrawableResource(3, MediaRouterThemeHelper.getThemeResource(getContext(), C0142R.attr.mediaRouteOffDrawable));
        this.mRoutes = new ArrayList();
        this.mAdapter = new RouteAdapter(getContext(), this.mRoutes);
        this.mListView = (ListView) findViewById(C0142R.id.media_route_list);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this.mAdapter);
        this.mListView.setEmptyView(findViewById(16908292));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        this.mRouter.addCallback(this.mSelector, this.mCallback, 1);
        refreshRoutes();
    }

    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        this.mRouter.removeCallback(this.mCallback);
        super.onDetachedFromWindow();
    }

    public void refreshRoutes() {
        if (this.mAttachedToWindow) {
            this.mRoutes.clear();
            this.mRoutes.addAll(this.mRouter.getRoutes());
            onFilterRoutes(this.mRoutes);
            Collections.sort(this.mRoutes, RouteComparator.sInstance);
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
