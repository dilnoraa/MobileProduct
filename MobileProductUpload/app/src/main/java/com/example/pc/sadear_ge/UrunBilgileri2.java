package com.example.pc.sadear_ge;

/**
 * Created by pc on 7.8.2015.
 */
public class UrunBilgileri2 {

    private Integer kanal;
    private String icecek_ismi;
    private Integer adet;

    public UrunBilgileri2() {

        kanal=0;
        icecek_ismi=" ";
        adet=0;

    }

    public UrunBilgileri2 (Integer gelen_kanal,String gelen_icecek,Integer gelen_adet)
    {
        // id=gelen_id;
        kanal=gelen_kanal;
        icecek_ismi=gelen_icecek;
        adet=gelen_adet;
    }
    public void setUrunBilgileri2 (Integer gelen_kanal,String gelen_icecek,Integer gelen_adet)
    {

        kanal=gelen_kanal;
        icecek_ismi=gelen_icecek;
        adet=gelen_adet;
    }



    public Integer getKanal2 (){
        return kanal;
    }

    public String get_icecek_ismi2 () {
        return icecek_ismi;
    }
    public Integer getAdet2 () {
        return adet;
    }



    public void setKanal2 (Integer gelenKanal) {
        kanal=gelenKanal;
    }

    public void setIcecek_ismi2 (String gelenIcecek) {
        icecek_ismi=gelenIcecek;
    }

    public void setAdet2 (Integer gelenAdet) {
        adet=gelenAdet;
    }
}
