package app.com.example.alumno.elclima.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import app.com.example.alumno.elclima.Model.Clima;
import app.com.example.alumno.elclima.Model.Constants;
import app.com.example.alumno.elclima.R;
import app.com.example.alumno.elclima.View.DetalleClimaView;
import app.com.example.alumno.elclima.ViewModel.IClimaViewModel;
import app.com.example.alumno.elclima.ViewModel.IClimaViewModelListener;

public class ClimaActivity extends AppCompatActivity implements IClimaViewModelListener {

    private IClimaViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clima_layout);
        viewModel = (IClimaViewModel) getSupportFragmentManager().findFragmentById(R.id.clima_fragment);
        viewModel.setListener(this);

    }

    @Override
    public void launchDetail(Clima clima) {

        Intent i = new Intent(getApplicationContext(), DetalleClimaActivity.class);
        i.putExtra("description",clima.descripcion);
        i.putExtra("name",clima.ubicacion);
        i.putExtra("temp",clima.tempactual);
        i.putExtra("pressure",clima.presion);
        i.putExtra("sea_level",clima.niveldelmar);
        i.putExtra("humidity",clima.Humedad);
        startActivity(i);

    }


    @Override
    public void getWeatherFromService() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Constants.URL_SERVICE;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ArrayList<Clima> losClimas= new ArrayList<Clima>();
                        // Display the first 500 characters of the response string.
                        Log.i("COMO NOOO PAPAPAAAAA", "LLegue a weather from service" + response);
                        try {
                            JSONObject jsonob = new JSONObject(response);
                            JSONObject cityobject =jsonob.getJSONObject("city");
                            JSONArray listArray = jsonob.getJSONArray("list");
                            JSONObject citycoord = cityobject.getJSONObject("coord");

                            String name = cityobject.getString("name");
                            double lat = citycoord.getDouble("lat");
                            double lon = citycoord.getDouble("lon");

                            for(int i = 0 ; i < listArray.length() ; i++){

                                JSONObject itemJSON = listArray.getJSONObject(i);
                                String fecha =  itemJSON.getString("dt_txt");
                                JSONObject mainJSON = itemJSON.getJSONObject("main");
                                double temp = mainJSON.getDouble("temp");
                                double tempMin = mainJSON.getDouble("temp_min");
                                double tempMax = mainJSON.getDouble("temp_max");
                                double presion = mainJSON.getDouble("pressure");
                                double nivelmar = mainJSON.getDouble("sea_level");
                                double humedad = mainJSON.getDouble("humidity");

                                JSONArray weatherJSONArray = itemJSON.getJSONArray("weather");
                                JSONObject weatherJSON = (JSONObject) weatherJSONArray.get(0);
                                String description=weatherJSON.getString("description");
                                String icon =  weatherJSON.getString("icon");



                                Clima nuevoClima = new Clima();
                                nuevoClima.descripcion=description;
                                nuevoClima.ubicacion = name;
                                nuevoClima.tempactual= ""+temp;
                                nuevoClima.presion = ""+presion;
                                nuevoClima.niveldelmar=""+nivelmar;
                                nuevoClima.Humedad=""+humedad;
                                nuevoClima.fecha = fecha;
                                nuevoClima.maxima = ""+tempMax;
                                nuevoClima.minima = ""+tempMin;
                                nuevoClima.icono = ""+icon+".png";


                                losClimas.add(nuevoClima);
                            }
                            viewModel.pintaClimasEnListView(losClimas);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("onErrorResponse", "EL ERROR ES :" + error);
            }
        });
        queue.add(stringRequest);
    }



}


