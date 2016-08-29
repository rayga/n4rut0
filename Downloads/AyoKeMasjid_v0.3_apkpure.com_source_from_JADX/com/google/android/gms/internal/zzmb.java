package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzi;
import com.google.android.gms.drive.metadata.internal.zzj;
import com.google.android.gms.drive.metadata.internal.zzl;
import com.google.android.gms.drive.metadata.internal.zzn;
import com.google.android.gms.drive.metadata.internal.zzo;
import com.google.android.gms.drive.metadata.internal.zzp;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzmb {
    public static final MetadataField<Boolean> zzakA;
    public static final MetadataField<Boolean> zzakB;
    public static final MetadataField<Boolean> zzakC;
    public static final zzb zzakD;
    public static final MetadataField<Boolean> zzakE;
    public static final MetadataField<Boolean> zzakF;
    public static final MetadataField<Boolean> zzakG;
    public static final MetadataField<Boolean> zzakH;
    public static final MetadataField<Boolean> zzakI;
    public static final MetadataField<Boolean> zzakJ;
    public static final MetadataField<Boolean> zzakK;
    public static final zzc zzakL;
    public static final MetadataField<String> zzakM;
    public static final com.google.android.gms.drive.metadata.zzb<String> zzakN;
    public static final zzp zzakO;
    public static final zzp zzakP;
    public static final zzl zzakQ;
    public static final zzd zzakR;
    public static final zzf zzakS;
    public static final MetadataField<BitmapTeleporter> zzakT;
    public static final zzg zzakU;
    public static final zzh zzakV;
    public static final MetadataField<String> zzakW;
    public static final MetadataField<String> zzakX;
    public static final MetadataField<String> zzakY;
    public static final com.google.android.gms.drive.metadata.internal.zzb zzakZ;
    public static final MetadataField<DriveId> zzako;
    public static final MetadataField<String> zzakp;
    public static final zza zzakq;
    public static final MetadataField<String> zzakr;
    public static final MetadataField<String> zzaks;
    public static final MetadataField<String> zzakt;
    public static final MetadataField<Long> zzaku;
    public static final MetadataField<String> zzakv;
    public static final MetadataField<Boolean> zzakw;
    public static final MetadataField<String> zzakx;
    public static final MetadataField<Boolean> zzaky;
    public static final MetadataField<Boolean> zzakz;
    public static final MetadataField<String> zzala;
    public static final MetadataField<String> zzalb;
    public static final zze zzalc;

    /* renamed from: com.google.android.gms.internal.zzmb.1 */
    static class C11801 extends com.google.android.gms.drive.metadata.internal.zzb {
        C11801(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zze(dataHolder, i, i2);
        }

        protected Boolean zze(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc("trashed", i, i2) == 2);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmb.2 */
    static class C11812 extends zzj<BitmapTeleporter> {
        C11812(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zzk(dataHolder, i, i2);
        }

        protected BitmapTeleporter zzk(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public static class zzc extends zzo implements SearchableMetadataField<String> {
        public zzc(int i) {
            super("mimeType", i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzg implements SortableMetadataField<Long> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzf(String str, int i) {
            super(str, i);
        }
    }

    public static class zzg extends zzo implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public zzg(String str, int i) {
            super(str, i);
        }
    }

    public static class zzh extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzh(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zze(dataHolder, i, i2);
        }

        protected Boolean zze(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc(getName(), i, i2) != 0);
        }
    }

    public static class zza extends zzmc implements SearchableMetadataField<AppVisibleCustomProperties> {
        public zza(int i) {
            super(i);
        }
    }

    public static class zze extends zzi<DriveSpace> {
        public zze(int i) {
            super("spaces", Arrays.asList(new String[]{"inDriveSpace", "isAppData", "inGooglePhotosSpace"}), Collections.emptySet(), i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zzd(dataHolder, i, i2);
        }

        protected Collection<DriveSpace> zzd(DataHolder dataHolder, int i, int i2) {
            Collection arrayList = new ArrayList();
            if (dataHolder.zze("inDriveSpace", i, i2)) {
                arrayList.add(DriveSpace.zzagH);
            }
            if (dataHolder.zze("isAppData", i, i2)) {
                arrayList.add(DriveSpace.zzagI);
            }
            if (dataHolder.zze("inGooglePhotosSpace", i, i2)) {
                arrayList.add(DriveSpace.zzagJ);
            }
            return arrayList;
        }
    }

    static {
        zzako = zzme.zzali;
        zzakp = new zzo("alternateLink", 4300000);
        zzakq = new zza(5000000);
        zzakr = new zzo(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
        zzaks = new zzo("embedLink", 4300000);
        zzakt = new zzo("fileExtension", 4300000);
        zzaku = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 4300000);
        zzakv = new zzo("folderColorRgb", 7500000);
        zzakw = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
        zzakx = new zzo("indexableText", 4300000);
        zzaky = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
        zzakz = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
        zzakA = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
        zzakB = new C11801("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000);
        zzakC = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
        zzakD = new zzb("isPinned", 4100000);
        zzakE = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
        zzakF = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
        zzakG = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
        zzakH = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
        zzakI = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
        zzakJ = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
        zzakK = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
        zzakL = new zzc(4100000);
        zzakM = new zzo("originalFilename", 4300000);
        zzakN = new zzn("ownerNames", 4300000);
        zzakO = new zzp("lastModifyingUser", 6000000);
        zzakP = new zzp("sharingUser", 6000000);
        zzakQ = new zzl(4100000);
        zzakR = new zzd("quotaBytesUsed", 4300000);
        zzakS = new zzf("starred", 4100000);
        zzakT = new C11812("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000);
        zzakU = new zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
        zzakV = new zzh("trashed", 4100000);
        zzakW = new zzo("webContentLink", 4300000);
        zzakX = new zzo("webViewLink", 4300000);
        zzakY = new zzo("uniqueIdentifier", 5000000);
        zzakZ = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
        zzala = new zzo("role", 6000000);
        zzalb = new zzo("md5Checksum", 7000000);
        zzalc = new zze(7000000);
    }
}
