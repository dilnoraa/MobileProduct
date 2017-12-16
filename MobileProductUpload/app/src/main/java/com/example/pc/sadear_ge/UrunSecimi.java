package com.example.pc.sadear_ge;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class UrunSecimi extends ActionBarActivity {

    TextView sonTarih,makine_kodu;
    Spinner spUrun;
    Spinner spAdet;
    Spinner spAralik;
    ImageButton btYuklemeListesi;
    Button buttonOnceki;
    EditText etBaslangic, etBitis;
    int durum2=0;

    UrunBilgileri bir_urun_bilgileri;

    DatabaseHelper myDatabase;


    int kanal;
    int baslangic_tut=0;
    int bitis_tut=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_secimi);

        sonTarih= (TextView) findViewById(R.id.textViewSonTarih);
        makine_kodu= (TextView) findViewById(R.id.makineKodu);
        Bundle gelentarih=getIntent().getExtras();
        CharSequence gelenyazi=gelentarih.getCharSequence("anahtar"); // önceki activity'den (Giriş) gelen bilgiler Budle ile alınıyorlar
        final int gelenkod=gelentarih.getInt("anahtar1");
        final int gelenkanal=gelentarih.getInt("anahtar2");
        sonTarih.setText(gelenyazi); // "Son Yükleme" textviewe kaydedılıyor
        makine_kodu.setText(String.valueOf(gelenkod));

        spUrun= (Spinner) findViewById(R.id.spinnerUrun);
        spAdet= (Spinner) findViewById(R.id.spinnerAdet);
        spAralik= (Spinner) findViewById(R.id.spinnerAralik);
        btYuklemeListesi= (ImageButton) findViewById(R.id.buttonYuklemeListe);
        etBaslangic= (EditText) findViewById(R.id.edittextBaslangic);
        etBitis= (EditText) findViewById(R.id.edittextBitis);

        buttonOnceki= (Button) findViewById(R.id.buttonOnceki);

        bir_urun_bilgileri=new UrunBilgileri(); // belirli verileri tutmak için bır nesne oluşturuluyor
        bir_urun_bilgileri.setGelen_makineId(gelenkod); // Bu nesneye MakineBilgiler sınıfından olan Id atanıyor

        myDatabase=new DatabaseHelper(this);

        //veritabanında içecekler tablosu boş mu dolu mu..
        final ArrayList<IceceklerListesi> icecekler1= (ArrayList<IceceklerListesi>) myDatabase.getAllIcecekler();

        // boşsa içecekler eklenir
        if(icecekler1.size()==0) {

            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Fanta 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Sprite 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola Zero 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Coke Light 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Şeftali 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA KARPUZ 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA SEFTALI KUTU330");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Meyve Tanem Şeftali 330 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Karadut 330 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Karışık  330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Pulpy Portakal 330 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Nestea Şeftali 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera Meyveli Elma 200 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera Meyveli Limon 200 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera Sade 200 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera 200 ml OWB meyveli");
            myDatabase.informationPutIcecekler(myDatabase, "Damla 500 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola 200 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Schweppes Mandalina 250 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Burn 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Damla 330 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy 200ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy 330 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Sprite 200 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Sprite 250 ml RB");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera Meyveli Çilek 200 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA LIMON 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA MAN.ANANAS. 330 Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Tropik 200 ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Tropik 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola 250 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola 250 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola 200 ml RB");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola 250 ml RB");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola 450 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola Light 250 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Coke Light 450 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Coke Zero 250 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola Zero 450 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Schweppes Limon 250 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy %100 Saf Portakal 200 ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy %100 Turunçgiller 200 ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Çilekli Limonata 330 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Elma 200 ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Elma 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Karışık  200 ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Kayısı 200 ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Kayısı 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Kırmızı Meyveler 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Limonata 330 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Portakal 200 ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Portakal 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Sarı Meyveler 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Şeftali 200 ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Vişne 200 ml Tetra");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Vişne 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Fanta 200 ml RB");
            myDatabase.informationPutIcecekler(myDatabase, "Fanta 250 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Fanta 250 ml RB");
            myDatabase.informationPutIcecekler(myDatabase, "Fanta 500 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Fanta Kan Portakal 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Fanta Mandalina 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Gladiatör 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Nestea Limon 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Nestea Mango - Ananas 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Powerade Ice Blast 500 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera Meyveli Mandalina 200 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera Meyveli Vişne 200 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Burn Blue 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Karışık Meyve Tanem 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera Soda 330 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera Soda 750 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Damla MP 330 Çocuk");
            myDatabase.informationPutIcecekler(myDatabase, "Damla OWB 330 ml");
            myDatabase.informationPutIcecekler(myDatabase, "Damla OWB 750 ml");
            myDatabase.informationPutIcecekler(myDatabase, "Schweppes Tonik 250 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Nestea Cool 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Burn Blue 500 ml");
            myDatabase.informationPutIcecekler(myDatabase, "Burn Berry 500 ml");
            myDatabase.informationPutIcecekler(myDatabase, "Burn 500 ml");
            myDatabase.informationPutIcecekler(myDatabase, "Powerade Citrus Charge 500 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Powerade Sun Rush 500 ml Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Cappy Atom 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola Light 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola Light 330 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola Light 450 Pet");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola Zero 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Coca-Cola Zero 250 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Damla Minera 200 ml OWB Meyveli");
            myDatabase.informationPutIcecekler(myDatabase, "Fanta 200 ml OWB");
            myDatabase.informationPutIcecekler(myDatabase, "Fanta 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA 250 ml Can Grup");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA 330 ml Can Grup");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA Karpuz 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA Limon 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA Man.Ananas 250 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "FUSE TEA Şeftali 205 ml Can");
            myDatabase.informationPutIcecekler(myDatabase, "Kredi Kartı Satış");
            myDatabase.informationPutIcecekler(myDatabase, "Sprite 250 ml Can");
            myDatabase.closeDB();

        }



        buttonOnceki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentOncekiyukle=new Intent(getApplicationContext(),Yukleme_listesi.class);
                startActivity(intentOncekiyukle);


            }
        });



       final ArrayList<IceceklerListesi> icecekler= (ArrayList<IceceklerListesi>) myDatabase.getAllIcecekler();

     // Icecekler listesinden sadece icecekler isimleri alınmaktadır, içeceklerDizisinde tutulacaklar
       final String iceceklerDizisi[]=new String[icecekler.size()];

        for(int i=0;i<icecekler.size();i++) {
            iceceklerDizisi[i]=icecekler.get(i).getIsim();

        }


       // bu içeceklerDizisi spinnere atanıyor

       ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_tasarim,iceceklerDizisi);
        spUrun.setAdapter(adapter);

 // eğer spinnerden belirli içecek tıklandıysa...
       spUrun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                   Toast.makeText(getApplicationContext(), "Sectiginiz icecek: " + iceceklerDizisi[position], Toast.LENGTH_SHORT).show();

                bir_urun_bilgileri.setId_icecek(icecekler.get(position).getId());// bu seçilen içecek nesneye atanıyor daha sonra database'ye kaydedılecektır

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


