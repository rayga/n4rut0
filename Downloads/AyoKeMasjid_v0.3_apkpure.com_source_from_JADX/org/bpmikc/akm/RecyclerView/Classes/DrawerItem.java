package org.bpmikc.akm.RecyclerView.Classes;

import android.graphics.drawable.Drawable;

public class DrawerItem {
    Drawable itemIcon;
    String itemTitle;

    public DrawerItem(Drawable itemIcon, String itemTitle) {
        this.itemIcon = itemIcon;
        this.itemTitle = itemTitle;
    }

    public Drawable getItemIcon() {
        return this.itemIcon;
    }

    public String getItemTitle() {
        return this.itemTitle;
    }
}
