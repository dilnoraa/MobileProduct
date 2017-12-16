package com.example.pc.sadear_ge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="VERILER";

    private static final String TABLE_MAKINE_KODU_MULTI="KODLAR_MULTI";
    private static final String COLUMN_MULTI_ID="KOD_ID_MULTI";
    private static final String COLUMN_KOD_AD="KOD_MULTI_ADI";

    private static final String TABLE_DOLDURMA="DOLDURMA";
    private static final String COLUMN_DOLDURMAID="DOLDURMA_ID";
    private static final String COLUMN_DOLDURMA_TIPI="DOLDURMA_TIPI_ADI";

    private static final String TABLE_RUTLAR="RUTLAR";
    private static final String SUTUN_ID="SUTUN_RUTID";
    private static final String COLUMN_RUT_ADI="RUT_ADI";

    private static final String TABLE_YUKLEME="YUKLEME";
    private static final String COLUMN_YUKLEMEID="ID_YUKLEME";
    private static final String COLUMN_YUKLEMEADI="YUKLEME_ADI";

    private static final String TABLE_NAME="KONUMLAR";
    private static final String COL1 ="ID";
    private static final String COL2="MAKINE_KONUMU";

    private static final String TABLE_NAME2="TIPLER";
    private static final String COLUMN1 ="ID2";
    private static final String COLUMN2="MAKINE_KODU";
    private static final String COLUMN3="MAKINE_KONUM_ID";
    private static final String COLUMN4="MAKINETIPI";
    private static final String COLUMN5="SONYUKLEME";
    private static final String COLUMN6="KANAL_SAYISI";


    private static final String TABLE_NAME_ICECEK="ICECEKLER";
    private static final String COLUMN_ID_ICECEK="ID_ICECEK";
    private static final String COLUMN_ICECEK="ICECEK_ADI";

    private static final String TABLE_NAME_KULLANICIGIRISI="ADI_PAROLA";
    private static final String COLUMN_ADI="ADI";
    private static final String COLUMN_PAROLA="PAROLA";

    private static final String TABLE_NAME_YUKLEME_LISTESI="YUKLEME_LISTESI";
    private static final String COLUMN_ID="ID3";
    private static final String COLUMN_GELEN_MAKID="GELEN_MAKINEID";
    private static final String COLUMN_KANAL="KANAL";
    private static final String COLUMN_URUN="URUN";
    private static final String COLUMN_ADET="ADET";






    public DatabaseHelper(Context context ) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("veritabani", " yaratildi");


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table KODLAR_MULTI (KOD_ID_MULTI INTEGER PRIMARY KEY autoincrement,KOD_MULTI_ADI TEXT);");
        db.execSQL("create table DOLDURMA (DOLDURMA_ID INTEGER PRIMARY KEY autoincrement,DOLDURMA_TIPI_ADI TEXT);");
        db.execSQL("create table RUTLAR (SUTUN_RUTID INTEGER PRIMARY KEY autoincrement,RUT_ADI TEXT);");
        db.execSQL("create table YUKLEME (ID_YUKLEME INTEGER PRIMARY KEY autoincrement,YUKLEME_ADI TEXT);");
        db.execSQL("create table KONUMLAR (ID INTEGER PRIMARY KEY autoincrement,MAKINE_KONUMU TEXT);");
        db.execSQL("create table TIPLER (ID2 INTEGER PRIMARY KEY autoincrement,MAKINE_KODU TEXT,MAKINE_KONUM_ID INTEGER,MAKINETIPI TEXT,SONYUKLEME INTEGER,KANAL_SAYISI INTEGER);");
        db.execSQL("create table ICECEKLER (ID_ICECEK INTEGER PRIMARY KEY autoincrement,ICECEK_ADI TEXT);");
        db.execSQL("create table ADI_PAROLA (ADI TEXT,PAROLA TEXT);");
        db.execSQL("create table YUKLEME_LISTESI (ID3 INTEGER PRIMARY KEY autoincrement,GELEN_MAKINEID INTEGER,KANAL INTEGER,URUN INTEGER,ADET INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAKINE_KODU_MULTI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOLDURMA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RUTLAR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_YUKLEME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ICECEK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_KULLANICIGIRISI);


        onCreate(db);

    }



