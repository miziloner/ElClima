package app.com.example.alumno.elclima.View;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import app.com.example.alumno.elclima.Model.Clima;
import app.com.example.alumno.elclima.Model.Constants;
import app.com.example.alumno.elclima.R;
import app.com.example.alumno.elclima.ViewModel.IClimaViewModel;
import app.com.example.alumno.elclima.ViewModel.IClimaViewModelListener;

/**
 * Created by Alumno on 01/03/2016.
 */
public class ClimaView extends Fragment implements IClimaViewModel {
    IClimaViewModelListener mListener;


    private View rootView;
    private ListView listView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.clima_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView_datos);
        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        mListener.getWeatherFromService();
    }

    @Override
    public void setListener(IClimaViewModelListener listener) {
        mListener = listener;
    }

    @Override
    public void pintaClimasEnListView(ArrayList<Clima> losClimasDelWB) {
        Log.i("", "" + losClimasDelWB.size());

        //TODO crear instancia del adapter

        String miPrimerNombre = new String("Carlos  ");
        String miSegundoNombre = new String(" MAuricio ");

        ClimaAdapter adapter = new ClimaAdapter(getActivity().getApplicationContext(),R.layout.clima_listview_item,losClimasDelWB);

        //TODO falta setear el nuevo adapter al listview

        listView.setAdapter(adapter);
    }

    /*public String ponFecha(String fechaFea){

        Date today;
        String result;
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat("EEE d MMM yy", Locale.ENGLISH);
        today = new Date(fechaFea);
        result = formatter.format(today);

        return  result;

    }*/

    public class ClimaAdapter extends ArrayAdapter<Clima> {

        int layoutResourceId;
        ArrayList<Clima> losClimas;
        Context context;

        public ClimaAdapter(Context ctx, int resource, ArrayList<Clima> losCli) {

            super(ctx, resource);
            this.losClimas=losCli;
            this.context = ctx;
            this.layoutResourceId = resource;

        }


    public Clima getItem(int index) {
        return this.losClimas.get(index);
    }


    @Override
        public int getCount() {
            return losClimas.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                // ROW INFLATION
                Log.d("adapter", "Starting XML Row Inflation ... ");
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.clima_listview_item, parent, false);
                Log.d("adapyer", "Successfully completed XML Row Inflation!");
            }

            // Get item
            Clima elclima = getItem(position);


            TextView tvfecha = (TextView) row.findViewById(R.id.tvfecha);
           // TextView tvhora = (TextView) row.findViewById(R.id.tvhora);
            TextView tvminima = (TextView) row.findViewById(R.id.tvminima);
            TextView tvmaxima = (TextView) row.findViewById(R.id.tvmaxima);
            ImageView iv=(ImageView)row.findViewById(R.id.imageView);


            tvfecha.setText(elclima.fecha);
            tvminima.setText("minima:"+elclima.minima+" °C") ;
            tvmaxima.setText("maxima: "+elclima.maxima+" °C");

            String urlIcono = Constants.URL_ICON+ elclima.icono;

            Picasso.with(context).load(urlIcono).into(iv);

            //Log.d("adapyer", "fecha:" +ponFecha(elclima.fecha) );

            return row;

        }
    }


}
