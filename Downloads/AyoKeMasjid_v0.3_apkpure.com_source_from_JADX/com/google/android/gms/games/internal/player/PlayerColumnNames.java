package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames {
    public final String title;
    public final String zzawR;
    public final String zzawS;
    public final String zzawT;
    public final String zzawU;
    public final String zzawV;
    public final String zzawW;
    public final String zzawX;
    public final String zzawY;
    public final String zzawZ;
    public final String zzaxa;
    public final String zzaxb;
    public final String zzaxc;
    public final String zzaxd;
    public final String zzaxe;
    public final String zzaxf;
    public final String zzaxg;
    public final String zzaxh;
    public final String zzaxi;
    public final String zzaxj;
    public final String zzaxk;
    public final String zzaxl;
    public final String zzaxm;
    public final String zzaxn;
    public final String zzaxo;
    public final String zzaxp;

    public PlayerColumnNames(String prefix) {
        if (TextUtils.isEmpty(prefix)) {
            this.zzawR = "external_player_id";
            this.zzawS = "profile_name";
            this.zzawT = "profile_icon_image_uri";
            this.zzawU = "profile_icon_image_url";
            this.zzawV = "profile_hi_res_image_uri";
            this.zzawW = "profile_hi_res_image_url";
            this.zzawX = "last_updated";
            this.zzawY = "is_in_circles";
            this.zzawZ = "played_with_timestamp";
            this.zzaxa = "current_xp_total";
            this.zzaxb = "current_level";
            this.zzaxc = "current_level_min_xp";
            this.zzaxd = "current_level_max_xp";
            this.zzaxe = "next_level";
            this.zzaxf = "next_level_max_xp";
            this.zzaxg = "last_level_up_timestamp";
            this.title = "player_title";
            this.zzaxh = "has_all_public_acls";
            this.zzaxi = "is_profile_visible";
            this.zzaxj = "most_recent_external_game_id";
            this.zzaxk = "most_recent_game_name";
            this.zzaxl = "most_recent_activity_timestamp";
            this.zzaxm = "most_recent_game_icon_uri";
            this.zzaxn = "most_recent_game_hi_res_uri";
            this.zzaxo = "most_recent_game_featured_uri";
            this.zzaxp = "has_debug_access";
            return;
        }
        this.zzawR = prefix + "external_player_id";
        this.zzawS = prefix + "profile_name";
        this.zzawT = prefix + "profile_icon_image_uri";
        this.zzawU = prefix + "profile_icon_image_url";
        this.zzawV = prefix + "profile_hi_res_image_uri";
        this.zzawW = prefix + "profile_hi_res_image_url";
        this.zzawX = prefix + "last_updated";
        this.zzawY = prefix + "is_in_circles";
        this.zzawZ = prefix + "played_with_timestamp";
        this.zzaxa = prefix + "current_xp_total";
        this.zzaxb = prefix + "current_level";
        this.zzaxc = prefix + "current_level_min_xp";
        this.zzaxd = prefix + "current_level_max_xp";
        this.zzaxe = prefix + "next_level";
        this.zzaxf = prefix + "next_level_max_xp";
        this.zzaxg = prefix + "last_level_up_timestamp";
        this.title = prefix + "player_title";
        this.zzaxh = prefix + "has_all_public_acls";
        this.zzaxi = prefix + "is_profile_visible";
        this.zzaxj = prefix + "most_recent_external_game_id";
        this.zzaxk = prefix + "most_recent_game_name";
        this.zzaxl = prefix + "most_recent_activity_timestamp";
        this.zzaxm = prefix + "most_recent_game_icon_uri";
        this.zzaxn = prefix + "most_recent_game_hi_res_uri";
        this.zzaxo = prefix + "most_recent_game_featured_uri";
        this.zzaxp = prefix + "has_debug_access";
    }
}
