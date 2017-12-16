package  com.example.pc.sadear_ge;

import android.view.LayoutInflater;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.List;
/**
 * Created by pc on 6.8.2015.
 */

 public class OzelAdaptor extends BaseAdapter {
    android.view.LayoutInflater LayoutInflater;
    List<UrunBilgileri2> list;
    Activity activity;





    public OzelAdaptor (Activity activity, List<UrunBilgileri2> mList) {
        LayoutInflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        list=mList;
        this.activity=activity;
    }




    @Override
    public int getCount() {
        return  list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        View satirView;
        satirView=LayoutInflater.inflate(R.layout.satir,null);
        TextView kanal,icecek,adet;
        kanal=(TextView)satirView.findViewById(R.id.textKanal);
        icecek=(TextView)satirView.findViewById(R.id.textIcecek);
        adet=(TextView)satirView.findViewById(R.id.textAdet);

        UrunBilgileri2 icec=list.get(position);

       kanal.setText(String.valueOf((icec.getKanal2())));
        icecek.setText(icec.get_icecek_ismi2());
        adet.setText(String.valueOf((icec.getAdet2())));

        // NumberFormat.getCurrencyInstance().format(0.5);







        return satirView;
    }
}
