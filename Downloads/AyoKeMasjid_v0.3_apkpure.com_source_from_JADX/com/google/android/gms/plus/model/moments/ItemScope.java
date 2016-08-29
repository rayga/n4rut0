package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {
        private String mName;
        private String zzF;
        private String zzFz;
        private double zzaBD;
        private double zzaBE;
        private final Set<Integer> zzaLT;
        private ItemScopeEntity zzaLU;
        private List<String> zzaLV;
        private ItemScopeEntity zzaLW;
        private String zzaLX;
        private String zzaLY;
        private String zzaLZ;
        private List<ItemScopeEntity> zzaMA;
        private String zzaMB;
        private String zzaMC;
        private String zzaMD;
        private String zzaME;
        private ItemScopeEntity zzaMF;
        private String zzaMG;
        private String zzaMH;
        private String zzaMI;
        private ItemScopeEntity zzaMJ;
        private String zzaMK;
        private String zzaML;
        private String zzaMM;
        private String zzaMN;
        private List<ItemScopeEntity> zzaMa;
        private int zzaMb;
        private List<ItemScopeEntity> zzaMc;
        private ItemScopeEntity zzaMd;
        private List<ItemScopeEntity> zzaMe;
        private String zzaMf;
        private String zzaMg;
        private ItemScopeEntity zzaMh;
        private String zzaMi;
        private String zzaMj;
        private List<ItemScopeEntity> zzaMk;
        private String zzaMl;
        private String zzaMm;
        private String zzaMn;
        private String zzaMo;
        private String zzaMp;
        private String zzaMq;
        private String zzaMr;
        private String zzaMs;
        private ItemScopeEntity zzaMt;
        private String zzaMu;
        private String zzaMv;
        private String zzaMw;
        private ItemScopeEntity zzaMx;
        private ItemScopeEntity zzaMy;
        private ItemScopeEntity zzaMz;
        private String zzaoB;
        private String zzsV;
        private String zzwj;

        public Builder() {
            this.zzaLT = new HashSet();
        }

        public ItemScope build() {
            return new ItemScopeEntity(this.zzaLT, this.zzaLU, this.zzaLV, this.zzaLW, this.zzaLX, this.zzaLY, this.zzaLZ, this.zzaMa, this.zzaMb, this.zzaMc, this.zzaMd, this.zzaMe, this.zzaMf, this.zzaMg, this.zzaMh, this.zzaMi, this.zzaMj, this.zzsV, this.zzaMk, this.zzaMl, this.zzaMm, this.zzaMn, this.zzaoB, this.zzaMo, this.zzaMp, this.zzaMq, this.zzaMr, this.zzaMs, this.zzaMt, this.zzaMu, this.zzaMv, this.zzwj, this.zzaMw, this.zzaMx, this.zzaBD, this.zzaMy, this.zzaBE, this.mName, this.zzaMz, this.zzaMA, this.zzaMB, this.zzaMC, this.zzaMD, this.zzaME, this.zzaMF, this.zzaMG, this.zzaMH, this.zzaMI, this.zzaMJ, this.zzaMK, this.zzaML, this.zzFz, this.zzF, this.zzaMM, this.zzaMN);
        }

        public Builder setAbout(ItemScope about) {
            this.zzaLU = (ItemScopeEntity) about;
            this.zzaLT.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List<String> additionalName) {
            this.zzaLV = additionalName;
            this.zzaLT.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope address) {
            this.zzaLW = (ItemScopeEntity) address;
            this.zzaLT.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String addressCountry) {
            this.zzaLX = addressCountry;
            this.zzaLT.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String addressLocality) {
            this.zzaLY = addressLocality;
            this.zzaLT.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String addressRegion) {
            this.zzaLZ = addressRegion;
            this.zzaLT.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> associated_media) {
            this.zzaMa = associated_media;
            this.zzaLT.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int attendeeCount) {
            this.zzaMb = attendeeCount;
            this.zzaLT.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List<ItemScope> attendees) {
            this.zzaMc = attendees;
            this.zzaLT.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope audio) {
            this.zzaMd = (ItemScopeEntity) audio;
            this.zzaLT.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List<ItemScope> author) {
            this.zzaMe = author;
            this.zzaLT.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String bestRating) {
            this.zzaMf = bestRating;
            this.zzaLT.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.zzaMg = birthDate;
            this.zzaLT.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope byArtist) {
            this.zzaMh = (ItemScopeEntity) byArtist;
            this.zzaLT.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String caption) {
            this.zzaMi = caption;
            this.zzaLT.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String contentSize) {
            this.zzaMj = contentSize;
            this.zzaLT.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.zzsV = contentUrl;
            this.zzaLT.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List<ItemScope> contributor) {
            this.zzaMk = contributor;
            this.zzaLT.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String dateCreated) {
            this.zzaMl = dateCreated;
            this.zzaLT.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String dateModified) {
            this.zzaMm = dateModified;
            this.zzaLT.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String datePublished) {
            this.zzaMn = datePublished;
            this.zzaLT.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String description) {
            this.zzaoB = description;
            this.zzaLT.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String duration) {
            this.zzaMo = duration;
            this.zzaLT.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String embedUrl) {
            this.zzaMp = embedUrl;
            this.zzaLT.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.zzaMq = endDate;
            this.zzaLT.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String familyName) {
            this.zzaMr = familyName;
            this.zzaLT.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String gender) {
            this.zzaMs = gender;
            this.zzaLT.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope geo) {
            this.zzaMt = (ItemScopeEntity) geo;
            this.zzaLT.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.zzaMu = givenName;
            this.zzaLT.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String height) {
            this.zzaMv = height;
            this.zzaLT.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String id) {
            this.zzwj = id;
            this.zzaLT.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String image) {
            this.zzaMw = image;
            this.zzaLT.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope inAlbum) {
            this.zzaMx = (ItemScopeEntity) inAlbum;
            this.zzaLT.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.zzaBD = latitude;
            this.zzaLT.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope location) {
            this.zzaMy = (ItemScopeEntity) location;
            this.zzaLT.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.zzaBE = longitude;
            this.zzaLT.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            this.zzaLT.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope partOfTVSeries) {
            this.zzaMz = (ItemScopeEntity) partOfTVSeries;
            this.zzaLT.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List<ItemScope> performers) {
            this.zzaMA = performers;
            this.zzaLT.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String playerType) {
            this.zzaMB = playerType;
            this.zzaLT.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String postOfficeBoxNumber) {
            this.zzaMC = postOfficeBoxNumber;
            this.zzaLT.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.zzaMD = postalCode;
            this.zzaLT.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String ratingValue) {
            this.zzaME = ratingValue;
            this.zzaLT.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope reviewRating) {
            this.zzaMF = (ItemScopeEntity) reviewRating;
            this.zzaLT.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.zzaMG = startDate;
            this.zzaLT.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.zzaMH = streetAddress;
            this.zzaLT.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String text) {
            this.zzaMI = text;
            this.zzaLT.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope thumbnail) {
            this.zzaMJ = (ItemScopeEntity) thumbnail;
            this.zzaLT.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.zzaMK = thumbnailUrl;
            this.zzaLT.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String tickerSymbol) {
            this.zzaML = tickerSymbol;
            this.zzaLT.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String type) {
            this.zzFz = type;
            this.zzaLT.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String url) {
            this.zzF = url;
            this.zzaLT.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String width) {
            this.zzaMM = width;
            this.zzaLT.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String worstRating) {
            this.zzaMN = worstRating;
            this.zzaLT.add(Integer.valueOf(56));
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
