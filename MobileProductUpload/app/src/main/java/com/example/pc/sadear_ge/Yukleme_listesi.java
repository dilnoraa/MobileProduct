package com.example.pc.sadear_ge;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Yukleme_listesi extends ActionBarActivity {


    Spinner spDoldurma,spYL;
    ImageButton imageEv,geriye;

    DatabaseHelper myDb;
    ListView lv;
    List<UrunBilgileri2> urunBilgisi2=new ArrayList<UrunBilgileri2>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yukleme_listesi);

        Bundle gelentarih=getIntent().getExtras();
        final CharSequence gelenyazi=gelentarih.getCharSequence("anahtar"); // Urun Secimi adlı activity'den Budle ile veriler alınıyor
        final int gelenkod=gelentarih.getInt("anahtar1");
        final int gelen_kanal=gelentarih.getInt("anahtar2");

        myDb = new DatabaseHelper(this);

        spDoldurma = (Spinner) findViewById(R.id.spinnerDoldurmaTipi);
        spYL = (Spinner) findViewById(R.id.spinnerYL);
        imageEv = (ImageButton) findViewById(R.id.imageButtonEv);
        geriye = (ImageButton) findViewById(R.id.imageButtonGeriye);


        lv = (ListView) findViewById(R.id.listView);

 // listviewi kaydırmak için
        lv.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });


        OzelAdaptor adaptor = new OzelAdaptor(this, urunBilgisi2);
        lv.setAdapter(adaptor);

// tüm ürün bilgileri makine Id'ye  göre databaseden alınıyorlar
        ArrayList<UrunBilgileri> urunler = (ArrayList<UrunBilgileri>) myDb.getAllUrunBilgileriByMakine(myDb,gelenkod);

// urunBilgiler sınıfında içeceğin ismi yok sadece Id'si vardır
        for (int i = 0; i < urunler.size(); i++) {
  // içeceğin Id'si alınıyor
            int id_içecek = urunler.get(i).getId_icecek();
   //urunBilgisi sınıfında ise içeceğin Id yerine içeceğin ismi var
            //UrunBilgisi sınıfında içeçeğin ismi atamak için Icecekler tablosundan içeceğin ismi alınıyor
            urunBilgisi2.add(new UrunBilgileri2(urunler.get(i).getKanal(), (myDb.getIcecekSingle(id_içecek).getIsim()).toString(), urunler.get(i).getAdet()));


        }

// geriye buttona basıldığında...
        geriye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence cs=gelenyazi;
                // UrunSecimi adlı activitiye dönülüyor
                // gerekli veriler de o activity'ye aktarılıyorlar
                  Intent intentGeriye = new Intent(getApplicationContext(), UrunSecimi.class);
                intentGeriye.putExtra("anahtar", cs);
                intentGeriye.putExtra("anahtar1",gelenkod);
                intentGeriye.putExtra("anahtar2",gelen_kanal);

                startActivity(intentGeriye);
                finish();



            }
        });

      //Bu buttona basıldığında Giriş activity'ye dönülüyor
        imageEv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEv = new Intent(getApplicationContext(), Giris.class);
                startActivity(intentEv);
                finish();
            }
        });


       // Yukleme tablosunda veriler var mı yok mu diye kontrol ediliyor...

        ArrayList<String> yuklemeler1 = new ArrayList<String>();
        Cursor cr1=myDb.getYukleme(myDb);
        cr1.moveToFirst();
        while(cr1.moveToNext()){

            yuklemeler1.add(cr1.getString(1).toString());

        }


   // eğer veriler yoksa tabloya veriler kaydediliyor
        if(yuklemeler1.size()==0) {

            myDb.informationPutYuklemeAdi(myDb, "BevMax4-Eğitim-Üniversite BevMax");
            myDb.informationPutYuklemeAdi(myDb, "BevMax4-Hastane BevMax");
            myDb.informationPutYuklemeAdi(myDb, "Bevmax4-İşyeri-Fabrika&Ofis v1");
            myDb.informationPutYuklemeAdi(myDb, "Bevmax4-İşyeri-Fabrika&amp;Ofis v1");
            myDb.informationPutYuklemeAdi(myDb, "Gdrink5-Eğitim-Üniversite  Gdrink");
            myDb.informationPutYuklemeAdi(myDb, "Gdrink5-Hastane-Hastane-Gdrink");
            myDb.informationPutYuklemeAdi(myDb, "Gdrink5-İşyeri-Fabrika&Ofis Gdrink5 v1");
            myDb.informationPutYuklemeAdi(myDb, "Gdrink5-İşyeri-Fabrika&Ofis Gdrink5 v2");
            myDb.informationPutYuklemeAdi(myDb, "Gdrink6 - Eğitim-Üniversite GDrink 6 Raf");
            myDb.informationPutYuklemeAdi(myDb, "Gdrink6 - Hastane-Hastane GDrink 6 Raf");
            myDb.informationPutYuklemeAdi(myDb, "Gdrink6 - İşyeri-Fabrika&;Ofis GDrink 6 Raf V1");
            myDb.informationPutYuklemeAdi(myDb, "Gdrink6 - İşyeri-Fabrika&Ofis GDrink 6 Raf V2");
            myDb.informationPutYuklemeAdi(myDb, "Vendo544 - Askeriye-Askeriye v1");
            myDb.informationPutYuklemeAdi(myDb, "Vendo544 - Askeriye-Askeriye V2");
            myDb.informationPutYuklemeAdi(myDb, "Vendo544 - Askeriye-Askeriye V3");


        }

// Yükleme tablosundan tum değerler alınıyor
        ArrayList<String> yuklemeler = new ArrayList<String>();
        Cursor cr=myDb.getYukleme(myDb);
        cr.moveToFirst();
        do{

            yuklemeler.add(cr.getString(1).toString());

        }while(cr.moveToNext());
// bu veriler spinnere atanıyorlar
        ArrayAdapter<String> adapterYukL=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_tasarim,yuklemeler);
        spYL.setAdapter(adapterYukL);


        ArrayList<String> doldurma = new ArrayList<String>();
        Cursor cr_d=myDb.getDoldurmaTipi(myDb);
        cr_d.moveToFirst();
        while(cr_d.moveToNext()){

            doldurma.add(cr_d.getString(1).toString());

        }
 // Doldurma Tipi tablosuna veriler ekleniyorlar
        if(doldurma.size()==0) {

            myDb.informationPutDoldurmaTipi(myDb, "Yükleme");
            myDb.informationPutDoldurmaTipi(myDb, "Servis");
            myDb.informationPutDoldurmaTipi(myDb, "Setup");
            myDb.informationPutDoldurmaTipi(myDb, "Test");
            myDb.informationPutDoldurmaTipi(myDb, "Otomatik Yükleme");
        }



        ArrayList<String> doldurmaTipler = new ArrayList<String>();
        Cursor cursor_doldur=myDb.getDoldurmaTipi(myDb);
        cursor_doldur.moveToFirst();
        do{

            doldurmaTipler.add(cursor_doldur.getString(1).toString());

        }while(cursor_doldur.moveToNext());
        ArrayAdapter<String> adapterDoldurma = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_tasarim, doldurmaTipler);
 // spinnere doldurma tipleri atanıyorlar
        spDoldurma.setAdapter(adapterDoldurma);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yukleme_listesi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
