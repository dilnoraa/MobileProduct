package com.example.pc.sadear_ge;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Hashtable;

public class Giris extends ActionBarActivity {

    DatabaseHelper myDatabase;
    ImageButton ihtiyacListesi;
    Spinner spMakineKonum,spMakineKodu;
    Button bt;
    TextView sonYukleme;
    static int durum=1;
    TextView txtMakineTip;
    int makineKoduId;
    int kanal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        ihtiyacListesi= (ImageButton) findViewById(R.id.imageButtonihtiyacListe);


       spMakineKonum= (Spinner) findViewById(R.id.spinnerKonum);
        spMakineKodu= (Spinner) findViewById(R.id.spinnerMakineKodu);
        bt= (Button) findViewById(R.id.buttonYukleme);
        sonYukleme= (TextView) findViewById(R.id.textViewSonYukleme);
        myDatabase=new DatabaseHelper(this);

        txtMakineTip= (TextView) findViewById(R.id.textviewMakinetipi);

// Veritabanında konumlar adlı tablo bos mu değil mı kontrol ediliyor
        ArrayList<MakineKonumlarDb> konumlar1= (ArrayList<MakineKonumlarDb>) myDatabase.getAllkonumlar();


        if(konumlar1.size()==0) { // Boşsa veriler eklenir

            myDatabase.informationPutKonumlar(myDatabase, "Konum Seciniz");
            myDatabase.informationPutKonumlar(myDatabase, "CMS JANT SANAYİ BORNOVA");
            myDatabase.informationPutKonumlar(myDatabase, "UPS KARGO");
            myDatabase.informationPutKonumlar(myDatabase, "SUN EXPRESS İZMİR");
            myDatabase.informationPutKonumlar(myDatabase, "KONFOR MOBİLYA");
            myDatabase.informationPutKonumlar(myDatabase, "ÇAKIRLAR OTO");
            myDatabase.informationPutKonumlar(myDatabase, "JMS CANT ÇİĞLİ");
            myDatabase.informationPutKonumlar(myDatabase, "BALIKESİR ASKERİYE");
            myDatabase.informationPutKonumlar(myDatabase, "STANDART CİVATA");
            myDatabase.informationPutKonumlar(myDatabase, "OBEL CİVATA");
            myDatabase.informationPutKonumlar(myDatabase, "ETEPAK AMBALAJ");
            myDatabase.informationPutKonumlar(myDatabase, "VANSAN MAKİNA");

            MakineBilgileri makineB1 = new MakineBilgileri(1); // bazı nesneler argüman olarak sadece Makine Konumu sınıfının Id'si alırlar,çünkü bu konuma ait bilgiler bulunmamaktadır
            MakineBilgileri makineB2 = new MakineBilgileri(2);
            MakineBilgileri makine_B2 = new MakineBilgileri("UPS KARGO YEMEKHANE", 2, "VENDO544", " 20.04.2015 12:37:17 ",7);
            MakineBilgileri makineB3 = new MakineBilgileri(3);
            MakineBilgileri makine_B3 = new MakineBilgileri("SELCUK ECZA DEPOSU", 3, "gdrink5", " 21.07.2015 15:00:36 ",8);
            MakineBilgileri makineB4 = new MakineBilgileri(4);
            MakineBilgileri makineB5 = new MakineBilgileri(5);
            MakineBilgileri makine_B5 = new MakineBilgileri("CAKIRLAR HUNDAI", 5, " Gdrink5", " 23.07.2015 19:35:16 ",9);
            MakineBilgileri makine_B5_ = new MakineBilgileri("DİRİNLER(2)", 5, "Gdrink6", " 14.07.2015 16:18:18 ",10);
            MakineBilgileri makineB6 = new MakineBilgileri(6);
            MakineBilgileri makine_B6 = new MakineBilgileri("SAFKAR", 6, "Gdrink5", " 24.07.2015 19:04:39 ",11);
            MakineBilgileri makineB7 = new MakineBilgileri(7);
            MakineBilgileri makineB8 = new MakineBilgileri(8);
            MakineBilgileri makine_B8 = new MakineBilgileri("STANDART CİVATA", 8, " Gdrink5", " 22.07.2015 17:21:28 ",12);
            MakineBilgileri makineB9 = new MakineBilgileri(9);
            MakineBilgileri makine_B9 = new MakineBilgileri("ŞOK DEPO", 9, "Gdrink5", " 22.07.2015 20:39:37 ",13);
            MakineBilgileri makineB10 = new MakineBilgileri(10);
            MakineBilgileri makine_B10 = new MakineBilgileri("ETEPAK AMBALAJ", 10, "Gdrink5", " 24.07.2015 16:02:41 ",14);
            MakineBilgileri makineB11 = new MakineBilgileri(11);
            MakineBilgileri makine_B11 = new MakineBilgileri("KAPLAMİN YÜKLEME ALANI",11, "Gdrink6", " 09.07.2015 15:27:46 ",15);





            myDatabase.informationPutMakineBilgiler(myDatabase, makineB1);
            myDatabase.informationPutMakineBilgiler(myDatabase, makineB2);
            myDatabase.informationPutMakineBilgiler(myDatabase, makine_B2);
            myDatabase.informationPutMakineBilgiler(myDatabase, makineB3);
            myDatabase.informationPutMakineBilgiler(myDatabase, makine_B3);
            myDatabase.informationPutMakineBilgiler(myDatabase, makineB4);

            myDatabase.informationPutMakineBilgiler(myDatabase, makineB5);
            myDatabase.informationPutMakineBilgiler(myDatabase, makine_B5);
            myDatabase.informationPutMakineBilgiler(myDatabase, makine_B5_);
            myDatabase.informationPutMakineBilgiler(myDatabase, makineB6);
            myDatabase.informationPutMakineBilgiler(myDatabase, makine_B6);

            myDatabase.informationPutMakineBilgiler(myDatabase, makineB7);
            myDatabase.informationPutMakineBilgiler(myDatabase, makineB8);
            myDatabase.informationPutMakineBilgiler(myDatabase, makine_B8);
            myDatabase.informationPutMakineBilgiler(myDatabase, makineB9);
            myDatabase.informationPutMakineBilgiler(myDatabase, makine_B9);
            myDatabase.informationPutMakineBilgiler(myDatabase, makineB10);
            myDatabase.informationPutMakineBilgiler(myDatabase, makine_B10);
            myDatabase.informationPutMakineBilgiler(myDatabase, makineB11);
            myDatabase.informationPutMakineBilgiler(myDatabase, makine_B11);
        }



