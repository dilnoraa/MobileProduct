package com.example.pc.sadear_ge;

/**
 * Created by pc on 5.8.2015.
 */
public class UrunBilgileri {
    private Integer id;
    private Integer gelen_makineId;
    private Integer kanal;
    private Integer id_icecek;
    private Integer adet;

    public UrunBilgileri() {
        id=0;
        kanal=0;
        id_icecek=0;
        adet=0;

    }

    public UrunBilgileri (Integer gelen_id_makine,Integer gelen_kanal,Integer gelen_id_icecek,Integer gelen_adet)
    {

        gelen_makineId=gelen_id_makine;
        kanal=gelen_kanal;
        id_icecek=gelen_id_icecek;
        adet=gelen_adet;
    }
    public void setUrunBilgileri(Integer gelen_id,Integer gelen_id_makine,Integer gelen_kanal,Integer gelen_id_icecek,Integer gelen_adet)
    {
        id=gelen_id;
        gelen_makineId=gelen_id_makine;
        kanal=gelen_kanal;
        id_icecek=gelen_id_icecek;
        adet=gelen_adet;
    }

    public Integer get_Id ()
    {
        return id;
    }
    public Integer getGelen_makineId() {return  gelen_makineId;}

    public Integer getKanal (){
        return kanal;
    }

    public Integer getId_icecek() {
        return id_icecek;
    }
    public Integer getAdet () {
        return adet;
    }


    public void set_id(Integer gelen_id) {
        id=gelen_id;
    }

    public void setGelen_makineId(Integer gelen_id_makine) { gelen_makineId=gelen_id_makine;}

    public void setKanal(Integer gelenKanal) {
        kanal=gelenKanal;
    }

    public void setId_icecek (Integer gelenIcecek) {
        id_icecek=gelenIcecek;
    }

    public void setAdet (Integer gelenAdet) {
        adet=gelenAdet;
    }
}
