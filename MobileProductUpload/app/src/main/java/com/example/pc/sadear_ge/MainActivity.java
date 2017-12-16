package com.example.pc.sadear_ge;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    DatabaseHelper db;
    EditText kullaniciAd,parola;
    String ad_string, parola_string;
    int basarili=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);

        kullaniciAd= (EditText) findViewById(R.id.editTextKullaniciAd);
        parola= (EditText) findViewById(R.id.editTextParola);


        db.deleteAll();// database'den gerekli tablolar siliniyor


// Veritabanında kullanıcı bilgiler var mı diye kontrol edılıyor
        ArrayList<String> kullanicilar=new ArrayList<String>();
        Cursor cr1=db.getKullaniciBilgi(db);
        cr1.moveToFirst();
        while(cr1.moveToNext()){

          kullanicilar.add(cr1.getString(0).toString());
        }



        // eğer bilgiler eklenmediyse Kullanıcı Bilgileri adlı tabloya kullanıcının adı ve parola kaydediliyor

        if(kullanicilar.size()==0) {
            db.informationPutKullaniciBilgiler(db, "efe1", "123");
            db.informationPutKullaniciBilgiler(db, "a", "a");
        }
    }


    // Giris adlı buttona basıldıysa...
    public void Basildi(View v) {

        ad_string=kullaniciAd.getText().toString();
        parola_string=parola.getText().toString();
        Cursor cr=db.getKullaniciBilgi(db);
        cr.moveToFirst();
        do{
          if(ad_string.equals(cr.getString(0))&& parola_string.equals(cr.getString(1)))// kullanııcn girdiği veriler ile databasedeki veriler eşleştırıyorlar
          {
              // eşit ise giriş başarılı ile gerçekleştı,yeni bir activity oluşuyor
              Toast.makeText(getApplication(),"Basarili...",Toast.LENGTH_SHORT).show();
              Intent intent = new Intent(getApplicationContext(), Giris.class);
              startActivity(intent);
              basarili=1;

          }
            else// eşleşmediyse kullanıcı tekrar adı ve parolayı edittextlere yazabilir
              basarili=0;

        }while(cr.moveToNext());


        if(basarili==0) {
            Toast.makeText(getApplication(),"Basarisız Tekrar Deneyiniz...",Toast.LENGTH_SHORT).show();
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