// spinner için "adet sayısı" dizisi üretiliyor
        Integer[] adet = new Integer[69];
        for(int i=0;i<69;i++) {
            adet[i]=i;
        }


        // bu dizi spinnere atanıyor
        ArrayAdapter adetAdapter = new ArrayAdapter( getApplicationContext(),R.layout.spinner_tasarim,adet );
        spAdet.setAdapter(adetAdapter);

        // spinner tıklandıysa ,seçilen adet nesneye atanıyor
        spAdet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               bir_urun_bilgileri.setAdet(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





       // onceki activity'den gelen Kanal sayısı kaç tane kanal olacaği belirliyor
       final Integer[] aralik = new Integer[gelenkanal];
        for(int i=0;i<gelenkanal;i++) {
            aralik[i]=i;
        }


     // kanallar spinnere atanıyorlar
        ArrayAdapter aralikAdapter =new ArrayAdapter(getApplicationContext(),R.layout.spinner_tasarim,aralik);
        spAralik.setAdapter(aralikAdapter);

       spAralik.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               // aralık aynı zamanda kullanıcı tarafından elle de değiştirilebilir onun için 2 tane edittext kullanılıyor başlangıç ve bitiş için
               etBaslangic.setText(Integer.toString(aralik[position])); // spinnerden seçilen kanallar edittexte atanıyorlar

               etBitis.setText(Integer.toString(aralik[position]));

               durum2 = aralik[position]; // kanal durum2' de tutuluyor daha sonra kullanılacaktır


           }


           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        // yukle (kaydet) buttonuna basıldığı zaman ...

        btYuklemeListesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (durum2 != 0) { // eğer kanal 0 değil ise ...
                    baslangic_tut = Integer.valueOf(etBaslangic.getText().toString()); // başlangıç ve bitiş sayıları alınıyor kanal sayısı hesaplanması ıçın
                    bitis_tut = Integer.valueOf(etBitis.getText().toString());

                    kanal = bitis_tut - baslangic_tut + 1;

                    baslangic_tut--;
                    for (int i = 0; i < kanal; i++) {
                        baslangic_tut++;
                        bir_urun_bilgileri.setKanal(baslangic_tut); // hesaplanan kanal nesneye atanıyor
     // doldurulan nesneyı artık database kaydedebiliriz
        // eğer daha önce seçilen kanal seçildiyse bu kanal veritabanında güncellenecektır
                        if (myDatabase.getSingleUrunBilgisi(baslangic_tut, gelenkod).getKanal().equals(baslangic_tut)) {
                            myDatabase.updateUrunBilgisi(myDatabase, bir_urun_bilgileri, baslangic_tut, gelenkod);
                        } else {
                            myDatabase.addUrunBilgileri(myDatabase, bir_urun_bilgileri); // eğer bir kanal ilk kez seçiliyorsa veritabanına ekleniyor
                        }


                    }
                }

                CharSequence cs = sonTarih.getText();

                //Yükleme Listesi adli activity' ye gerekli veriler gönderiliyor
                Intent intentYuklemeListesi = new Intent(getApplicationContext(), Yukleme_listesi.class);
                intentYuklemeListesi.putExtra("anahtar", cs);
                intentYuklemeListesi.putExtra("anahtar1", gelenkod);
                intentYuklemeListesi.putExtra("anahtar2", gelenkanal);
                startActivity(intentYuklemeListesi);


            }
        });

    }

