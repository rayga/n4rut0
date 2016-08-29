package org.bpmikc.akm.Database;

public class Book {
    private String alamat_masjid;
    private int id;
    private String id_rec;
    private String jenis_masjid;
    private String latitude;
    private String longitude;
    private String nama_kota;
    private String nama_masjid;
    private String status;

    public Book(String id_rec, String nama_masjid, String alamat_masjid, String nama_kota, String jenis_masjid, String latitude, String longitude, String status) {
        this.id_rec = id_rec;
        this.nama_masjid = nama_masjid;
        this.alamat_masjid = alamat_masjid;
        this.nama_kota = nama_kota;
        this.jenis_masjid = jenis_masjid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }

    public String toString() {
        return "Book [id_rec=" + this.id_rec + ", " + "nama_masjid=" + this.nama_masjid + ", " + "alamat_masjid=" + this.alamat_masjid + ", " + "nama_kota=" + this.nama_kota + ", " + "jenis_masjid=" + this.jenis_masjid + ", " + "latitude=" + this.latitude + ", " + "longitude=" + this.longitude + ", " + "status=" + this.status + "]";
    }

    public void setId(Integer id) {
        this.id = id.intValue();
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }

    public void set_id_rec(String id_rec) {
        this.id_rec = id_rec;
    }

    public String get_id_rec() {
        return this.id_rec;
    }

    public void set_nama_masjid(String nama_masjid) {
        this.nama_masjid = nama_masjid;
    }

    public String get_nama_masjid() {
        return this.nama_masjid;
    }

    public void set_alamat_masjid(String alamat_masjid) {
        this.alamat_masjid = alamat_masjid;
    }

    public String get_alamat_masjid() {
        return this.alamat_masjid;
    }

    public void set_nama_kota(String nama_kota) {
        this.nama_kota = nama_kota;
    }

    public String get_nama_kota() {
        return this.nama_kota;
    }

    public void set_latitude(String latitude) {
        this.latitude = latitude;
    }

    public String get_latitude() {
        return this.latitude;
    }

    public void set_longitude(String longitude) {
        this.longitude = longitude;
    }

    public String get_longitude() {
        return this.longitude;
    }

    public void set_status(String status) {
        this.status = status;
    }

    public String get_status() {
        return this.status;
    }

    public void set_jenis_masjid(String jenis_masjid) {
        this.jenis_masjid = jenis_masjid;
    }

    public String get_jenis_masjid() {
        return this.jenis_masjid;
    }
}
