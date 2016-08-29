package org.bpmikc.akm.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.LinkedList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final String[] COLUMNS;
    private static final String DATABASE_NAME = "BookDB";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ALAMAT_MASJID = "alamat_masjid";
    private static final String KEY_ID = "id";
    private static final String KEY_ID_REC = "id_rec";
    private static final String KEY_JENIS_MASJID = "jenis_masjid";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_NAMA_KOTA = "nama_kota";
    private static final String KEY_NAMA_MASJID = "nama_masjid";
    private static final String KEY_STATUS = "status";
    private static final String TABLE_BOOKS = "books";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        COLUMNS = new String[]{KEY_ID, KEY_ID_REC, KEY_NAMA_MASJID, KEY_ALAMAT_MASJID, KEY_NAMA_KOTA, KEY_JENIS_MASJID, KEY_LATITUDE, KEY_LONGITUDE, KEY_STATUS};
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE books ( id INTEGER PRIMARY KEY AUTOINCREMENT, id_rec TEXT, nama_masjid TEXT, alamat_masjid TEXT, nama_kota TEXT, jenis_masjid TEXT, latitude TEXT, longitude TEXT, status TEXT )");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        onCreate(db);
    }

    public void addBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_REC, book.get_id_rec());
        values.put(KEY_NAMA_MASJID, book.get_nama_masjid());
        values.put(KEY_ALAMAT_MASJID, book.get_alamat_masjid());
        values.put(KEY_NAMA_KOTA, book.get_nama_kota());
        values.put(KEY_JENIS_MASJID, book.get_jenis_masjid());
        values.put(KEY_LATITUDE, book.get_latitude());
        values.put(KEY_LONGITUDE, book.get_longitude());
        values.put(KEY_STATUS, book.get_status());
        db.insert(TABLE_BOOKS, null, values);
        db.close();
    }

    public Book getBook(int id) {
        String[] strArr = new String[DATABASE_VERSION];
        strArr[0] = String.valueOf(id);
        Cursor cursor = getReadableDatabase().query(TABLE_BOOKS, COLUMNS, " id = ?", strArr, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Book book = new Book();
        book.setId(Integer.valueOf(Integer.parseInt(cursor.getString(0))));
        book.set_id_rec(cursor.getString(DATABASE_VERSION));
        book.set_nama_masjid(cursor.getString(2));
        book.set_alamat_masjid(cursor.getString(3));
        book.set_nama_kota(cursor.getString(4));
        book.set_jenis_masjid(cursor.getString(5));
        book.set_latitude(cursor.getString(6));
        book.set_longitude(cursor.getString(7));
        book.set_status(cursor.getString(8));
        return book;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new LinkedList();
        Cursor cursor = getWritableDatabase().rawQuery("SELECT  * FROM books", null);
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setId(Integer.valueOf(Integer.parseInt(cursor.getString(0))));
                book.set_id_rec(cursor.getString(DATABASE_VERSION));
                book.set_nama_masjid(cursor.getString(2));
                book.set_alamat_masjid(cursor.getString(3));
                book.set_nama_kota(cursor.getString(4));
                book.set_jenis_masjid(cursor.getString(5));
                book.set_latitude(cursor.getString(6));
                book.set_longitude(cursor.getString(7));
                book.set_status(cursor.getString(8));
                books.add(book);
            } while (cursor.moveToNext());
        }
        return books;
    }

    public int updateBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_REC, book.get_id_rec());
        values.put(KEY_NAMA_MASJID, book.get_nama_masjid());
        values.put(KEY_ALAMAT_MASJID, book.get_alamat_masjid());
        values.put(KEY_NAMA_KOTA, book.get_nama_kota());
        values.put(KEY_JENIS_MASJID, book.get_jenis_masjid());
        values.put(KEY_LATITUDE, book.get_latitude());
        values.put(KEY_LONGITUDE, book.get_longitude());
        values.put(KEY_STATUS, book.get_status());
        String[] strArr = new String[DATABASE_VERSION];
        strArr[0] = String.valueOf(book.getId());
        int i = db.update(TABLE_BOOKS, values, "id = ?", strArr);
        db.close();
        return i;
    }

    public void deleteBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        String[] strArr = new String[DATABASE_VERSION];
        strArr[0] = String.valueOf(book.get_id_rec());
        db.delete(TABLE_BOOKS, "id_rec = ?", strArr);
        db.close();
    }
}