//// MULTISPINNER'DEKI VERILER ICIN BU METODLAR ÇAĞRILIR (MAKINE KODLAR)

    public void informationKodMulti (DatabaseHelper database, String gelen_kod) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_KOD_AD, gelen_kod);

        long k = db.insert(TABLE_MAKINE_KODU_MULTI, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();

    }





    public Cursor getMakineKodMulti(DatabaseHelper db) {

        SQLiteDatabase database=db.getReadableDatabase();
        String columns[]={COLUMN_KOD_AD};
        Cursor cr=database.query(TABLE_MAKINE_KODU_MULTI,columns,null,null,null,null,null);

        return cr;

    }

    ////////////////////////////////////////////////////////////

//DOLDURMA TIPI ADLI SPINNER ICIN

    public void informationPutDoldurmaTipi (DatabaseHelper database, String gelen_doldurma) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DOLDURMA_TIPI, gelen_doldurma);

        long k = db.insert(TABLE_DOLDURMA, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        // database.close();
    }

    public Cursor getDoldurmaTipi(DatabaseHelper db) {

        SQLiteDatabase database=db.getReadableDatabase();
        String columns[]={COLUMN_DOLDURMAID,COLUMN_DOLDURMA_TIPI};

        Cursor cr=database.query(TABLE_DOLDURMA,columns,null,null,null,null,null);

        return cr;
    }

    ////////////////////////////////////////////////////////////
    ////// MAKINE RUTU ADLI SPINNER ICIN


    public void informationPutMakineRutu (DatabaseHelper database, String gelen_Rut) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_RUT_ADI, gelen_Rut);

        long k = db.insert(TABLE_RUTLAR, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //database.close();

    }
    MakineKonumlarDb getMakineKonumSingle (int position) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{COL1,
                        COL2}, COL1+ "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        MakineKonumlarDb  mak_konumdb=new MakineKonumlarDb();

        mak_konumdb.setId(cursor.getInt(cursor.getColumnIndex(COL1)));
        mak_konumdb.setKonum(cursor.getString(cursor.getColumnIndex(COL2)));
        // closeDB();
        return mak_konumdb;
    }


    public Cursor getMakineRutu(DatabaseHelper db) {

        SQLiteDatabase database=db.getReadableDatabase();
        String columns[]={COLUMN_RUT_ADI};
        Cursor cr=database.query(TABLE_RUTLAR,columns,null,null,null,null,null);

        return cr;

    }


    //////////////////////////////////////////////////////
    /////// YUKLEME ADLI SPINNER ICIN

    public void informationPutYuklemeAdi (DatabaseHelper database, String gelen_Yukleme) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_YUKLEMEADI, gelen_Yukleme);

        long k = db.insert(TABLE_YUKLEME, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();

    }

    public Cursor getYukleme(DatabaseHelper db) {

        SQLiteDatabase database=db.getReadableDatabase();
        String columns[]={COLUMN_YUKLEMEID,COLUMN_YUKLEMEADI};

        Cursor cr=database.query(TABLE_YUKLEME,columns,null,null,null,null,null);

        return cr;
    }

//////////////////////////////////////////////////////
///// KULLANICI'NIN BILGILERI

    public void informationPutKullaniciBilgiler (DatabaseHelper database, String gelen_ad, String gelen_parola) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ADI, gelen_ad);
        cv.put(COLUMN_PAROLA, gelen_parola);
        long k = db.insert(TABLE_NAME_KULLANICIGIRISI, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
      //  database.close();

    }
    public Cursor getKullaniciBilgi(DatabaseHelper db) {
        SQLiteDatabase database=db.getReadableDatabase();
        String columns[]={COLUMN_ADI,COLUMN_PAROLA};
        Cursor cr=database.query(TABLE_NAME_KULLANICIGIRISI, columns, null, null, null, null, null);
        // closeDB();
        return  cr;
    }

    //////////////////////////////////////////////////////
 /////////// KONUMLAR SPINNER ICIN ( MAKINE KONUMLAR SINIFI ARACIĞIYLA)


    public void informationPutKonumlar (DatabaseHelper database, String gelen_konum) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL2, gelen_konum);

        long k = db.insert(TABLE_NAME, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");

         closeDB();


    }





    public List<MakineKonumlarDb> getAllkonumlar() {
        List<MakineKonumlarDb> contactList = new ArrayList<MakineKonumlarDb>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {
                MakineKonumlarDb  mak_konumdb=new MakineKonumlarDb();

                mak_konumdb.setId(cursor.getInt(cursor.getColumnIndex(COL1)));
                mak_konumdb.setKonum(cursor.getString(cursor.getColumnIndex(COL2)));

                contactList.add(mak_konumdb);
            } while (cursor.moveToNext());
        }

        //cursor.close();
        //  closeDB();
        return contactList;
    }

