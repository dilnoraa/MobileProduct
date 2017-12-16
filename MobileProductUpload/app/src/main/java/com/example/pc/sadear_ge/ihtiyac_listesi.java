package com.example.pc.sadear_ge;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class ihtiyac_listesi extends ActionBarActivity {

    Spinner spRutlar;
    MultiSelectionSpinner spKod;
    ImageButton btUrunYukleme;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ihtiyac_listesi);

        db=new DatabaseHelper(this);

        spRutlar= (Spinner) findViewById(R.id.spinnerRutlar);
        spKod= (MultiSelectionSpinner) findViewById(R.id.spinnerKod);
        btUrunYukleme= (ImageButton) findViewById(R.id.imageButtonUrunYukleme);


        // veritabanında Rütlar tablosu boş mu dolu kontrol ediliyor
        Cursor cr1=db.getMakineRutu(db);
        if (!cr1.moveToFirst()) {
  // tablo boşsa Rutlar database kaydediliyor
            db.informationPutMakineRutu(db, "Tüm Rütlar");
            db.informationPutMakineRutu(db, "AYDIN VE DENIZLI ");
            db.informationPutMakineRutu(db, "BORNOVA");
            db.informationPutMakineRutu(db, "CIĞLI");
            db.informationPutMakineRutu(db, "FABRIKAYA GIDEN ");

            db.informationPutMakineRutu(db, "GAZİEMİR");
            db.informationPutMakineRutu(db, "KEMALPAŞA");
            db.informationPutMakineRutu(db, "TORBALI");
        }



        // Tüm rutlar database'den alınıyor
        Cursor cr=db.getMakineRutu(db);
     final    ArrayList<String> rutlar=new ArrayList<String>();
        cr.moveToFirst();
        do{

            rutlar.add(cr.getString(0).toString());
        }while(cr.moveToNext());


  // alınan rutlar spinnere ataniyorlar
        ArrayAdapter<String> adapterRut=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_tasarim,rutlar);
        spRutlar.setAdapter(adapterRut);




// urunYukleme adlı buttona basıldığında Giriş adlı activitiye dönülüyor.
        btUrunYukleme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUrunYukleme = new Intent(getApplicationContext(), Giris.class);
                startActivity(intentUrunYukleme);
                finish();
            }
        });

       // Multispinner için  databaseden veriler alınıyor , tablonun boş olup olmadığına bakılıyor
        ArrayList<String> kod_dizi = new ArrayList<String>();
        Cursor cursor=db.getMakineKodMulti(db);
        cursor.moveToFirst();
        while(cursor.moveToNext()){

            kod_dizi.add(cursor.getString(0).toString());

        }


        //Boşsa ekle...

        if(kod_dizi.size()==0) {
            db.informationKodMulti(db, "A YANGIN");
            db.informationKodMulti(db, "AHMET YAR");
            db.informationKodMulti(db, "BARAN AMBALAJ");
            db.informationKodMulti(db, "BATI BASMA");
            db.informationKodMulti(db, "BAYLAN SU SAYAÇLARI");
            db.informationKodMulti(db, "CEVA LOJİSTİK");
            db.informationKodMulti(db, "CEVHER DÖKÜM");
            db.informationKodMulti(db, "CMS-1");
            db.informationKodMulti(db, "DEKORPAN");
            db.informationKodMulti(db, "DİRİNLER");
            db.informationKodMulti(db, "DR OETKER");
            db.informationKodMulti(db, "EFE ENDÜSTRİ");

            db.informationKodMulti(db, "EGE MEZE");
            db.informationKodMulti(db, "EGE PROFİL");
            db.informationKodMulti(db, "ERENLİ PLASTİK");
            db.informationKodMulti(db, "EKOTEM");
            db.informationKodMulti(db, "FİTNESS COMPANY");
            db.informationKodMulti(db, "FOLKARS");
            db.informationKodMulti(db, "FORUM BORNOVA");

        }


        // makine kodları veritabanından alınıyorlar...
      final   ArrayList<String> kodlar = new ArrayList<String>();
        Cursor cursor_kodlar=db.getMakineKodMulti(db);
        cursor_kodlar.moveToFirst();
        do{

            kodlar.add(cursor_kodlar.getString(0).toString());

        }while(cursor_kodlar.moveToNext());




   // bu veriler Multispinnere ataniyorlar
        spKod.setItems(kodlar);

      // rutlar spinner tıkladığında toast mesajı çıkıyor
           spRutlar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getApplicationContext(), "Seçtiğiniz rut: " + rutlar.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // makine kodu olan multispinner tıkladığında Toast mesajı çıkıyor
        spKod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(getApplicationContext(),"Seçtiğiniz Makine Kodu: "+kodlar.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ihtiyac_listesi, menu);
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
