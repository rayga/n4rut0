package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR;
    private static final zza zzabs;
    boolean mClosed;
    private final int mVersionCode;
    private final int zzWu;
    private final String[] zzabk;
    Bundle zzabl;
    private final CursorWindow[] zzabm;
    private final Bundle zzabn;
    int[] zzabo;
    int zzabp;
    private Object zzabq;
    private boolean zzabr;

    public static class zza {
        private final String[] zzabk;
        private final ArrayList<HashMap<String, Object>> zzabt;
        private final String zzabu;
        private final HashMap<Object, Integer> zzabv;
        private boolean zzabw;
        private String zzabx;

        private zza(String[] strArr, String str) {
            this.zzabk = (String[]) zzx.zzv(strArr);
            this.zzabt = new ArrayList();
            this.zzabu = str;
            this.zzabv = new HashMap();
            this.zzabw = false;
            this.zzabx = null;
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.android.gms.common.data.DataHolder.1 */
    static class C07181 extends zza {
        C07181(String[] strArr, String str) {
            super(str, null);
        }
    }

    static {
        CREATOR = new zze();
        zzabs = new C07181(new String[0], null);
    }

    DataHolder(int versionCode, String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzabr = true;
        this.mVersionCode = versionCode;
        this.zzabk = columns;
        this.zzabm = windows;
        this.zzWu = statusCode;
        this.zzabn = metadata;
    }

    private DataHolder(zza builder, int statusCode, Bundle metadata) {
        this(builder.zzabk, zza(builder, -1), statusCode, metadata);
    }

    public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzabr = true;
        this.mVersionCode = 1;
        this.zzabk = (String[]) zzx.zzv(columns);
        this.zzabm = (CursorWindow[]) zzx.zzv(windows);
        this.zzWu = statusCode;
        this.zzabn = metadata;
        zznT();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzabs, i, bundle);
    }

    private static CursorWindow[] zza(zza com_google_android_gms_common_data_DataHolder_zza, int i) {
        int size;
        int i2 = 0;
        if (com_google_android_gms_common_data_DataHolder_zza.zzabk.length == 0) {
            return new CursorWindow[0];
        }
        List zzb = (i < 0 || i >= com_google_android_gms_common_data_DataHolder_zza.zzabt.size()) ? com_google_android_gms_common_data_DataHolder_zza.zzabt : com_google_android_gms_common_data_DataHolder_zza.zzabt.subList(0, i);
        int size2 = zzb.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.zzabk.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            if (!cursorWindow.allocRow()) {
                Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                cursorWindow = new CursorWindow(false);
                cursorWindow.setStartPosition(i3);
                cursorWindow.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.zzabk.length);
                arrayList.add(cursorWindow);
                if (!cursorWindow.allocRow()) {
                    Log.e("DataHolder", "Unable to allocate row to hold data.");
                    arrayList.remove(cursorWindow);
                    return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                }
            }
            try {
                int i5;
                int i6;
                CursorWindow cursorWindow2;
                Map map = (Map) zzb.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < com_google_android_gms_common_data_DataHolder_zza.zzabk.length && z; i7++) {
                    String str = com_google_android_gms_common_data_DataHolder_zza.zzabk[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i7);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i4 != 0) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.zzabk.length);
                    arrayList.add(cursorWindow3);
                    i5 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 1;
                }
                i4 = i6;
                cursorWindow = cursorWindow2;
                i3 = i5 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                size = arrayList.size();
                while (i2 < size) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder zzbp(int i) {
        return zza(i, null);
    }

    private void zzh(String str, int i) {
        if (this.zzabl == null || !this.zzabl.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zzabp) {
            throw new CursorIndexOutOfBoundsException(i, this.zzabp);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzabm) {
                    close.close();
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.zzabr && this.zzabm.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.zzabq == null ? "internal object: " + toString() : this.zzabq.toString()) + ")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzabp;
    }

    public int getStatusCode() {
        return this.zzWu;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzh(str, i);
        this.zzabm[i2].copyStringToBuffer(i, this.zzabl.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getLong(i, this.zzabl.getInt(str));
    }

    public int zzbo(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.zzabp;
        zzx.zzY(z);
        while (i2 < this.zzabo.length) {
            if (i < this.zzabo[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zzabo.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getInt(i, this.zzabl.getInt(str));
    }

    public boolean zzcd(String str) {
        return this.zzabl.containsKey(str);
    }

    public String zzd(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getString(i, this.zzabl.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzh(str, i);
        return Long.valueOf(this.zzabm[i2].getLong(i, this.zzabl.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getFloat(i, this.zzabl.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getBlob(i, this.zzabl.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        return zzd == null ? null : Uri.parse(zzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].isNull(i, this.zzabl.getInt(str));
    }

    public Bundle zznP() {
        return this.zzabn;
    }

    public void zznT() {
        int i;
        int i2 = 0;
        this.zzabl = new Bundle();
        for (i = 0; i < this.zzabk.length; i++) {
            this.zzabl.putInt(this.zzabk[i], i);
        }
        this.zzabo = new int[this.zzabm.length];
        i = 0;
        while (i2 < this.zzabm.length) {
            this.zzabo[i2] = i;
            i += this.zzabm[i2].getNumRows() - (i - this.zzabm[i2].getStartPosition());
            i2++;
        }
        this.zzabp = i;
    }

    String[] zznU() {
        return this.zzabk;
    }

    CursorWindow[] zznV() {
        return this.zzabm;
    }

    public void zzq(Object obj) {
        this.zzabq = obj;
    }
}