// Button aracığıyla adet seçilecekse

    public void sayiTiklandi (View v) {
        switch (v.getId()) {
            case R.id.buttonBir:
                spAdet.setSelection(1);
                break;
            case R.id.buttonIki:
                spAdet.setSelection(2);
                break;
            case R.id.buttonUc:
                spAdet.setSelection(3);
                break;
            case R.id.buttonDort:
                spAdet.setSelection(4);
                break;
            case R.id.buttonBes:
                spAdet.setSelection(5);
                break;
            case R.id.buttonAlti:
                spAdet.setSelection(6);
                break;
            case R.id.buttonYedi:
                spAdet.setSelection(7);
                break;
            case R.id.buttonSekiz:
                spAdet.setSelection(8);
                break;
            case R.id.buttonDokuz:
                spAdet.setSelection(9);
                break;
            case R.id.buttonOn:
                spAdet.setSelection(10);
                break;
            case R.id.button11:
                spAdet.setSelection(11);
                break;
            case  R.id.buttonSifir:
                spAdet.setSelection(0);
                break;


        }
    }


// imageview'lerden içecek seçilecekse....
public void icecekTiklandi(View v )
{

    switch(v.getId()) {
        case R.id.cola330:
           spUrun.setSelection(0);
            break;

        case R.id.fanta330 :
            spUrun.setSelection(1);
            break;
        case R.id.sprite330 :
            spUrun.setSelection(2);
            break;

        case R.id.colazero330:
            spUrun.setSelection(3);
            break;

        case R.id.colalight330 :
            spUrun.setSelection(4);
            break;
        case R.id.cappysefta330 :
            spUrun.setSelection(5);
            break;

        case R.id.cappykaris330:
            spUrun.setSelection(12);
            break;

        case R.id.cappypulpy330 :
            spUrun.setSelection(13);
            break;
        case R.id.nesteasefta330 :
            spUrun.setSelection(14);
            break;

        case R.id.damlaelma200:
            spUrun.setSelection(15);
            break;

        case R.id.damlalimon200 :
            spUrun.setSelection(16);
            break;

        case R.id.damlaminerasade:
            spUrun.setSelection(17);
            break;

        case R.id.damlapet500:
            spUrun.setSelection(19);
            break;
        case R.id.colacan200:
            spUrun.setSelection(20);
            break;
        case R.id.schweppesmandal250:
            spUrun.setSelection(21);
            break;


        case R.id.burncan250:
            spUrun.setSelection(22);
            break;

        case R.id.damlapet330:
            spUrun.setSelection(23);
            break;

        case R.id.sprite200 :
            spUrun.setSelection(27);
            break;

        case R.id.sprite250:
            spUrun.setSelection(28);
            break;

        case R.id.damlacilek200:
            spUrun.setSelection(29);
            break;
        case R.id.cappytropik200:
            spUrun.setSelection(32);
            break;
        case R.id.cappytropik330:
            spUrun.setSelection(33);
            break;

        case R.id.cola250pet:
            spUrun.setSelection(34);
            break;



       case R.id.colaowb250:
            spUrun.setSelection(35);
            break;
        case R.id.colarb200:
            spUrun.setSelection(36);
            break;
        case R.id.colarb250:
            spUrun.setSelection(37);
            break;

        case R.id.colapet450:
            spUrun.setSelection(38);
            break;
        case R.id.colalight250:
            spUrun.setSelection(39);
            break;

        case R.id.colalight450pet:
            spUrun.setSelection(40);
            break;
        case R.id.colazero250:
            spUrun.setSelection(41);
            break;

        case R.id.colazero450pet:
            spUrun.setSelection(42);
            break;


        case R.id.schweppeslimon250:
            spUrun.setSelection(43);
            break;
        case R.id.cappysafportakal200:
            spUrun.setSelection(44);
            break;
        case R.id.cappyturuncg200:
            spUrun.setSelection(45);
            break;

        case R.id.cappycilek330:
            spUrun.setSelection(46);
            break;
        case R.id.cappyelma200:
            spUrun.setSelection(47);
            break;

        case R.id.cappyelma330can:
            spUrun.setSelection(48);
            break;
        case R.id.cappykarisik200:
            spUrun.setSelection(49);
            break;

        case R.id.cappykayisi200:
            spUrun.setSelection(50);
            break;

        case R.id.cappykayisi330can:
            spUrun.setSelection(51);
            break;

        case R.id.cappykirmizimey330can:
            spUrun.setSelection(52);
            break;


        case R.id.cappylimonata330:
            spUrun.setSelection(53);
            break;

        case R.id.cappyportakal200tetra:
            spUrun.setSelection(54);
            break;
        case R.id.cappyportakal330can:
            spUrun.setSelection(55);
            break;

        case R.id.cappysarmeyveler330:
            spUrun.setSelection(56);
            break;

        case R.id.cappyseftali200tetra:
            spUrun.setSelection(57);
            break;


        case R.id.cappyvisne200tetra:
            spUrun.setSelection(58);
            break;

        case R.id.cappyvisne330can:
            spUrun.setSelection(59);
            break;

        case R.id.fanta200rb:
            spUrun.setSelection(60);
            break;


        case R.id.fanta250pet:
            spUrun.setSelection(61);
            break;

        case R.id.fanta250rb:
            spUrun.setSelection(62);
            break;


        case R.id.fanta500pet:
            spUrun.setSelection(63);
            break;

        case R.id.fantaportakal330:
            spUrun.setSelection(64);
            break;
        case R.id.fantamandalina330:
            spUrun.setSelection(65);
            break;


        case R.id.gladiator250:
            spUrun.setSelection(66);
            break;

        case R.id.nestealimon330:
            spUrun.setSelection(67);
            break;


        case R.id.nesteamangoananas:
            spUrun.setSelection(68);
            break;

        case R.id.poweradeblast:
            spUrun.setSelection(69);
            break;


        case R.id.damlameyvelimandalina:
            spUrun.setSelection(70);
            break;

        case R.id.damlamineravisne:
            spUrun.setSelection(71);
            break;

        case R.id.burnblue250:
            spUrun.setSelection(72);
            break;



    }


}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_urun_secimi, menu);
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
