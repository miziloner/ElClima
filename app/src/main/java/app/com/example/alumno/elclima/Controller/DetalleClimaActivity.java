package app.com.example.alumno.elclima.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import app.com.example.alumno.elclima.R;
import app.com.example.alumno.elclima.ViewModel.IDetalleClimaViewModel;
import app.com.example.alumno.elclima.ViewModel.IDetalleClimaViewModelListener;


public class DetalleClimaActivity extends AppCompatActivity implements IDetalleClimaViewModelListener{

    private IDetalleClimaViewModel viewModel;

     TextView ubicacionTextView;
     TextView tempactualTextView;
     TextView humedadTextView;
     TextView presionTextView;
     TextView niveldelmarTextView;
    TextView descripcionTextview;


    String ubicacion;
    String descripcion;
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
        descripcion = getIntent().getStringExtra("description");
        tempactual = getIntent().getStringExtra("temp");
        presion = getIntent().getStringExtra("pressure");
        humedad = getIntent().getStringExtra("humidity");
        niveldelmar = getIntent().getStringExtra("sea_level");



        ubicacionTextView = (TextView) findViewById(R.id.tvubicacion);
        descripcionTextview = (TextView) findViewById(R.id.tvdescripcion);
        tempactualTextView = (TextView) findViewById(R.id.tvtempactual);
        humedadTextView = (TextView) findViewById(R.id.tvhumedad);
        presionTextView = (TextView) findViewById(R.id.tvpresion);
        niveldelmarTextView = (TextView)findViewById(R.id.tvniveldelmar);


        ubicacionTextView.setText(ubicacion);
        descripcionTextview.setText("Descripcion: "+descripcion);
        tempactualTextView.setText("Temperatura Actual: "+tempactual);
        humedadTextView.setText("Humedad: " + humedad);
        presionTextView.setText("Presion: " + presion);
        niveldelmarTextView.setText("Nivel del mar: "+ niveldelmar);


    }

    @Override
    public void doSomething() {

    }
}
