package com.example.pc.sadear_ge;

/**
 * Created by pc on 27.7.2015.
 */
public class MakineBilgileri {

    private Integer id2;
    private String makineKodu;
    private Integer makineKonum_id;
    private  String makineTipi;
    private  String sonYukleme;
    private Integer kanal_sayisi;

    public MakineBilgileri(Integer mKonumId) {
        id2=0;
        makineKodu="makine seciniz";
        makineKonum_id=mKonumId;
        makineTipi="____________";
        sonYukleme="____________";
        kanal_sayisi=0;

    }
    public MakineBilgileri(String makineKodu1,Integer mKonumId, String makineTipi1,String sonYukleme1,Integer gelen_kanal) {
        makineKodu=makineKodu1;
        makineKonum_id=mKonumId;
        makineTipi=makineTipi1;
        sonYukleme=sonYukleme1;
        kanal_sayisi=gelen_kanal;
    }

    public void setMakineBilgiler(Integer i,String s1 ,Integer i2,String s2 ,String s3,Integer k1) {
        id2=i;
        makineKodu=s1;
        makineKonum_id=i2;
        makineTipi=s2;
        sonYukleme=s3;
        kanal_sayisi=k1;
    }



    public void setMakineTipi( String s1) {
        makineTipi=s1;
    }

    public  void setMakineKodu(String s2) {
        makineKodu=s2;
    }

    public void setSonYukleme (String s3)
    {
        sonYukleme=s3;
    }

    public void setKanal_sayisi(Integer kanal_sayisi1) { kanal_sayisi=kanal_sayisi1;}

    public Integer getId2(){
        return id2;
    }

    public String getMakineKodu () {
        return makineKodu;
    }
    public Integer getMakine_konumId() {
        return makineKonum_id;
    }

    public String getMakineTipi() {
        return  makineTipi;
    }

    public  String getSonYukleme() {
        return sonYukleme;
    }

    public Integer getKanal_sayisi() { return kanal_sayisi;}



}
