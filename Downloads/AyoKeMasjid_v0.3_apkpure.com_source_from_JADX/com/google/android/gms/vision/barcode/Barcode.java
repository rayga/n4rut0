package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;

public class Barcode implements SafeParcelable {
    public static final int CALENDAR_EVENT = 11;
    public static final int CODABAR = 8;
    public static final int CODE_128 = 1;
    public static final int CODE_39 = 2;
    public static final int CODE_93 = 4;
    public static final int CONTACT_INFO = 1;
    public static final zzb CREATOR;
    public static final int DATA_MATRIX = 16;
    public static final int DRIVER_LICENSE = 12;
    public static final int EAN_13 = 32;
    public static final int EAN_8 = 64;
    public static final int EMAIL = 2;
    public static final int GEO = 10;
    public static final int ISBN = 3;
    public static final int ITF = 128;
    public static final int PDF417 = 2048;
    public static final int PHONE = 4;
    public static final int PRODUCT = 5;
    public static final int QR_CODE = 256;
    public static final int SMS = 6;
    public static final int TEXT = 7;
    public static final int UPC_A = 512;
    public static final int UPC_E = 1024;
    public static final int URL = 8;
    public static final int WIFI = 9;
    public CalendarEvent calendarEvent;
    public ContactInfo contactInfo;
    public Point[] cornerPoints;
    public String displayValue;
    public DriverLicense driverLicense;
    public Email email;
    public int format;
    public GeoPoint geoPoint;
    public Phone phone;
    public String rawValue;
    public Sms sms;
    public UrlBookmark url;
    public int valueFormat;
    final int versionCode;
    public WiFi wifi;

    public static class Address implements SafeParcelable {
        public static final zza CREATOR;
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String[] addressLines;
        public int type;
        final int versionCode;

        static {
            CREATOR = new zza();
        }

        public Address() {
            this.versionCode = WORK;
        }

        public Address(int versionCode, int type, String[] addressLines) {
            this.versionCode = versionCode;
            this.type = type;
            this.addressLines = addressLines;
        }

        public int describeContents() {
            zza com_google_android_gms_vision_barcode_zza = CREATOR;
            return UNKNOWN;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zza com_google_android_gms_vision_barcode_zza = CREATOR;
            zza.zza(this, parcel, flags);
        }
    }

    public static class CalendarDateTime implements SafeParcelable {
        public static final zzc CREATOR;
        public int day;
        public int hours;
        public boolean isUtc;
        public int minutes;
        public int month;
        public String rawValue;
        public int seconds;
        final int versionCode;
        public int year;

        static {
            CREATOR = new zzc();
        }

        public CalendarDateTime() {
            this.versionCode = Barcode.CONTACT_INFO;
        }

        public CalendarDateTime(int versionCode, int year, int month, int day, int hours, int minutes, int seconds, boolean isUtc, String rawValue) {
            this.versionCode = versionCode;
            this.year = year;
            this.month = month;
            this.day = day;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.isUtc = isUtc;
            this.rawValue = rawValue;
        }

        public int describeContents() {
            zzc com_google_android_gms_vision_barcode_zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzc com_google_android_gms_vision_barcode_zzc = CREATOR;
            zzc.zza(this, parcel, flags);
        }
    }

    public static class CalendarEvent implements SafeParcelable {
        public static final zzd CREATOR;
        public String description;
        public CalendarDateTime end;
        public String location;
        public String organizer;
        public CalendarDateTime start;
        public String status;
        public String summary;
        final int versionCode;

        static {
            CREATOR = new zzd();
        }

        public CalendarEvent() {
            this.versionCode = Barcode.CONTACT_INFO;
        }

        public CalendarEvent(int versionCode, String summary, String description, String location, String organizer, String status, CalendarDateTime start, CalendarDateTime end) {
            this.versionCode = versionCode;
            this.summary = summary;
            this.description = description;
            this.location = location;
            this.organizer = organizer;
            this.status = status;
            this.start = start;
            this.end = end;
        }

        public int describeContents() {
            zzd com_google_android_gms_vision_barcode_zzd = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzd com_google_android_gms_vision_barcode_zzd = CREATOR;
            zzd.zza(this, parcel, flags);
        }
    }

    public static class ContactInfo implements SafeParcelable {
        public static final zze CREATOR;
        public Address[] addresses;
        public Email[] emails;
        public PersonName name;
        public String organization;
        public Phone[] phones;
        public String title;
        public String[] urls;
        final int versionCode;

        static {
            CREATOR = new zze();
        }

        public ContactInfo() {
            this.versionCode = Barcode.CONTACT_INFO;
        }

