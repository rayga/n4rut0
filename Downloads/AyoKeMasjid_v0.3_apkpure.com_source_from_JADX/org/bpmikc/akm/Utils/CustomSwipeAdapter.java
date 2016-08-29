package org.bpmikc.akm.Utils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;

public class CustomSwipeAdapter extends PagerAdapter {
    private static final String STR_CHILD_TAG_3 = " -> child fragment of tag 3";
    private Context ctx;
    final String[] imageArray_url;
    final String[] image_resources;
    private LayoutInflater layoutInflater;
    private String proses_img_01;
    private String proses_img_02;
    private String proses_img_03;
    private String proses_img_04;
    private String server_path;
    private String url_iklan;
    private String url_proses_img_01;
    private String url_proses_img_02;
    private String url_proses_img_03;
    private String url_proses_img_04;

    public CustomSwipeAdapter(Context ctx) {
        this.server_path = "http://195.110.58.111/ikcv20";
        this.proses_img_01 = this.server_path + "/app_images/header.jpg";
        this.proses_img_02 = this.server_path + "/app_images/relogin.jpg";
        this.proses_img_03 = this.server_path + "/app_images/rekap_jawaban.jpg";
        this.proses_img_04 = this.server_path + "/app_images/contact.jpg";
        this.url_proses_img_01 = this.server_path + "/app_sdss/hasil_content.php?parent_name=yasin_map";
        this.url_proses_img_02 = this.server_path + "/app_sdss/hasil_content.php?parent_name=Manual_book";
        this.url_proses_img_03 = this.server_path + "/app_sdss/hasil_content.php?parent_name=astimen_sumbar";
        this.url_proses_img_04 = this.server_path + "/app_sdss/hasil_content.php?parent_name=info_masjid";
        this.image_resources = new String[]{this.proses_img_01, this.proses_img_02, this.proses_img_03, this.proses_img_04};
        this.imageArray_url = new String[]{this.url_proses_img_01, this.url_proses_img_02, this.url_proses_img_03, this.url_proses_img_04};
        this.url_iklan = BuildConfig.FLAVOR;
        this.ctx = ctx;
    }

    public int getCount() {
        return this.image_resources.length;
    }

    public void set_url_iklan(String url_iklan) {
        this.url_iklan = url_iklan;
    }

    public String get_url_iklan() {
        return this.url_iklan;
    }

    public boolean isViewFromObject(View view, Object o) {
        return view == ((LinearLayout) o);
    }

    public Object instantiateItem(ViewGroup container, int position) {
        this.layoutInflater = (LayoutInflater) this.ctx.getSystemService("layout_inflater");
        View item_view = this.layoutInflater.inflate(C0615R.layout.wipe_layout, container, false);
        Glide.with(container.getContext()).load(this.image_resources[position]).into((ImageView) item_view.findViewById(C0615R.id.image_view2));
        container.addView(item_view);
        set_url_iklan(this.imageArray_url[position]);
        return item_view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
