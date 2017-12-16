package com.example.pc.sadear_ge;

import java.util.StringTokenizer;

/**
 * Created by pc on 3.8.2015.
 */
public class MakineKonumlarDb {

     private  Integer id;
    private  String konum;

    public MakineKonumlarDb() {
        id=0;
        konum="Konum Seciniz";
    }

    public MakineKonumlarDb( int gelenId, String gelenKonum) {
        id=gelenId;
        konum=gelenKonum;
    }


    public void setBilgiler(int i1 ,String s2) {
        id=i1;
        konum=s2;

    }

    public void setKonum(String knm) {
        konum=knm;
    }

    public  void setId(int i) {
        id=i;
    }

    public String getKonum() {
        return konum;
    }


    public Integer getIdKonum() {
        return id;
    }
}
