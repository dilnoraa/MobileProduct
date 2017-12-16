package com.example.pc.sadear_ge;

/**
 * Created by pc on 4.8.2015.
 */
public class IceceklerListesi {
    private Integer id;
    private  String icecek_ismi;


    public IceceklerListesi() {
        id=0;
        icecek_ismi="";
    }


    public IceceklerListesi (Integer gelen_id, String gelenIcecek_ismi) {
        id=gelen_id;
        icecek_ismi=gelenIcecek_ismi;
    }

    public void setIcecek_ismi (String gelen_isim) {
        icecek_ismi=gelen_isim;
    }

    public int getId () {
        return  id;
    }
    public void setId (int gelenId) {
        id=gelenId;
    }

    public String getIsim() {
        return  icecek_ismi;
    }
}
