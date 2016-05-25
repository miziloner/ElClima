package app.com.example.alumno.elclima.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import app.com.example.alumno.elclima.R;
import app.com.example.alumno.elclima.ViewModel.IClimaViewModel;
import app.com.example.alumno.elclima.ViewModel.IDetalleClimaViewModel;
import app.com.example.alumno.elclima.ViewModel.IDetalleClimaViewModelListener;


public class DetalleClimaActivity extends AppCompatActivity implements IDetalleClimaViewModelListener{

    private IDetalleClimaViewModel viewModel;

     TextView tvubicacion;
     TextView tvempactual;
     TextView tvhumedad;
     TextView tvpresion;
     TextView tvniveldelmar;


    String ubicacion;
    String humedad;
    String presion;
    String niveldelmar;
    String tempactual;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_fragment);
        //viewModel = (IDetalleClimaViewModel) getSupportFragmentManager().findFragmentById(R.id.fragment_detalle);
        //viewModel.setListener(this);


        ubicacion = getIntent().getStringExtra("name");
        tempactual = getIntent().getStringExtra("temp");
        presion = getIntent().getStringExtra("pressure");
        humedad = getIntent().getStringExtra("humidity");
        niveldelmar = getIntent().getStringExtra("sea_level");



        tvubicacion = (TextView) findViewById(R.id.tvubicacion);
        tvempactual = (TextView) findViewById(R.id.tvtempactual);
        tvhumedad = (TextView) findViewById(R.id.tvhumedad);
        tvpresion = (TextView) findViewById(R.id.tvpresion);
        tvniveldelmar = (TextView)findViewById(R.id.tvniveldelmar);


        tvubicacion.setText(ubicacion);
        tvempactual.setText(tempactual);
        tvhumedad.setText(humedad);
        tvpresion.setText(presion);
        tvniveldelmar.setText(niveldelmar);


    }

    @Override
    public void doSomething() {

    }
}