//////////////////////////////////////////////////////

///////// MAKINE BILGILER CLASSI ICIN

        public void informationPutMakineBilgiler (DatabaseHelper database,MakineBilgileri mb) {
            SQLiteDatabase db=database.getWritableDatabase();
            ContentValues cv= new ContentValues();

            cv.put(COLUMN2, mb.getMakineKodu());
            cv.put(COLUMN3,mb.getMakine_konumId());
            cv.put(COLUMN4, mb.getMakineTipi());
            cv.put(COLUMN5, mb.getSonYukleme());
            cv.put(COLUMN6, mb.getKanal_sayisi());
            long k=db.insert(TABLE_NAME2, null, cv);

            closeDB();

    }



    public ArrayList<MakineBilgileri> getAllMakineBilgilerByKonum(int contactID) {
        ArrayList<MakineBilgileri> BilgilerList = new ArrayList<MakineBilgileri>();

        String selectQ = "SELECT  * FROM " + TABLE_NAME2 + " WHERE "
                + COLUMN3 + "=" + String.valueOf(contactID) + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQ, null);

        if (cursor.moveToFirst()) {
            do {
                MakineBilgileri makBil=new MakineBilgileri(0);
                makBil.setMakineBilgiler(cursor.getInt(cursor.getColumnIndex(COLUMN1)),cursor.getString(cursor.getColumnIndex(COLUMN2)),cursor.getInt(cursor.getColumnIndex(COLUMN3)),cursor.getString(cursor.getColumnIndex(COLUMN4)),cursor.getString(cursor.getColumnIndex(COLUMN5)),cursor.getInt(cursor.getColumnIndex(COLUMN6)));
                BilgilerList.add(makBil);
            } while (cursor.moveToNext());
        }

        return BilgilerList;
    }


    //////////////////////////////////////////////////////
    ///// ICECEKLER ADLI SPINNER ICIN

    public void informationPutIcecekler (DatabaseHelper database, String gelen_icecek) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ICECEK, gelen_icecek);
        long k = db.insert(TABLE_NAME_ICECEK, null, cv);
       Log.d("veritabanina", " icecek kayit girildi");

        closeDB();

    }


    public ArrayList<IceceklerListesi> getAllIcecekler() {

       ArrayList<IceceklerListesi> icecek_dizisi=new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME_ICECEK;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {
                IceceklerListesi  bir_icecek=new IceceklerListesi();

                bir_icecek.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_ICECEK)));
                bir_icecek.setIcecek_ismi(cursor.getString(cursor.getColumnIndex(COLUMN_ICECEK)));

                icecek_dizisi.add(bir_icecek);

            } while (cursor.moveToNext());
        }

        return icecek_dizisi;
    }



    IceceklerListesi getIcecekSingle(int position) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_ICECEK, new String[]{COLUMN_ID_ICECEK,
                        COLUMN_ICECEK}, COLUMN_ID_ICECEK+ "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        IceceklerListesi  bir_icecek=new IceceklerListesi();

      bir_icecek.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_ICECEK)));
        bir_icecek.setIcecek_ismi(cursor.getString(cursor.getColumnIndex(COLUMN_ICECEK)));
     //  closeDB();
        return bir_icecek;

    }

    //////////////////////////////////////////////////////
    ////// URUN BILGILERI CLASSI ICIN

    public  void addUrunBilgileri(DatabaseHelper database ,UrunBilgileri bir_urun) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GELEN_MAKID,bir_urun.getGelen_makineId());
        cv.put(COLUMN_KANAL, bir_urun.getKanal());
        cv.put(COLUMN_URUN, bir_urun.getId_icecek());
        cv.put(COLUMN_ADET, bir_urun.getAdet());


        long k = db.insert(TABLE_NAME_YUKLEME_LISTESI, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();



    }

    public List<UrunBilgileri> getAllUrunBilgileri(DatabaseHelper database) {
        List<UrunBilgileri> contactList = new ArrayList<UrunBilgileri>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME_YUKLEME_LISTESI;

        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {
                UrunBilgileri  bir_nesne=new UrunBilgileri();

                bir_nesne.set_id(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                bir_nesne.setGelen_makineId(cursor.getInt(cursor.getColumnIndex(COLUMN_GELEN_MAKID)));
                bir_nesne.setKanal(cursor.getInt(cursor.getColumnIndex(COLUMN_KANAL)));
                bir_nesne.setId_icecek(cursor.getInt(cursor.getColumnIndex(COLUMN_URUN)));
                bir_nesne.setAdet(cursor.getInt(cursor.getColumnIndex(COLUMN_ADET)));

                contactList.add(bir_nesne);
            } while (cursor.moveToNext());
        }

        return contactList;
    }


    public List<UrunBilgileri> getAllUrunBilgileriByMakine(DatabaseHelper database,int gelen_makineId) {
        List<UrunBilgileri> contactList = new ArrayList<UrunBilgileri>();

        String selectQ = "SELECT  * FROM " + TABLE_NAME_YUKLEME_LISTESI + " WHERE "
                + COLUMN_GELEN_MAKID + "=" + String.valueOf(gelen_makineId) + ";";

        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQ, null);

        if (cursor.moveToFirst()) {
            do {
                UrunBilgileri  bir_nesne=new UrunBilgileri();


                bir_nesne.set_id(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                bir_nesne.setGelen_makineId(cursor.getInt(cursor.getColumnIndex(COLUMN_GELEN_MAKID)));
                bir_nesne.setKanal(cursor.getInt(cursor.getColumnIndex(COLUMN_KANAL)));
                bir_nesne.setId_icecek(cursor.getInt(cursor.getColumnIndex(COLUMN_URUN)));
                bir_nesne.setAdet(cursor.getInt(cursor.getColumnIndex(COLUMN_ADET)));
                contactList.add(bir_nesne);

            } while (cursor.moveToNext());
        }

        return contactList;
    }


    public UrunBilgileri getSingleUrunBilgisi(int kanal,int gelen_kod) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_YUKLEME_LISTESI, new String[]{COLUMN_ID, COLUMN_GELEN_MAKID, COLUMN_KANAL,
                        COLUMN_URUN, COLUMN_ADET}, COLUMN_KANAL + "=?" + " and " + COLUMN_GELEN_MAKID + "=?",
                new String[]{String.valueOf(kanal),String.valueOf(gelen_kod)} , null, null, null, null);
        UrunBilgileri bir_urunBilgisi=new UrunBilgileri();
        if (cursor.moveToFirst()) {


            bir_urunBilgisi.set_id(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
            bir_urunBilgisi.setGelen_makineId(cursor.getInt(cursor.getColumnIndex(COLUMN_GELEN_MAKID)));
            bir_urunBilgisi.setKanal(cursor.getInt(cursor.getColumnIndex(COLUMN_KANAL)));
            bir_urunBilgisi.setId_icecek(cursor.getInt(cursor.getColumnIndex(COLUMN_URUN)));
            bir_urunBilgisi.setAdet(cursor.getInt(cursor.getColumnIndex(COLUMN_ADET)));
        }


        return bir_urunBilgisi;
    }


    public void updateUrunBilgisi(DatabaseHelper database,UrunBilgileri bir_urun,int kanal,int gelenKod) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GELEN_MAKID,bir_urun.getGelen_makineId());
        cv.put(COLUMN_KANAL, bir_urun.getKanal());
        cv.put(COLUMN_URUN, bir_urun.getId_icecek());
        cv.put(COLUMN_ADET, bir_urun.getAdet());


        long k = db.update(TABLE_NAME_YUKLEME_LISTESI, cv, COLUMN_KANAL + "=" + kanal + " and " + COLUMN_GELEN_MAKID + "=" + gelenKod, null);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
    }


//////////////////////////////////////////////////////
/////  GEREKLI TABLOLAR SILINIR

    public  void deleteAll () {
        SQLiteDatabase db = this.getWritableDatabase();

      //  db.delete(TABLE_NAME_KULLANICIGIRISI,null,null);
      db.delete(TABLE_NAME_YUKLEME_LISTESI,null,null);
        db.close();
    }


////////// VERITABANI KAPATMA ISLEMI

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }


}
