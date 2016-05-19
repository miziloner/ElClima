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
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.com.example.alumno.elclima.Model.Clima;
import app.com.example.alumno.elclima.R;
import app.com.example.alumno.elclima.ViewModel.IClimaViewModel;
import app.com.example.alumno.elclima.ViewModel.IClimaViewModelListener;

/**
 * Created by Alumno on 01/03/2016.
 */
public class ClimaView extends Fragment implements IClimaViewModel {

    private ArrayAdapter<String> datosAdapter;

    IClimaViewModelListener mListener;
    private View rootView;
    private ListView listView;

    public ClimaView() {
    }


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
        //TODO
        //TODO crear instancia del adapter
        Log.i("", "" + losClimasDelWB.size());

        ArrayList<String> minimasArrayList = new ArrayList<String>();

        for(int i = 0 ; i <losClimasDelWB.size();i++){
            Log.i("ClimaView","elemento: "+i);
            Log.i("ClimaView","fecha: "+losClimasDelWB.get(i).fecha);
            Log.i("ClimaView","minima: "+losClimasDelWB.get(i).minima);
            Log.i("ClimaView", "maxima: " + losClimasDelWB.get(i).maxima);

            minimasArrayList.add(losClimasDelWB.get(i).fecha);
            minimasArrayList.add(losClimasDelWB.get(i).minima);
            minimasArrayList.add(losClimasDelWB.get(i).maxima);
        }

       datosAdapter = new ArrayAdapter<String>(getActivity(), R.layout.datoslayout, R.id.textView_datos, minimasArrayList);
        listView.setAdapter(datosAdapter);


    }
//    public class Tarea extends AsyncTask<Void, Void, String> {
//
//
//        @Override
//        protected String doInBackground(Void... params) {
//
//            URL url = null;
//            try {
//                url = new URL("http://http://api.openweathermap.org/data/2.5/forecast?q=55540.mx&APPID=cf5a120f6eee20a98126442383c86613&units=metric");
//                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
//                conexion.setRequestMethod("GET");
//                conexion.connect();
//                BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
//
//                //se crea la entra del objeto JSON
//                StringBuffer buffer = new StringBuffer();
//                String linea;
//                while ((linea = entrada.readLine()) != null) {
//                    buffer.append(linea + "\n");
//                }
//                String variableJson = buffer.toString();
//                Log.i("datos", variableJson);
//                JSONObject jsonob = new JSONObject(variableJson);
//                return variableJson;
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (JSONException e) {
//                e.printStackTrace();
//
//            }
//            return null;
//        }
//    }
    public class ClimaAdapter extends ArrayAdapter<Clima> {

        int layoutResourceId;
        ArrayList<Clima> losClimas;

        public ClimaAdapter(Context context, int resource, ArrayList<Clima> losClimas) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return losClimas.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            Clima elclima = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(layoutResourceId, parent, false);
            }

            TextView tvfecha = (TextView) convertView.findViewById(R.id.tvfecha);
            TextView tvhora = (TextView) convertView.findViewById(R.id.tvhora);
            TextView tvminima = (TextView) convertView.findViewById(R.id.tvminima);
            TextView tvmaxima = (TextView) convertView.findViewById(R.id.tvmaxima);

            tvfecha.setText(elclima.fecha);
            tvminima.setText(elclima.minima);
            tvmaxima.setText(elclima.maxima);
            return row;

        }
    }


}
