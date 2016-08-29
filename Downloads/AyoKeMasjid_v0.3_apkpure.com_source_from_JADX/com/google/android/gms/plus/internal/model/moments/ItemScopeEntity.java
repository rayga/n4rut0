package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bpmikc.akm.Fragment.Frg_Qiblat_Map;

public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR;
    private static final HashMap<String, Field<?, ?>> zzaLS;
    String mName;
    final int mVersionCode;
    String zzF;
    String zzFz;
    double zzaBD;
    double zzaBE;
    final Set<Integer> zzaLT;
    ItemScopeEntity zzaLU;
    List<String> zzaLV;
    ItemScopeEntity zzaLW;
    String zzaLX;
    String zzaLY;
    String zzaLZ;
    List<ItemScopeEntity> zzaMA;
    String zzaMB;
    String zzaMC;
    String zzaMD;
    String zzaME;
    ItemScopeEntity zzaMF;
    String zzaMG;
    String zzaMH;
    String zzaMI;
    ItemScopeEntity zzaMJ;
    String zzaMK;
    String zzaML;
    String zzaMM;
    String zzaMN;
    List<ItemScopeEntity> zzaMa;
    int zzaMb;
    List<ItemScopeEntity> zzaMc;
    ItemScopeEntity zzaMd;
    List<ItemScopeEntity> zzaMe;
    String zzaMf;
    String zzaMg;
    ItemScopeEntity zzaMh;
    String zzaMi;
    String zzaMj;
    List<ItemScopeEntity> zzaMk;
    String zzaMl;
    String zzaMm;
    String zzaMn;
    String zzaMo;
    String zzaMp;
    String zzaMq;
    String zzaMr;
    String zzaMs;
    ItemScopeEntity zzaMt;
    String zzaMu;
    String zzaMv;
    String zzaMw;
    ItemScopeEntity zzaMx;
    ItemScopeEntity zzaMy;
    ItemScopeEntity zzaMz;
    String zzaoB;
    String zzsV;
    String zzwj;

    static {
        CREATOR = new zza();
        zzaLS = new HashMap();
        zzaLS.put("about", Field.zza("about", 2, ItemScopeEntity.class));
        zzaLS.put("additionalName", Field.zzn("additionalName", 3));
        zzaLS.put("address", Field.zza("address", 4, ItemScopeEntity.class));
        zzaLS.put("addressCountry", Field.zzm("addressCountry", 5));
        zzaLS.put("addressLocality", Field.zzm("addressLocality", 6));
        zzaLS.put("addressRegion", Field.zzm("addressRegion", 7));
        zzaLS.put("associated_media", Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzaLS.put("attendeeCount", Field.zzj("attendeeCount", 9));
        zzaLS.put("attendees", Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzaLS.put("audio", Field.zza("audio", 11, ItemScopeEntity.class));
        zzaLS.put("author", Field.zzb("author", 12, ItemScopeEntity.class));
        zzaLS.put("bestRating", Field.zzm("bestRating", 13));
        zzaLS.put("birthDate", Field.zzm("birthDate", 14));
        zzaLS.put("byArtist", Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzaLS.put("caption", Field.zzm("caption", 16));
        zzaLS.put("contentSize", Field.zzm("contentSize", 17));
        zzaLS.put("contentUrl", Field.zzm("contentUrl", 18));
        zzaLS.put("contributor", Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzaLS.put("dateCreated", Field.zzm("dateCreated", 20));
        zzaLS.put("dateModified", Field.zzm("dateModified", 21));
        zzaLS.put("datePublished", Field.zzm("datePublished", 22));
        zzaLS.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, Field.zzm(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        zzaLS.put("duration", Field.zzm("duration", 24));
        zzaLS.put("embedUrl", Field.zzm("embedUrl", 25));
        zzaLS.put("endDate", Field.zzm("endDate", 26));
        zzaLS.put("familyName", Field.zzm("familyName", 27));
        zzaLS.put("gender", Field.zzm("gender", 28));
        zzaLS.put("geo", Field.zza("geo", 29, ItemScopeEntity.class));
        zzaLS.put("givenName", Field.zzm("givenName", 30));
        zzaLS.put("height", Field.zzm("height", 31));
        zzaLS.put("id", Field.zzm("id", 32));
        zzaLS.put(Frg_Qiblat_Map.sARGUMENT_IMAGE_CODE, Field.zzm(Frg_Qiblat_Map.sARGUMENT_IMAGE_CODE, 33));
        zzaLS.put("inAlbum", Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzaLS.put("latitude", Field.zzk("latitude", 36));
        zzaLS.put("location", Field.zza("location", 37, ItemScopeEntity.class));
        zzaLS.put("longitude", Field.zzk("longitude", 38));
        zzaLS.put("name", Field.zzm("name", 39));
        zzaLS.put("partOfTVSeries", Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzaLS.put("performers", Field.zzb("performers", 41, ItemScopeEntity.class));
        zzaLS.put("playerType", Field.zzm("playerType", 42));
        zzaLS.put("postOfficeBoxNumber", Field.zzm("postOfficeBoxNumber", 43));
        zzaLS.put("postalCode", Field.zzm("postalCode", 44));
        zzaLS.put("ratingValue", Field.zzm("ratingValue", 45));
        zzaLS.put("reviewRating", Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzaLS.put("startDate", Field.zzm("startDate", 47));
        zzaLS.put("streetAddress", Field.zzm("streetAddress", 48));
        zzaLS.put("text", Field.zzm("text", 49));
        zzaLS.put("thumbnail", Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzaLS.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, Field.zzm(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzaLS.put("tickerSymbol", Field.zzm("tickerSymbol", 52));
        zzaLS.put("type", Field.zzm("type", 53));
        zzaLS.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        zzaLS.put("width", Field.zzm("width", 55));
        zzaLS.put("worstRating", Field.zzm("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.mVersionCode = 1;
        this.zzaLT = new HashSet();
    }

    ItemScopeEntity(Set<Integer> indicatorSet, int versionCode, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzaLT = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzaLU = about;
        this.zzaLV = additionalName;
        this.zzaLW = address;
        this.zzaLX = addressCountry;
        this.zzaLY = addressLocality;
        this.zzaLZ = addressRegion;
        this.zzaMa = associated_media;
        this.zzaMb = attendeeCount;
        this.zzaMc = attendees;
        this.zzaMd = audio;
        this.zzaMe = author;
        this.zzaMf = bestRating;
        this.zzaMg = birthDate;
        this.zzaMh = byArtist;
        this.zzaMi = caption;
        this.zzaMj = contentSize;
        this.zzsV = contentUrl;
        this.zzaMk = contributor;
        this.zzaMl = dateCreated;
        this.zzaMm = dateModified;
        this.zzaMn = datePublished;
        this.zzaoB = description;
        this.zzaMo = duration;
        this.zzaMp = embedUrl;
        this.zzaMq = endDate;
        this.zzaMr = familyName;
        this.zzaMs = gender;
        this.zzaMt = geo;
        this.zzaMu = givenName;
        this.zzaMv = height;
        this.zzwj = id;
        this.zzaMw = image;
        this.zzaMx = inAlbum;
        this.zzaBD = latitude;
        this.zzaMy = location;
        this.zzaBE = longitude;
        this.mName = name;
        this.zzaMz = partOfTVSeries;
        this.zzaMA = performers;
        this.zzaMB = playerType;
        this.zzaMC = postOfficeBoxNumber;
        this.zzaMD = postalCode;
        this.zzaME = ratingValue;
        this.zzaMF = reviewRating;
        this.zzaMG = startDate;
        this.zzaMH = streetAddress;
        this.zzaMI = text;
        this.zzaMJ = thumbnail;
        this.zzaMK = thumbnailUrl;
        this.zzaML = tickerSymbol;
        this.zzFz = type;
        this.zzF = url;
        this.zzaMM = width;
        this.zzaMN = worstRating;
    }

    public ItemScopeEntity(Set<Integer> indicatorSet, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzaLT = indicatorSet;
        this.mVersionCode = 1;
        this.zzaLU = about;
        this.zzaLV = additionalName;
        this.zzaLW = address;
        this.zzaLX = addressCountry;
        this.zzaLY = addressLocality;
        this.zzaLZ = addressRegion;
        this.zzaMa = associated_media;
        this.zzaMb = attendeeCount;
        this.zzaMc = attendees;
        this.zzaMd = audio;
        this.zzaMe = author;
        this.zzaMf = bestRating;
        this.zzaMg = birthDate;
        this.zzaMh = byArtist;
        this.zzaMi = caption;
        this.zzaMj = contentSize;
        this.zzsV = contentUrl;
        this.zzaMk = contributor;
        this.zzaMl = dateCreated;
        this.zzaMm = dateModified;
        this.zzaMn = datePublished;
        this.zzaoB = description;
        this.zzaMo = duration;
        this.zzaMp = embedUrl;
        this.zzaMq = endDate;
        this.zzaMr = familyName;
        this.zzaMs = gender;
        this.zzaMt = geo;
        this.zzaMu = givenName;
        this.zzaMv = height;
        this.zzwj = id;
        this.zzaMw = image;
        this.zzaMx = inAlbum;
        this.zzaBD = latitude;
        this.zzaMy = location;
        this.zzaBE = longitude;
        this.mName = name;
        this.zzaMz = partOfTVSeries;
        this.zzaMA = performers;
        this.zzaMB = playerType;
        this.zzaMC = postOfficeBoxNumber;
        this.zzaMD = postalCode;
        this.zzaME = ratingValue;
        this.zzaMF = reviewRating;
        this.zzaMG = startDate;
        this.zzaMH = streetAddress;
        this.zzaMI = text;
        this.zzaMJ = thumbnail;
        this.zzaMK = thumbnailUrl;
        this.zzaML = tickerSymbol;
        this.zzFz = type;
        this.zzF = url;
        this.zzaMM = width;
        this.zzaMN = worstRating;
    }

    public int describeContents() {
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (Field field : zzaLS.values()) {
            if (zza(field)) {
                if (!itemScopeEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(itemScopeEntity.zzb(field))) {
                    return false;
                }
            } else if (itemScopeEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzyU();
    }

    public ItemScope getAbout() {
        return this.zzaLU;
    }

    public List<String> getAdditionalName() {
        return this.zzaLV;
    }

    public ItemScope getAddress() {
        return this.zzaLW;
    }

    public String getAddressCountry() {
        return this.zzaLX;
    }

    public String getAddressLocality() {
        return this.zzaLY;
    }

    public String getAddressRegion() {
        return this.zzaLZ;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzaMa;
    }

    public int getAttendeeCount() {
        return this.zzaMb;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzaMc;
    }

    public ItemScope getAudio() {
        return this.zzaMd;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzaMe;
    }

    public String getBestRating() {
        return this.zzaMf;
    }

    public String getBirthDate() {
        return this.zzaMg;
    }

    public ItemScope getByArtist() {
        return this.zzaMh;
    }

    public String getCaption() {
        return this.zzaMi;
    }

    public String getContentSize() {
        return this.zzaMj;
    }

    public String getContentUrl() {
        return this.zzsV;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzaMk;
    }

    public String getDateCreated() {
        return this.zzaMl;
    }

    public String getDateModified() {
        return this.zzaMm;
    }

    public String getDatePublished() {
        return this.zzaMn;
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public String getDuration() {
        return this.zzaMo;
    }

    public String getEmbedUrl() {
        return this.zzaMp;
    }

    public String getEndDate() {
        return this.zzaMq;
    }

    public String getFamilyName() {
        return this.zzaMr;
    }

    public String getGender() {
        return this.zzaMs;
    }

    public ItemScope getGeo() {
        return this.zzaMt;
    }

    public String getGivenName() {
        return this.zzaMu;
    }

    public String getHeight() {
        return this.zzaMv;
    }

    public String getId() {
        return this.zzwj;
    }

    public String getImage() {
        return this.zzaMw;
    }

    public ItemScope getInAlbum() {
        return this.zzaMx;
    }

    public double getLatitude() {
        return this.zzaBD;
    }

    public ItemScope getLocation() {
        return this.zzaMy;
    }

    public double getLongitude() {
        return this.zzaBE;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.zzaMz;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzaMA;
    }

    public String getPlayerType() {
        return this.zzaMB;
    }

    public String getPostOfficeBoxNumber() {
        return this.zzaMC;
    }

    public String getPostalCode() {
        return this.zzaMD;
    }

    public String getRatingValue() {
        return this.zzaME;
    }

    public ItemScope getReviewRating() {
        return this.zzaMF;
    }

    public String getStartDate() {
        return this.zzaMG;
    }

    public String getStreetAddress() {
        return this.zzaMH;
    }

    public String getText() {
        return this.zzaMI;
    }

    public ItemScope getThumbnail() {
        return this.zzaMJ;
    }

    public String getThumbnailUrl() {
        return this.zzaMK;
    }

    public String getTickerSymbol() {
        return this.zzaML;
    }

    public String getType() {
        return this.zzFz;
    }

    public String getUrl() {
        return this.zzF;
    }

    public String getWidth() {
        return this.zzaMM;
    }

    public String getWorstRating() {
        return this.zzaMN;
    }

    public boolean hasAbout() {
        return this.zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.zzaLT.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.zzaLT.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.zzaLT.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.zzaLT.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.zzaLT.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.zzaLT.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.zzaLT.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.zzaLT.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.zzaLT.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.zzaLT.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.zzaLT.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.zzaLT.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.zzaLT.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.zzaLT.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.zzaLT.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.zzaLT.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.zzaLT.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.zzaLT.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.zzaLT.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.zzaLT.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.zzaLT.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.zzaLT.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.zzaLT.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.zzaLT.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.zzaLT.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.zzaLT.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.zzaLT.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.zzaLT.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.zzaLT.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.zzaLT.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.zzaLT.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.zzaLT.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.zzaLT.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.zzaLT.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.zzaLT.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.zzaLT.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.zzaLT.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.zzaLT.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.zzaLT.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.zzaLT.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.zzaLT.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.zzaLT.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.zzaLT.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.zzaLT.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.zzaLT.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.zzaLT.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.zzaLT.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.zzaLT.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.zzaLT.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.zzaLT.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.zzaLT.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        for (Field field : zzaLS.values()) {
            int hashCode;
            if (zza(field)) {
                hashCode = zzb(field).hashCode() + (i + field.zzpi());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    protected boolean zza(Field field) {
        return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
    }

    protected Object zzb(Field field) {
        switch (field.zzpi()) {
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return this.zzaLU;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return this.zzaLV;
            case Barcode.PHONE /*4*/:
                return this.zzaLW;
            case Barcode.PRODUCT /*5*/:
                return this.zzaLX;
            case Barcode.SMS /*6*/:
                return this.zzaLY;
            case Barcode.TEXT /*7*/:
                return this.zzaLZ;
            case Barcode.URL /*8*/:
                return this.zzaMa;
            case Barcode.WIFI /*9*/:
                return Integer.valueOf(this.zzaMb);
            case Barcode.GEO /*10*/:
                return this.zzaMc;
            case Barcode.CALENDAR_EVENT /*11*/:
                return this.zzaMd;
            case Barcode.DRIVER_LICENSE /*12*/:
                return this.zzaMe;
            case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                return this.zzaMf;
            case Place.TYPE_BUS_STATION /*14*/:
                return this.zzaMg;
            case Place.TYPE_CAFE /*15*/:
                return this.zzaMh;
            case Barcode.DATA_MATRIX /*16*/:
                return this.zzaMi;
            case Place.TYPE_CAR_DEALER /*17*/:
                return this.zzaMj;
            case Place.TYPE_CAR_RENTAL /*18*/:
                return this.zzsV;
            case Place.TYPE_CAR_REPAIR /*19*/:
                return this.zzaMk;
            case Place.TYPE_CAR_WASH /*20*/:
                return this.zzaMl;
            case Place.TYPE_CASINO /*21*/:
                return this.zzaMm;
            case Place.TYPE_CEMETERY /*22*/:
                return this.zzaMn;
            case Place.TYPE_CHURCH /*23*/:
                return this.zzaoB;
            case Place.TYPE_CITY_HALL /*24*/:
                return this.zzaMo;
            case Place.TYPE_CLOTHING_STORE /*25*/:
                return this.zzaMp;
            case Place.TYPE_CONVENIENCE_STORE /*26*/:
                return this.zzaMq;
            case Place.TYPE_COURTHOUSE /*27*/:
                return this.zzaMr;
            case Place.TYPE_DENTIST /*28*/:
                return this.zzaMs;
            case Place.TYPE_DEPARTMENT_STORE /*29*/:
                return this.zzaMt;
            case Place.TYPE_DOCTOR /*30*/:
                return this.zzaMu;
            case Place.TYPE_ELECTRICIAN /*31*/:
                return this.zzaMv;
            case Barcode.EAN_13 /*32*/:
                return this.zzwj;
            case Place.TYPE_EMBASSY /*33*/:
                return this.zzaMw;
            case Place.TYPE_ESTABLISHMENT /*34*/:
                return this.zzaMx;
            case Place.TYPE_FIRE_STATION /*36*/:
                return Double.valueOf(this.zzaBD);
            case Place.TYPE_FLORIST /*37*/:
                return this.zzaMy;
            case Place.TYPE_FOOD /*38*/:
                return Double.valueOf(this.zzaBE);
            case Place.TYPE_FUNERAL_HOME /*39*/:
                return this.mName;
            case Place.TYPE_FURNITURE_STORE /*40*/:
                return this.zzaMz;
            case Place.TYPE_GAS_STATION /*41*/:
                return this.zzaMA;
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return this.zzaMB;
            case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                return this.zzaMC;
            case Place.TYPE_GYM /*44*/:
                return this.zzaMD;
            case Place.TYPE_HAIR_CARE /*45*/:
                return this.zzaME;
            case Place.TYPE_HARDWARE_STORE /*46*/:
                return this.zzaMF;
            case Place.TYPE_HEALTH /*47*/:
                return this.zzaMG;
            case Place.TYPE_HINDU_TEMPLE /*48*/:
                return this.zzaMH;
            case Place.TYPE_HOME_GOODS_STORE /*49*/:
                return this.zzaMI;
            case Place.TYPE_HOSPITAL /*50*/:
                return this.zzaMJ;
            case Place.TYPE_INSURANCE_AGENCY /*51*/:
                return this.zzaMK;
            case Place.TYPE_JEWELRY_STORE /*52*/:
                return this.zzaML;
            case Place.TYPE_LAUNDRY /*53*/:
                return this.zzFz;
            case Place.TYPE_LAWYER /*54*/:
                return this.zzF;
            case Place.TYPE_LIBRARY /*55*/:
                return this.zzaMM;
            case Place.TYPE_LIQUOR_STORE /*56*/:
                return this.zzaMN;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
        }
    }

    public /* synthetic */ Map zzpb() {
        return zzyT();
    }

    public HashMap<String, Field<?, ?>> zzyT() {
        return zzaLS;
    }

    public ItemScopeEntity zzyU() {
        return this;
    }
}
