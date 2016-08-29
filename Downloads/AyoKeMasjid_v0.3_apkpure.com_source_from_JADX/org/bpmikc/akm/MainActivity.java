package org.bpmikc.akm;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.Games;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import org.bpmikc.akm.Database.MySQLiteHelper;
import org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap;
import org.bpmikc.akm.Fragment.Frg_Artikel;
import org.bpmikc.akm.Fragment.Frg_Bantuan;
import org.bpmikc.akm.Fragment.Frg_Cari_Masjid;
import org.bpmikc.akm.Fragment.Frg_Donasi;
import org.bpmikc.akm.Fragment.Frg_Faq_Masukan;
import org.bpmikc.akm.Fragment.Frg_Home;
import org.bpmikc.akm.Fragment.Frg_Iklan;
import org.bpmikc.akm.Fragment.Frg_Info_Aplikasi;
import org.bpmikc.akm.Fragment.Frg_Jadwal_Sholat;
import org.bpmikc.akm.Fragment.Frg_Kewanitaan;
import org.bpmikc.akm.Fragment.Frg_Kompas_Muazzin;
import org.bpmikc.akm.Fragment.Frg_Lokasi_Masjid;
import org.bpmikc.akm.Fragment.Frg_Qiblat_Map;
import org.bpmikc.akm.Fragment.Frg_Setting;
import org.bpmikc.akm.Fragment.Frg_Transaksi_Online;
import org.bpmikc.akm.RecyclerView.Adapters.DrawerAdapter;
import org.bpmikc.akm.RecyclerView.Classes.DrawerItem;
import org.bpmikc.akm.RecyclerView.Utils.ItemClickSupport;
import org.bpmikc.akm.RecyclerView.Utils.ItemClickSupport.OnItemClickListener;
import org.bpmikc.akm.Utils.CropCircleTransform;
import org.bpmikc.akm.Utils.CustomSwipeAdapter;
import org.bpmikc.akm.Widget.Preferences;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    public int f12a;
    CustomSwipeAdapter adapter;
    private Bundle bundle;
    Button buttonIndigoDark;
    Button buttonIndigoLight;
    Button buttonRedDark;
    Button buttonRedLight;
    int colorBackground;
    int colorControlHighlight;
    int colorPrimary;
    private int count;
    Adapter drawerAdapter1;
    Adapter drawerAdapter2;
    Adapter drawerAdapter3;
    Adapter drawerAdapterSettings;
    float drawerHeight;
    ArrayList<DrawerItem> drawerItems1;
    ArrayList<DrawerItem> drawerItems2;
    ArrayList<DrawerItem> drawerItems3;
    ArrayList<DrawerItem> drawerItemsSettings;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    private String durasi;
    private String flag_01;
    private String flag_02;
    private String flag_03;
    private FragmentManager fm;
    FrameLayout frameLayoutSetting1;
    final Handler handler;
    private String id_rec;
    private int ik;
    public final String[] imageArray_url;
    ImageView imageViewDrawerArrowUpDown;
    private String image_iklan;
    ItemClickSupport itemClickSupport1;
    ItemClickSupport itemClickSupport2;
    ItemClickSupport itemClickSupport3;
    ItemClickSupport itemClickSupportSettings;
    LinearLayout linearLayoutDrawerAccount;
    LinearLayout linearLayoutDrawerMain;
    LinearLayoutManager linearLayoutManager;
    LinearLayoutManager linearLayoutManager2;
    LinearLayoutManager linearLayoutManager3;
    LinearLayoutManager linearLayoutManagerSettings;
    private Preferences mPreferences;
    private String menu;
    OnScrollChangedListener onScrollChangedListener;
    RecyclerView recyclerViewDrawer1;
    RecyclerView recyclerViewDrawer2;
    RecyclerView recyclerViewDrawer3;
    RecyclerView recyclerViewDrawerSettings;
    int recyclerViewHeight;
    RelativeLayout relativeLayoutScrollViewChild;
    float scrollViewHeight;
    ScrollView scrollViewNavigationDrawerContent;
    private String server_path;
    private String server_path_target;
    SharedPreferences sharedPreferences;
    private String status;
    FrameLayout statusBar;
    int textColorPrimary;
    private Timer timer;
    ToggleButton toggleButtonDrawer;
    Toolbar toolbar;
    TypedValue typedValueColorBackground;
    TypedValue typedValueColorPrimary;
    TypedValue typedValueTextColorControlHighlight;
    TypedValue typedValueTextColorPrimary;
    private String url_iklan;
    ViewPager viewPager;
    ViewTreeObserver viewTreeObserverNavigationDrawerScrollView;

    /* renamed from: org.bpmikc.akm.MainActivity.1 */
    class C06091 implements DialogInterface.OnClickListener {
        C06091() {
        }

        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case GridLayoutManager.DEFAULT_SPAN_COUNT /*-1*/:
                    MainActivity.this.finish();
                default:
            }
        }
    }

    /* renamed from: org.bpmikc.akm.MainActivity.2 */
    class C06102 implements OnGlobalLayoutListener {
        C06102() {
        }

        public void onGlobalLayout() {
            if (VERSION.SDK_INT > 16) {
                MainActivity.this.relativeLayoutScrollViewChild.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                MainActivity.this.relativeLayoutScrollViewChild.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            MainActivity.this.drawerHeight = (float) MainActivity.this.relativeLayoutScrollViewChild.getHeight();
            MainActivity.this.scrollViewHeight = (float) MainActivity.this.scrollViewNavigationDrawerContent.getHeight();
            if (MainActivity.this.drawerHeight > MainActivity.this.scrollViewHeight) {
                MainActivity.this.frameLayoutSetting1.setVisibility(0);
            }
            if (MainActivity.this.drawerHeight < MainActivity.this.scrollViewHeight) {
                MainActivity.this.frameLayoutSetting1.setVisibility(8);
            }
        }
    }

    /* renamed from: org.bpmikc.akm.MainActivity.3 */
    class C06123 implements OnScrollChangedListener {

        /* renamed from: org.bpmikc.akm.MainActivity.3.1 */
        class C06111 implements OnTouchListener {
            C06111() {
            }

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case CompletionEvent.STATUS_FAILURE /*1*/:
                        if (MainActivity.this.scrollViewNavigationDrawerContent.getScrollY() != 0) {
                            MainActivity.this.frameLayoutSetting1.animate().translationY((float) MainActivity.this.frameLayoutSetting1.getHeight()).setInterpolator(new AccelerateInterpolator(5.0f)).setDuration(400);
                            break;
                        }
                        break;
                    case CompletionEvent.STATUS_CONFLICT /*2*/:
                        if (MainActivity.this.scrollViewNavigationDrawerContent.getScrollY() != 0) {
                            MainActivity.this.frameLayoutSetting1.animate().translationY((float) MainActivity.this.frameLayoutSetting1.getHeight()).setInterpolator(new AccelerateInterpolator(5.0f)).setDuration(400);
                            break;
                        }
                        break;
                }
                return false;
            }
        }

        C06123() {
        }

        public void onScrollChanged() {
            MainActivity.this.scrollViewNavigationDrawerContent.setOnTouchListener(new C06111());
            if (MainActivity.this.scrollViewNavigationDrawerContent.getScrollY() == 0) {
                MainActivity.this.frameLayoutSetting1.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator(5.0f)).setDuration(600);
            }
        }
    }

    /* renamed from: org.bpmikc.akm.MainActivity.4 */
    class C06134 implements OnTouchListener {
        C06134() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    MainActivity.this.scrollViewNavigationDrawerContent.getViewTreeObserver().addOnScrollChangedListener(MainActivity.this.onScrollChangedListener);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    MainActivity.this.scrollViewNavigationDrawerContent.getViewTreeObserver().addOnScrollChangedListener(MainActivity.this.onScrollChangedListener);
                    break;
            }
            return false;
        }
    }

    /* renamed from: org.bpmikc.akm.MainActivity.5 */
    class C06145 extends SimpleOnGestureListener {
        C06145() {
        }

        public boolean onSingleTapUp(MotionEvent e) {
            return true;
        }
    }

    /* renamed from: org.bpmikc.akm.MainActivity.14 */
    class AnonymousClass14 implements Listener<JSONObject> {
        final /* synthetic */ ImageView val$img_iklan;
        final /* synthetic */ String val$server_path;

        /* renamed from: org.bpmikc.akm.MainActivity.14.1 */
        class C06071 implements Runnable {
            int f4b;
            final /* synthetic */ String[] val$image_resources;

            C06071(String[] strArr) {
                this.val$image_resources = strArr;
                this.f4b = 0;
            }

            public void run() {
                Glide.with(MainActivity.this.getApplication()).load(this.val$image_resources[this.f4b]).into(AnonymousClass14.this.val$img_iklan);
                MainActivity.this.f12a = this.f4b;
                this.f4b++;
                if (this.f4b > this.val$image_resources.length - 1) {
                    this.f4b = 0;
                }
                MainActivity.this.handler.postDelayed(this, (long) Integer.decode(MainActivity.this.durasi).intValue());
            }
        }

        /* renamed from: org.bpmikc.akm.MainActivity.14.2 */
        class C06082 implements OnClickListener {
            final /* synthetic */ String[] val$imageArray_url;

            C06082(String[] strArr) {
                this.val$imageArray_url = strArr;
            }

            public void onClick(View arg0) {
                String url_proses = this.val$imageArray_url[MainActivity.this.f12a];
                Bundle bundlex = new Bundle();
                bundlex.putString("url_iklan", url_proses);
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Iklan.newInstance(bundlex)).commit();
            }
        }

        AnonymousClass14(String str, ImageView imageView) {
            this.val$server_path = str;
            this.val$img_iklan = imageView;
        }

        public void onResponse(JSONObject response) {
            try {
                JSONArray ja = response.getJSONArray("iklan");
                String[] image_resources = new String[ja.length()];
                String[] imageArray_url = new String[ja.length()];
                Arrays.fill(image_resources, null);
                Arrays.fill(imageArray_url, null);
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject c = ja.getJSONObject(i);
                    MainActivity.this.id_rec = c.getString("id_rec");
                    MainActivity.this.menu = c.getString("menu");
                    MainActivity.this.status = c.getString(Games.EXTRA_STATUS);
                    MainActivity.this.url_iklan = c.getString("url_iklan");
                    MainActivity.this.flag_01 = c.getString("flag_01");
                    MainActivity.this.flag_02 = c.getString("flag_02");
                    MainActivity.this.flag_03 = c.getString("flag_03");
                    MainActivity.this.image_iklan = c.getString("image_iklan");
                    MainActivity.this.durasi = c.getString("durasi");
                    image_resources[i] = this.val$server_path + "/app_files/" + MainActivity.this.image_iklan;
                    imageArray_url[i] = MainActivity.this.url_iklan;
                }
                MainActivity.this.handler.removeCallbacksAndMessages(null);
                MainActivity.this.handler.postDelayed(new C06071(image_resources), 500);
                this.val$img_iklan.setOnClickListener(new C06082(imageArray_url));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: org.bpmikc.akm.MainActivity.6 */
    class C08836 implements OnItemTouchListener {
        final /* synthetic */ GestureDetector val$mGestureDetector;

        C08836(GestureDetector gestureDetector) {
            this.val$mGestureDetector = gestureDetector;
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (child == null || !this.val$mGestureDetector.onTouchEvent(motionEvent)) {
                return false;
            }
            int i;
            MainActivity.this.drawerLayout.closeDrawers();
            for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                LinearLayout linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            for (i = 0; i < MainActivity.this.recyclerViewDrawerSettings.getChildCount(); i++) {
                linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            TextView textViewDrawerItemTitle;
            Bundle bundle;
            switch (recyclerView.getChildPosition(child)) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 0) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Home ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Assalamu'alaikum");
                    }
                    MainActivity.this.timer_iklan("home");
                    bundle = new Bundle();
                    bundle.putString("judul", "Home");
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Home.newInstance(bundle)).commit();
                    break;
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 1) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Lokasi Masjid ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Masjid");
                    }
                    MainActivity.this.timer_iklan("lokasi_masjid");
                    bundle = new Bundle();
                    bundle.putInt(Frg_Qiblat_Map.sARGUMENT_IMAGE_CODE, 2);
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Lokasi_Masjid.newInstance(bundle)).commit();
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 2) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Tambah Masjid ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Tambah Masjid");
                    }
                    MainActivity.this.timer_iklan("tambah_masjid");
                    bundle = new Bundle();
                    bundle.putInt(Frg_Qiblat_Map.sARGUMENT_IMAGE_CODE, 2);
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Add_Masjid_Gmap.newInstance(bundle)).commit();
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 3) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Cari Masjid ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Cari Masjid");
                    }
                    MainActivity.this.timer_iklan("cari_masjid");
                    bundle = new Bundle();
                    bundle.putInt(Frg_Qiblat_Map.sARGUMENT_IMAGE_CODE, 2);
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Cari_Masjid.newInstance(bundle)).commit();
                    break;
            }
            return true;
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    /* renamed from: org.bpmikc.akm.MainActivity.7 */
    class C08847 implements OnItemTouchListener {
        final /* synthetic */ GestureDetector val$mGestureDetector;

        C08847(GestureDetector gestureDetector) {
            this.val$mGestureDetector = gestureDetector;
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (child == null || !this.val$mGestureDetector.onTouchEvent(motionEvent)) {
                return false;
            }
            int i;
            MainActivity.this.drawerLayout.closeDrawers();
            for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                LinearLayout linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            for (i = 0; i < MainActivity.this.recyclerViewDrawerSettings.getChildCount(); i++) {
                linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            TextView textViewDrawerItemTitle;
            Bundle bundle;
            switch (recyclerView.getChildPosition(child)) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 0) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Artikel ", 0).show();
                    MainActivity.this.timer_iklan("artikel");
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Artikel");
                    }
                    bundle = new Bundle();
                    MainActivity.this.timer_iklan("artikel");
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Artikel.newInstance(bundle)).commit();
                    return true;
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 1) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Jadwal Sholat ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Jadwal Sholat");
                    }
                    MainActivity.this.timer_iklan("jadwal_sholat");
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Jadwal_Sholat.newInstance(new Bundle())).commit();
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 2) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Klik Button LOKASI untuk set kordinat lokasi saat ini ... ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Arah Qiblat");
                    }
                    bundle = new Bundle();
                    MainActivity.this.timer_iklan("arah_qiblat");
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Kompas_Muazzin.newInstance(bundle)).commit();
                    return true;
                default:
                    return true;
            }
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    /* renamed from: org.bpmikc.akm.MainActivity.8 */
    class C08858 implements OnItemTouchListener {
        final /* synthetic */ GestureDetector val$mGestureDetector;

        C08858(GestureDetector gestureDetector) {
            this.val$mGestureDetector = gestureDetector;
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (child == null || !this.val$mGestureDetector.onTouchEvent(motionEvent)) {
                return false;
            }
            int i;
            MainActivity.this.drawerLayout.closeDrawers();
            for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                LinearLayout linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            for (i = 0; i < MainActivity.this.recyclerViewDrawerSettings.getChildCount(); i++) {
                linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            TextView textViewDrawerItemTitle;
            switch (recyclerView.getChildPosition(child)) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 0) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Kewanitaan ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Kewanitaan");
                    }
                    MainActivity.this.timer_iklan("kewanitaan");
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Kewanitaan.newInstance(new Bundle())).commit();
                    return true;
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 1) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Donasi dan Iklan ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Donasi dan Iklan");
                    }
                    MainActivity.this.timer_iklan("donasi_iklan");
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Donasi.newInstance(new Bundle())).commit();
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 2) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Info Transaksi Online ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Transaksi Online");
                    }
                    MainActivity.this.timer_iklan("transaksi_online");
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Transaksi_Online.newInstance(new Bundle())).commit();
                    return true;
                default:
                    return true;
            }
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    /* renamed from: org.bpmikc.akm.MainActivity.9 */
    class C08869 implements OnItemTouchListener {
        final /* synthetic */ GestureDetector val$mGestureDetector;

        C08869(GestureDetector gestureDetector) {
            this.val$mGestureDetector = gestureDetector;
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (child == null || !this.val$mGestureDetector.onTouchEvent(motionEvent)) {
                return false;
            }
            int i;
            MainActivity.this.drawerLayout.closeDrawers();
            for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                LinearLayout linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                ((TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle)).setTextColor(MainActivity.this.textColorPrimary);
                linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
            }
            TextView textViewDrawerItemTitle;
            Bundle bundle;
            switch (recyclerView.getChildPosition(child)) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawerSettings.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 0) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Tampilan ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Tampilan");
                    }
                    bundle = new Bundle();
                    MainActivity.this.timer_iklan("option_tampilan");
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Setting.newInstance(bundle)).commit();
                    return true;
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    for (i = 0; i < MainActivity.this.recyclerViewDrawerSettings.getChildCount(); i++) {
                        textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                        linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                        if (i == 1) {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                        } else {
                            textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                            linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                        }
                    }
                    Toast.makeText(MainActivity.this, "Menu Beri Masukan ", 0).show();
                    if (MainActivity.this.getSupportActionBar() != null) {
                        MainActivity.this.getSupportActionBar().setTitle((CharSequence) "Saran & Masukan");
                    }
                    bundle = new Bundle();
                    MainActivity.this.timer_iklan("beri_masukan");
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Faq_Masukan.newInstance(bundle)).commit();
                    return true;
                default:
                    return true;
            }
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    public MainActivity() {
        this.server_path = "http://195.110.58.111/ikcv20";
        this.server_path_target = "http://195.110.58.111/ikcv20";
        this.count = 0;
        this.f12a = 0;
        this.imageArray_url = new String[0];
        this.id_rec = BuildConfig.FLAVOR;
        this.menu = BuildConfig.FLAVOR;
        this.status = BuildConfig.FLAVOR;
        this.url_iklan = BuildConfig.FLAVOR;
        this.durasi = BuildConfig.FLAVOR;
        this.flag_01 = BuildConfig.FLAVOR;
        this.flag_02 = BuildConfig.FLAVOR;
        this.flag_03 = BuildConfig.FLAVOR;
        this.image_iklan = BuildConfig.FLAVOR;
        this.ik = 0;
        this.handler = new Handler();
    }

    protected void onCreate(Bundle savedInstanceState) {
        setupTheme();
        super.onCreate(savedInstanceState);
        setContentView((int) C0615R.layout.activity_main);
        this.mPreferences = Preferences.getInstance(this);
        this.toolbar = (Toolbar) findViewById(C0615R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle((CharSequence) "Masjid v2.1");
        this.statusBar = (FrameLayout) findViewById(C0615R.id.statusBar);
        MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());
        setupNavigationDrawer();
        setupButtons();
        SharedPreferences pref = getSharedPreferences("MyPrefs", 0);
        Editor edit = pref.edit();
        edit.putString("server_path", this.server_path_target);
        edit.commit();
        this.server_path = pref.getString("server_path", BuildConfig.FLAVOR);
        getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, Frg_Home.newInstance(this.bundle)).commit();
        timer_iklan("home");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0615R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C0615R.id.action_settings:
                showToast("Mengubah Tampilan Warna Aplikasi ...");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle((CharSequence) "Tampilan");
                }
                Bundle bundle = new Bundle();
                timer_iklan("option_tampilan");
                getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.enter_from_right, C0615R.anim.exit_to_right, C0615R.anim.enter_from_right, C0615R.anim.exit_to_right).replace(C0615R.id.main_activity_content_frame, Frg_Setting.newInstance(bundle)).commit();
                break;
            case C0615R.id.action_help:
                showToast("Bantuan Penggunaan Aplikasi ...");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle((CharSequence) "Bantuan");
                }
                timer_iklan("option_bantuan");
                getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.enter_from_right, C0615R.anim.exit_to_right, C0615R.anim.enter_from_right, C0615R.anim.exit_to_right).replace(C0615R.id.main_activity_content_frame, Frg_Bantuan.newInstance(new Bundle())).commit();
                break;
            case C0615R.id.action_about:
                showToast("Info Terkait Aplikasi ...");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle((CharSequence) "Info Aplikasi");
                }
                timer_iklan("option_aplikasi");
                getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.enter_from_right, C0615R.anim.exit_to_right, C0615R.anim.enter_from_right, C0615R.anim.exit_to_right).replace(C0615R.id.main_activity_content_frame, Frg_Info_Aplikasi.newInstance(new Bundle())).commit();
                break;
            case C0615R.id.action_exit:
                DialogInterface.OnClickListener dialogClickListener = new C06091();
                new Builder(this).setMessage("Akan Keluar Aplikasi Masjid ?").setPositiveButton("Ya", dialogClickListener).setNegativeButton("Tidak", dialogClickListener).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setupTheme() {
        /*
        r4 = this;
        r0 = 0;
        r1 = "VALUES";
        r1 = r4.getSharedPreferences(r1, r0);
        r4.sharedPreferences = r1;
        r1 = r4.sharedPreferences;
        r2 = "THEME";
        r3 = "REDLIGHT";
        r2 = r1.getString(r2, r3);
        r1 = -1;
        r3 = r2.hashCode();
        switch(r3) {
            case 8986405: goto L_0x0020;
            case 14885192: goto L_0x003d;
            case 469056868: goto L_0x0033;
            case 1801159527: goto L_0x0029;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = r1;
    L_0x001c:
        switch(r0) {
            case 0: goto L_0x0047;
            case 1: goto L_0x004e;
            case 2: goto L_0x0055;
            case 3: goto L_0x005c;
            default: goto L_0x001f;
        };
    L_0x001f:
        return;
    L_0x0020:
        r3 = "REDLIGHT";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x001b;
    L_0x0028:
        goto L_0x001c;
    L_0x0029:
        r0 = "REDDARK";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x001b;
    L_0x0031:
        r0 = 1;
        goto L_0x001c;
    L_0x0033:
        r0 = "INDIGOLIGHT";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x001b;
    L_0x003b:
        r0 = 2;
        goto L_0x001c;
    L_0x003d:
        r0 = "INDIGODARK";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x001b;
    L_0x0045:
        r0 = 3;
        goto L_0x001c;
    L_0x0047:
        r0 = 2131296306; // 0x7f090032 float:1.8210525E38 double:1.053000286E-314;
        r4.setTheme(r0);
        goto L_0x001f;
    L_0x004e:
        r0 = 2131296305; // 0x7f090031 float:1.8210523E38 double:1.0530002854E-314;
        r4.setTheme(r0);
        goto L_0x001f;
    L_0x0055:
        r0 = 2131296304; // 0x7f090030 float:1.821052E38 double:1.053000285E-314;
        r4.setTheme(r0);
        goto L_0x001f;
    L_0x005c:
        r0 = 2131296303; // 0x7f09002f float:1.8210519E38 double:1.0530002844E-314;
        r4.setTheme(r0);
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bpmikc.akm.MainActivity.setupTheme():void");
    }

    public void setupNavigationDrawer() {
        this.drawerLayout = (DrawerLayout) findViewById(C0615R.id.drawerLayout);
        this.drawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, this.toolbar, C0615R.string.drawer_open, C0615R.string.drawer_close);
        this.drawerLayout.setDrawerListener(this.drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.drawerToggle.syncState();
        String server_path = getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
        String urlPictureMain = server_path + "/app_files/sujud.png";
        String urlCoverMain = server_path + "/app_files/masjid.jpg";
        String urlPictureSecond = server_path + "/app_files/bulanbintang.jpg";
        ImageView imageViewPictureMain = (ImageView) findViewById(C0615R.id.imageViewPictureMain);
        ImageView imageViewPictureSecond = (ImageView) findViewById(C0615R.id.imageViewPictureSecond);
        Glide.with(getApplicationContext()).load(urlCoverMain).into((ImageView) findViewById(C0615R.id.imageViewCover));
        Glide.with(getApplicationContext()).load(urlPictureMain).asBitmap().transform(new CropCircleTransform(getApplicationContext())).into(imageViewPictureMain);
        Glide.with(getApplicationContext()).load(urlPictureSecond).asBitmap().transform(new CropCircleTransform(getApplicationContext())).into(imageViewPictureSecond);
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(C0615R.attr.colorPrimaryDark, typedValue, true);
        this.drawerLayout.setStatusBarBackgroundColor(typedValue.data);
        this.toggleButtonDrawer = (ToggleButton) findViewById(C0615R.id.toggleButtonDrawer);
        this.toggleButtonDrawer.setOnClickListener(this);
        hideNavigationDrawerSettingsAndFeedbackOnScroll();
        setupNavigationDrawerRecyclerViews();
    }

    public void setupButtons() {
    }

    private void hideNavigationDrawerSettingsAndFeedbackOnScroll() {
        this.scrollViewNavigationDrawerContent = (ScrollView) findViewById(C0615R.id.scrollViewNavigationDrawerContent);
        this.relativeLayoutScrollViewChild = (RelativeLayout) findViewById(C0615R.id.relativeLayoutScrollViewChild);
        this.frameLayoutSetting1 = (FrameLayout) findViewById(C0615R.id.frameLayoutSettings1);
        this.viewTreeObserverNavigationDrawerScrollView = this.relativeLayoutScrollViewChild.getViewTreeObserver();
        if (this.viewTreeObserverNavigationDrawerScrollView.isAlive()) {
            this.viewTreeObserverNavigationDrawerScrollView.addOnGlobalLayoutListener(new C06102());
        }
        this.onScrollChangedListener = new C06123();
        this.scrollViewNavigationDrawerContent.setOnTouchListener(new C06134());
    }

    private void setupNavigationDrawerRecyclerViews() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle((CharSequence) "Assalamu'alaikum");
        }
        this.recyclerViewDrawer1 = (RecyclerView) findViewById(C0615R.id.recyclerViewDrawer1);
        this.linearLayoutManager = new LinearLayoutManager(this);
        this.recyclerViewDrawer1.setLayoutManager(this.linearLayoutManager);
        this.drawerItems1 = new ArrayList();
        this.drawerItems1.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_home), "Home"));
        this.drawerItems1.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_lokasi_masjid), "Lokasi Masjid"));
        this.drawerItems1.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_tambah), "Tambah Masjid"));
        this.drawerItems1.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_cari_masjid), "Cari Masjid"));
        this.drawerAdapter1 = new DrawerAdapter(this.drawerItems1);
        this.recyclerViewDrawer1.setAdapter(this.drawerAdapter1);
        this.recyclerViewDrawer1.setMinimumHeight(convertDpToPx(200));
        this.recyclerViewDrawer1.setHasFixedSize(true);
        GestureDetector mGestureDetector = new GestureDetector(this, new C06145());
        this.recyclerViewDrawer1.addOnItemTouchListener(new C08836(mGestureDetector));
        this.recyclerViewDrawer2 = (RecyclerView) findViewById(C0615R.id.recyclerViewDrawer2);
        this.linearLayoutManager2 = new LinearLayoutManager(this);
        this.recyclerViewDrawer2.setLayoutManager(this.linearLayoutManager2);
        this.drawerItems2 = new ArrayList();
        this.drawerItems2.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_content_drafts), "Artikel"));
        this.drawerItems2.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_content_send), "Jadwal Sholat"));
        this.drawerItems2.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_social_notifications_on), "Qiblat"));
        this.drawerAdapter2 = new DrawerAdapter(this.drawerItems2);
        this.recyclerViewDrawer2.setAdapter(this.drawerAdapter2);
        this.recyclerViewDrawer2.setMinimumHeight(convertDpToPx(144));
        this.recyclerViewDrawer2.setHasFixedSize(true);
        this.recyclerViewDrawer2.addOnItemTouchListener(new C08847(mGestureDetector));
        this.recyclerViewDrawer3 = (RecyclerView) findViewById(C0615R.id.recyclerViewDrawer3);
        this.linearLayoutManager3 = new LinearLayoutManager(this);
        this.recyclerViewDrawer3.setLayoutManager(this.linearLayoutManager3);
        this.drawerItems3 = new ArrayList();
        this.drawerItems3.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_kewanitaan), "Kewanitaan"));
        this.drawerItems3.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_action_label), "Donasi dan Iklan "));
        this.drawerItems3.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_online), "Transaksi Online"));
        this.drawerAdapter3 = new DrawerAdapter(this.drawerItems3);
        this.recyclerViewDrawer3.setAdapter(this.drawerAdapter3);
        this.recyclerViewDrawer3.setMinimumHeight(convertDpToPx(144));
        this.recyclerViewDrawer3.setHasFixedSize(true);
        this.recyclerViewDrawer3.addOnItemTouchListener(new C08858(mGestureDetector));
        this.recyclerViewDrawerSettings = (RecyclerView) findViewById(C0615R.id.recyclerViewDrawerSettings);
        this.linearLayoutManagerSettings = new LinearLayoutManager(this);
        this.recyclerViewDrawerSettings.setLayoutManager(this.linearLayoutManagerSettings);
        this.drawerItemsSettings = new ArrayList();
        this.drawerItemsSettings.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_action_settings), "Tampilan"));
        this.drawerItemsSettings.add(new DrawerItem(getResources().getDrawable(C0615R.drawable.ic_action_action_help), "Beri Masukan"));
        this.drawerAdapterSettings = new DrawerAdapter(this.drawerItemsSettings);
        this.recyclerViewDrawerSettings.setAdapter(this.drawerAdapterSettings);
        this.recyclerViewDrawerSettings.setMinimumHeight(convertDpToPx(96));
        this.recyclerViewDrawerSettings.setHasFixedSize(true);
        this.recyclerViewDrawerSettings.addOnItemTouchListener(new C08869(mGestureDetector));
        this.typedValueColorPrimary = new TypedValue();
        getTheme().resolveAttribute(C0615R.attr.colorPrimary, this.typedValueColorPrimary, true);
        this.colorPrimary = this.typedValueColorPrimary.data;
        this.typedValueTextColorPrimary = new TypedValue();
        getTheme().resolveAttribute(16842806, this.typedValueTextColorPrimary, true);
        this.textColorPrimary = this.typedValueTextColorPrimary.data;
        this.typedValueTextColorControlHighlight = new TypedValue();
        getTheme().resolveAttribute(C0615R.attr.colorControlHighlight, this.typedValueTextColorControlHighlight, true);
        this.colorControlHighlight = this.typedValueTextColorControlHighlight.data;
        this.typedValueColorBackground = new TypedValue();
        getTheme().resolveAttribute(16842801, this.typedValueColorBackground, true);
        this.colorBackground = this.typedValueColorBackground.data;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                int i;
                for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    if (i == 0) {
                        imageViewDrawerItemIcon.setColorFilter(MainActivity.this.colorPrimary);
                        if (VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(MotionEventCompat.ACTION_MASK);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(MotionEventCompat.ACTION_MASK);
                        }
                        textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                        linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                    } else {
                        imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                        if (VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(138);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(138);
                        }
                        textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                        linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                    }
                }
                for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                    imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                    if (VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                    linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                }
                for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                    imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                    if (VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(67);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(67);
                    }
                    textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                    linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                }
                for (i = 0; i < MainActivity.this.recyclerViewDrawerSettings.getChildCount(); i++) {
                    imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawerSettings.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                    if (VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                    linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                }
                ImageView imageViewSettingsIcon = (ImageView) MainActivity.this.findViewById(C0615R.id.imageViewSettingsIcon);
                TextView textViewSettingsTitle = (TextView) MainActivity.this.findViewById(C0615R.id.textViewSettingsTitle);
                imageViewSettingsIcon.setColorFilter(MainActivity.this.textColorPrimary);
                if (VERSION.SDK_INT > 15) {
                    imageViewSettingsIcon.setImageAlpha(138);
                } else {
                    imageViewSettingsIcon.setAlpha(138);
                }
                textViewSettingsTitle.setTextColor(MainActivity.this.textColorPrimary);
                ImageView imageViewHelpIcon = (ImageView) MainActivity.this.findViewById(C0615R.id.imageViewHelpIcon);
                TextView textViewHelpTitle = (TextView) MainActivity.this.findViewById(C0615R.id.textViewHelpTitle);
                imageViewHelpIcon.setColorFilter(MainActivity.this.textColorPrimary);
                if (VERSION.SDK_INT > 15) {
                    imageViewHelpIcon.setImageAlpha(138);
                } else {
                    imageViewHelpIcon.setAlpha(138);
                }
                textViewHelpTitle.setTextColor(MainActivity.this.textColorPrimary);
            }
        }, 250);
        this.itemClickSupport1 = ItemClickSupport.addTo(this.recyclerViewDrawer1);
        this.itemClickSupport1.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(RecyclerView parent, View view, int position, long id) {
                int i;
                for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    if (i == position) {
                        imageViewDrawerItemIcon.setColorFilter(MainActivity.this.colorPrimary);
                        if (VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(MotionEventCompat.ACTION_MASK);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(MotionEventCompat.ACTION_MASK);
                        }
                        textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                        linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                    } else {
                        imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                        if (VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(138);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(138);
                        }
                        textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                        linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                    }
                }
                for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                    imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                    if (VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                    linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                }
                for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                    imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                    textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                    if (VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(67);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(67);
                    }
                    linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                }
            }
        });
        this.itemClickSupport2 = ItemClickSupport.addTo(this.recyclerViewDrawer2);
        this.itemClickSupport2.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(RecyclerView parent, View view, int position, long id) {
                int i;
                for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    if (i == position) {
                        imageViewDrawerItemIcon.setColorFilter(MainActivity.this.colorPrimary);
                        if (VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(MotionEventCompat.ACTION_MASK);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(MotionEventCompat.ACTION_MASK);
                        }
                        textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                        linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                    } else {
                        imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                        if (VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(138);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(138);
                        }
                        textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                        linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                    }
                }
                for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                    imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                    if (VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                    linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                }
                for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                    imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                    if (VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(67);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(67);
                    }
                    textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                    linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                }
            }
        });
        this.itemClickSupport3 = ItemClickSupport.addTo(this.recyclerViewDrawer3);
        this.itemClickSupport3.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(RecyclerView parent, View view, int position, long id) {
                int i;
                for (i = 0; i < MainActivity.this.recyclerViewDrawer3.getChildCount(); i++) {
                    ImageView imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    TextView textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    LinearLayout linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer3.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    if (i == position) {
                        imageViewDrawerItemIcon.setColorFilter(MainActivity.this.colorPrimary);
                        if (VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(138);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(138);
                        }
                        textViewDrawerItemTitle.setTextColor(MainActivity.this.colorPrimary);
                        linearLayoutItem.setBackgroundColor(MainActivity.this.colorControlHighlight);
                    } else {
                        imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                        if (VERSION.SDK_INT > 15) {
                            imageViewDrawerItemIcon.setImageAlpha(67);
                        } else {
                            imageViewDrawerItemIcon.setAlpha(67);
                        }
                        textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                        linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                    }
                }
                for (i = 0; i < MainActivity.this.recyclerViewDrawer1.getChildCount(); i++) {
                    imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer1.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                    if (VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                    linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                }
                for (i = 0; i < MainActivity.this.recyclerViewDrawer2.getChildCount(); i++) {
                    imageViewDrawerItemIcon = (ImageView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.imageViewDrawerItemIcon);
                    textViewDrawerItemTitle = (TextView) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.textViewDrawerItemTitle);
                    linearLayoutItem = (LinearLayout) MainActivity.this.recyclerViewDrawer2.getChildAt(i).findViewById(C0615R.id.linearLayoutItem);
                    imageViewDrawerItemIcon.setColorFilter(MainActivity.this.textColorPrimary);
                    if (VERSION.SDK_INT > 15) {
                        imageViewDrawerItemIcon.setImageAlpha(138);
                    } else {
                        imageViewDrawerItemIcon.setAlpha(138);
                    }
                    textViewDrawerItemTitle.setTextColor(MainActivity.this.textColorPrimary);
                    linearLayoutItem.setBackgroundColor(MainActivity.this.colorBackground);
                }
            }
        });
    }

    public void onClick(View v) {
        this.sharedPreferences = getSharedPreferences("VALUES", 0);
        Intent intent = new Intent(this, MainActivity.class);
        switch (v.getId()) {
            case C0615R.id.buttonRedLight:
                this.sharedPreferences.edit().putString("THEME", "REDLIGHT").apply();
                startActivity(intent);
            case C0615R.id.buttonIndigoLight:
                this.sharedPreferences.edit().putString("THEME", "INDIGOLIGHT").apply();
                startActivity(intent);
            case C0615R.id.buttonRedDark:
                this.sharedPreferences.edit().putString("THEME", "REDDARK").apply();
                startActivity(intent);
            case C0615R.id.buttonIndigoDark:
                this.sharedPreferences.edit().putString("THEME", "INDIGODARK").apply();
                startActivity(intent);
            case C0615R.id.toggleButtonDrawer:
                this.linearLayoutDrawerAccount = (LinearLayout) findViewById(C0615R.id.linearLayoutDrawerAccounts);
                this.linearLayoutDrawerMain = (LinearLayout) findViewById(C0615R.id.linearLayoutDrawerMain);
                this.imageViewDrawerArrowUpDown = (ImageView) findViewById(C0615R.id.imageViewDrawerArrowUpDown);
                this.frameLayoutSetting1 = (FrameLayout) findViewById(C0615R.id.frameLayoutSettings1);
                Animation animation;
                if (this.linearLayoutDrawerAccount.getVisibility() == 0) {
                    this.linearLayoutDrawerAccount.setVisibility(8);
                    this.linearLayoutDrawerMain.setVisibility(0);
                    if (this.frameLayoutSetting1.getVisibility() == 0) {
                        this.frameLayoutSetting1.setVisibility(8);
                    } else {
                        hideNavigationDrawerSettingsAndFeedbackOnScroll();
                    }
                    animation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
                    animation.setFillAfter(true);
                    animation.setDuration(500);
                    this.imageViewDrawerArrowUpDown.startAnimation(animation);
                    this.imageViewDrawerArrowUpDown.setBackgroundResource(C0615R.drawable.ic_navigation_arrow_drop_up);
                } else {
                    this.linearLayoutDrawerAccount.setVisibility(0);
                    this.linearLayoutDrawerMain.setVisibility(8);
                    animation = new RotateAnimation(0.0f, BitmapDescriptorFactory.HUE_CYAN, 1, 0.5f, 1, 0.5f);
                    animation.setFillAfter(true);
                    animation.setDuration(500);
                    this.imageViewDrawerArrowUpDown.startAnimation(animation);
                    this.imageViewDrawerArrowUpDown.setBackgroundResource(C0615R.drawable.ic_navigation_arrow_drop_down);
                }
                if (this.frameLayoutSetting1.getVisibility() == 0) {
                    this.frameLayoutSetting1.setVisibility(8);
                } else {
                    hideNavigationDrawerSettingsAndFeedbackOnScroll();
                }
            default:
        }
    }

    public int convertDpToPx(int dp) {
        return (int) ((((float) dp) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, 0).show();
    }

    private void timer_iklan(String smenu) {
        String fsmenu = smenu;
        String server_path = getApplication().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
        Volley.newRequestQueue(getApplication()).add(new JsonObjectRequest(0, server_path + "/app_mobiles/get_kriteria_iklan.php?kriteria=" + smenu, null, new AnonymousClass14(server_path, (ImageView) findViewById(C0615R.id.view_iklan)), new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }));
    }
}