     // ihtiyaç listesine geçmek icin üstteki duğmeye basınca yeni bir aktivity olusturuluyor
        ihtiyacListesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentIhtiyac = new Intent(getApplicationContext(), ihtiyac_listesi.class);
                startActivity(intentIhtiyac);

            }
        });


        //tüm konumlar veritabanından alınıyor
        ArrayList<MakineKonumlarDb> konumlar= (ArrayList<MakineKonumlarDb>) myDatabase.getAllkonumlar();
        String konumlarDizisi[]=new String[konumlar.size()];

        //Makine Konumlar class'tan  sadece konumlar cekmek ıcın
        for(int i=0;i<konumlar.size();i++) {
            konumlarDizisi[i]=konumlar.get(i).getKonum();
        }

        // konumlar spinnere ataniyorlar
        ArrayAdapter<String> adapterKonum=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_tasarim,konumlarDizisi);
        spMakineKonum.setAdapter(adapterKonum);



  // eger spinnerdan herhangi bir konum secilecekse...
       spMakineKonum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

   // position 0 : makine seçiniz adlı satıra tıklandı bu ise belirsiz konum anlamına gelir o yuzden işlemler yapilmiyor
                if (position == 0) {
                    durum = 0;
                } else {
                    durum = 1;

//konum seçildiyse artik o konuma ait tum makine bilgileri alabiliriz...
                    final ArrayList<MakineBilgileri> tum_degerler = (ArrayList<MakineBilgileri>) myDatabase.getAllMakineBilgilerByKonum(position);

// makine bilgiler classından sadece makine kodlar alınıyor
                    String kodlar[] = new String[tum_degerler.size()];

                    for (int i = 0; i < tum_degerler.size(); i++) {

                        kodlar[i] = tum_degerler.get(i).getMakineKodu();

                    }
    // alınan  tüm makine kodlar spinnere ataniyorlar

                    ArrayAdapter<String> adapterKod = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_tasarim, kodlar);
                    spMakineKodu.setAdapter(adapterKod);


                    // eğer belirli bir makine kodu seçildiyse...
                    spMakineKodu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position2, long id) {

             // position2=0 ise yani makine seciniz adlı satıra basıldı o yuzden işlemler yapılmıyor
                            if (position2 == 0) {
                                durum = 0;
                            } else {
                                durum = 1;

                                // belli bir makine kodu seçildiyse Makine Tipi ve Son Yükleme edittextlere MakineBilgier adlı sınıfından belirli veriler atanıyor
                                txtMakineTip.setText(tum_degerler.get(position2).getMakineTipi());
                                sonYukleme.setText(tum_degerler.get(position2).getSonYukleme());
     // MakineBilgiler sınıfından Makine Kodunun Id ve kanal da alınıyor, daha sonra diğer activitiye atanacaklar.
                                makineKoduId = tum_degerler.get(position2).getId2();
                                kanal=tum_degerler.get(position2).getKanal_sayisi();


                            }
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }
            }




            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Yükleme buttona basıldıysa ...
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // yukardaki position  değeri 0 ise makine secilmedi anlamına gelir
         if(durum==0) {
             Toast.makeText(getApplicationContext(), "Makine Secilmedi !", Toast.LENGTH_SHORT).show();
         }else {

                CharSequence cs=sonYukleme.getText(); // son yüklemeyi diğer sayfaya aktarmak için
                Intent intent1 = new Intent(getApplicationContext(), UrunSecimi.class); // Urun Secimi adlı activitiye geçiyor
               intent1.putExtra("anahtar",cs);
             intent1.putExtra("anahtar1",makineKoduId); // makine kodu ID ve kanal Urun Seçimi adlı activitiye aktarıliyor
             intent1.putExtra("anahtar2",kanal);
                startActivity(intent1);
             finish();
            }}
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_giris, menu);
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
