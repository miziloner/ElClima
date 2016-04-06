package app.com.example.alumno.elclima.Controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import app.com.example.alumno.elclima.Model.Clima;
import app.com.example.alumno.elclima.Model.Constants;
import app.com.example.alumno.elclima.View.ClimaView;
import app.com.example.alumno.elclima.R;
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
    public void getWeatherFromService() {

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Constants.URL_SERVICE;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new ç.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i("COMO NJIOOO PAPAPAAAAAa", "LLegue a weather from service" + response);
                        try {
                            JSONObject jsonob = new JSONObject(response);

                            ArrayList < String > list =  new ArrayList< String >();
                            for  ( int i = 0 ; i < jsonob . length (); i ++)  {
                                queue.add();
                            }



                            //investigar como parsear este json a un ArrayList<Clima>



                            Clima nuevoClima = new Clima();
//                            nuevoClima.Ciudad= //lo que traiga de tal hijo de tal campo del json
















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
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}


