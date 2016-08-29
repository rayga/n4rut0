package org.bpmikc.akm.RecyclerView.Adapters;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import org.bpmikc.akm.C0615R;
import org.bpmikc.akm.RecyclerView.Classes.DrawerItem;

public class DrawerAdapter extends Adapter<ViewHolder> {
    private ArrayList<DrawerItem> drawerItems;

    public static class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public DrawerAdapter(ArrayList<DrawerItem> drawerItems) {
        this.drawerItems = drawerItems;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(C0615R.layout.drawer_item, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageView itemIcon = (ImageView) holder.itemView.findViewById(C0615R.id.imageViewDrawerItemIcon);
        ((TextView) holder.itemView.findViewById(C0615R.id.textViewDrawerItemTitle)).setText(((DrawerItem) this.drawerItems.get(position)).getItemTitle());
        itemIcon.setImageDrawable(((DrawerItem) this.drawerItems.get(position)).getItemIcon());
    }

    public int getItemCount() {
        return this.drawerItems.size();
    }
}
