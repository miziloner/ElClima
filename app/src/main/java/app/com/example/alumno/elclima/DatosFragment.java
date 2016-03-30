package app.com.example.alumno.elclima;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
import java.util.zip.Inflater;

/**
 * Created by Alumno on 01/03/2016.
 */
public class DatosFragment extends Fragment {

    private ArrayAdapter<String> datosAdapter;

    public DatosFragment(){
    }

    public void onCreated(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        String[] datosprueba = {
                "Hoy - Lluvioso 29/10",
                "Mañana - Nublado 20/10",
                "Miercoles - Soleado 28/14",
                "Jueves- Soleado 29/10",
                "Viernes - Nublado 12/6"
        };


        List<String> semana = new ArrayList<String>(Arrays.asList(datosprueba));
        datosAdapter = new ArrayAdapter<String>(getActivity(),R.layout.datoslayout, R.id.textView_datos, semana);
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listView_datos);
        listView.setAdapter(datosAdapter);
        return rootView;
    }

    public class Tarea extends AsyncTask < Void, Void, String  >{


        @Override
        protected String doInBackground(Void... params) {

            URL url = null;
            try {
                url = new URL("http://http://api.openweathermap.org/data/2.5/forecast?q=55540.mx&APPID=cf5a120f6eee20a98126442383c86613&units=metric");
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                conexion.setRequestMethod("GET");
                conexion.connect();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

                //se crea la entra del objeto JSON
                StringBuffer buffer = new StringBuffer();
                String linea;
                while ((linea = entrada.readLine()) != null) {
                    buffer.append(linea + "\n");
                }
                String variableJson = buffer.toString();
                Log.i("datos", variableJson);
                JSONObject jsonob = new JSONObject(variableJson);
                return variableJson;
            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();

            }
            return null;
        }
    }



}
