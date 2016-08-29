package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    /* renamed from: com.google.android.gms.tagmanager.PreviewActivity.1 */
    class C04371 implements OnClickListener {
        final /* synthetic */ PreviewActivity zzaQX;

        C04371(PreviewActivity previewActivity) {
            this.zzaQX = previewActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    private void zzj(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C04371(this));
        create.show();
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            zzbg.zzaD("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).zzm(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                zzbg.zzaE(str);
                zzj("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                zzbg.zzaD("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            zzbg.zzaD("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            zzbg.m16e("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