        public ContactInfo(int versionCode, PersonName name, String organization, String title, Phone[] phones, Email[] emails, String[] urls, Address[] addresses) {
            this.versionCode = versionCode;
            this.name = name;
            this.organization = organization;
            this.title = title;
            this.phones = phones;
            this.emails = emails;
            this.urls = urls;
            this.addresses = addresses;
        }

        public int describeContents() {
            zze com_google_android_gms_vision_barcode_zze = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zze com_google_android_gms_vision_barcode_zze = CREATOR;
            zze.zza(this, parcel, flags);
        }
    }

    public static class DriverLicense implements SafeParcelable {
        public static final zzf CREATOR;
        public String addressCity;
        public String addressState;
        public String addressStreet;
        public String addressZip;
        public String birthDate;
        public String documentType;
        public String expiryDate;
        public String firstName;
        public String gender;
        public String issueDate;
        public String issuingCountry;
        public String lastName;
        public String licenseNumber;
        public String middleName;
        final int versionCode;

        static {
            CREATOR = new zzf();
        }

        public DriverLicense() {
            this.versionCode = Barcode.CONTACT_INFO;
        }

        public DriverLicense(int versionCode, String documentType, String firstName, String middleName, String lastName, String gender, String addressStreet, String addressCity, String addressState, String addressZip, String licenseNumber, String issueDate, String expiryDate, String birthDate, String issuingCountry) {
            this.versionCode = versionCode;
            this.documentType = documentType;
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.gender = gender;
            this.addressStreet = addressStreet;
            this.addressCity = addressCity;
            this.addressState = addressState;
            this.addressZip = addressZip;
            this.licenseNumber = licenseNumber;
            this.issueDate = issueDate;
            this.expiryDate = expiryDate;
            this.birthDate = birthDate;
            this.issuingCountry = issuingCountry;
        }

        public int describeContents() {
            zzf com_google_android_gms_vision_barcode_zzf = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzf com_google_android_gms_vision_barcode_zzf = CREATOR;
            zzf.zza(this, parcel, flags);
        }
    }

    public static class Email implements SafeParcelable {
        public static final zzg CREATOR;
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String address;
        public String body;
        public String subject;
        public int type;
        final int versionCode;

        static {
            CREATOR = new zzg();
        }

        public Email() {
            this.versionCode = WORK;
        }

        public Email(int versionCode, int type, String address, String subject, String body) {
            this.versionCode = versionCode;
            this.type = type;
            this.address = address;
            this.subject = subject;
            this.body = body;
        }

        public int describeContents() {
            zzg com_google_android_gms_vision_barcode_zzg = CREATOR;
            return UNKNOWN;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzg com_google_android_gms_vision_barcode_zzg = CREATOR;
            zzg.zza(this, parcel, flags);
        }
    }

    public static class GeoPoint implements SafeParcelable {
        public static final zzh CREATOR;
        public double lat;
        public double lng;
        final int versionCode;

        static {
            CREATOR = new zzh();
        }

        public GeoPoint() {
            this.versionCode = Barcode.CONTACT_INFO;
        }

        public GeoPoint(int versionCode, double lat, double lng) {
            this.versionCode = versionCode;
            this.lat = lat;
            this.lng = lng;
        }

        public int describeContents() {
            zzh com_google_android_gms_vision_barcode_zzh = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzh com_google_android_gms_vision_barcode_zzh = CREATOR;
            zzh.zza(this, parcel, flags);
        }
    }

    public static class PersonName implements SafeParcelable {
        public static final zzi CREATOR;
        public String first;
        public String formattedName;
        public String last;
        public String middle;
        public String prefix;
        public String pronunciation;
        public String suffix;
        final int versionCode;

        static {
            CREATOR = new zzi();
        }

        public PersonName() {
            this.versionCode = Barcode.CONTACT_INFO;
        }

        public PersonName(int versionCode, String formattedName, String pronunciation, String prefix, String first, String middle, String last, String suffix) {
            this.versionCode = versionCode;
            this.formattedName = formattedName;
            this.pronunciation = pronunciation;
            this.prefix = prefix;
            this.first = first;
            this.middle = middle;
            this.last = last;
            this.suffix = suffix;
        }

        public int describeContents() {
            zzi com_google_android_gms_vision_barcode_zzi = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzi com_google_android_gms_vision_barcode_zzi = CREATOR;
            zzi.zza(this, parcel, flags);
        }
    }

    public static class Phone implements SafeParcelable {
        public static final zzj CREATOR;
        public static final int FAX = 3;
        public static final int HOME = 2;
        public static final int MOBILE = 4;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String number;
        public int type;
        final int versionCode;

