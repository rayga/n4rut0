package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqp.zzc;
import com.google.android.gms.internal.zzqp.zzd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzaz {
    private static zza zzD(Object obj) throws JSONException {
        return zzdf.zzK(zzE(obj));
    }

    static Object zzE(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, zzE(jSONObject.get(str)));
            }
            return hashMap;
        }
    }

    public static zzc zzeN(String str) throws JSONException {
        zza zzD = zzD(new JSONObject(str));
        zzd zzBF = zzc.zzBF();
        for (int i = 0; i < zzD.zziW.length; i++) {
            zzBF.zzc(zzqp.zza.zzBC().zzb(zzae.INSTANCE_NAME.toString(), zzD.zziW[i]).zzb(zzae.FUNCTION.toString(), zzdf.zzeY(zzn.zzzA())).zzb(zzn.zzzB(), zzD.zziX[i]).zzBE());
        }
        return zzBF.zzBI();
    }
}