        static {
            CREATOR = new zzj();
        }

        public Phone() {
            this.versionCode = WORK;
        }

        public Phone(int versionCode, int type, String number) {
            this.versionCode = versionCode;
            this.type = type;
            this.number = number;
        }

        public int describeContents() {
            zzj com_google_android_gms_vision_barcode_zzj = CREATOR;
            return UNKNOWN;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzj com_google_android_gms_vision_barcode_zzj = CREATOR;
            zzj.zza(this, parcel, flags);
        }
    }

    public static class Sms implements SafeParcelable {
        public static final zzk CREATOR;
        public String message;
        public String phoneNumber;
        final int versionCode;

        static {
            CREATOR = new zzk();
        }

        public Sms() {
            this.versionCode = Barcode.CONTACT_INFO;
        }

        public Sms(int versionCode, String message, String phoneNumber) {
            this.versionCode = versionCode;
            this.message = message;
            this.phoneNumber = phoneNumber;
        }

        public int describeContents() {
            zzk com_google_android_gms_vision_barcode_zzk = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzk com_google_android_gms_vision_barcode_zzk = CREATOR;
            zzk.zza(this, parcel, flags);
        }
    }

    public static class UrlBookmark implements SafeParcelable {
        public static final zzl CREATOR;
        public String title;
        public String url;
        final int versionCode;

        static {
            CREATOR = new zzl();
        }

        public UrlBookmark() {
            this.versionCode = Barcode.CONTACT_INFO;
        }

        public UrlBookmark(int versionCode, String title, String url) {
            this.versionCode = versionCode;
            this.title = title;
            this.url = url;
        }

        public int describeContents() {
            zzl com_google_android_gms_vision_barcode_zzl = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzl com_google_android_gms_vision_barcode_zzl = CREATOR;
            zzl.zza(this, parcel, flags);
        }
    }

    public static class WiFi implements SafeParcelable {
        public static final zzm CREATOR;
        public static final int OPEN = 1;
        public static final int WEP = 3;
        public static final int WPA = 2;
        public int encryptionType;
        public String password;
        public String ssid;
        final int versionCode;

        static {
            CREATOR = new zzm();
        }

        public WiFi() {
            this.versionCode = OPEN;
        }

        public WiFi(int versionCode, String ssid, String password, int encryptionType) {
            this.versionCode = versionCode;
            this.ssid = ssid;
            this.password = password;
            this.encryptionType = encryptionType;
        }

        public int describeContents() {
            zzm com_google_android_gms_vision_barcode_zzm = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzm com_google_android_gms_vision_barcode_zzm = CREATOR;
            zzm.zza(this, parcel, flags);
        }
    }

    static {
        CREATOR = new zzb();
    }

    public Barcode() {
        this.versionCode = CONTACT_INFO;
    }

    public Barcode(int versionCode, int format, String rawValue, String displayValue, int valueFormat, Point[] cornerPoints, Email email, Phone phone, Sms sms, WiFi wifi, UrlBookmark url, GeoPoint geoPoint, CalendarEvent calendarEvent, ContactInfo contactInfo, DriverLicense driverLicense) {
        this.versionCode = versionCode;
        this.format = format;
        this.rawValue = rawValue;
        this.displayValue = displayValue;
        this.valueFormat = valueFormat;
        this.cornerPoints = cornerPoints;
        this.email = email;
        this.phone = phone;
        this.sms = sms;
        this.wifi = wifi;
        this.url = url;
        this.geoPoint = geoPoint;
        this.calendarEvent = calendarEvent;
        this.contactInfo = contactInfo;
        this.driverLicense = driverLicense;
    }

    public int describeContents() {
        zzb com_google_android_gms_vision_barcode_zzb = CREATOR;
        return 0;
    }

    public Rect getBoundingBox() {
        int i = Strategy.TTL_SECONDS_INFINITE;
        int i2 = Target.SIZE_ORIGINAL;
        int i3 = Target.SIZE_ORIGINAL;
        int i4 = Strategy.TTL_SECONDS_INFINITE;
        for (int i5 = 0; i5 < this.cornerPoints.length; i5 += CONTACT_INFO) {
            Point point = this.cornerPoints[i5];
            i4 = Math.min(i4, point.x);
            i3 = Math.max(i3, point.x);
            i = Math.min(i, point.y);
            i2 = Math.max(i2, point.y);
        }
        return new Rect(i4, i, i3, i2);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb com_google_android_gms_vision_barcode_zzb = CREATOR;
        zzb.zza(this, parcel, flags);
    }
}
