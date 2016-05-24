package app.com.example.alumno.elclima.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import app.com.example.alumno.elclima.R;
import app.com.example.alumno.elclima.ViewModel.IClimaViewModel;
import app.com.example.alumno.elclima.ViewModel.IDetalleClimaViewModel;
import app.com.example.alumno.elclima.ViewModel.IDetalleClimaViewModelListener;


public class DetalleClimaActivity extends AppCompatActivity implements IDetalleClimaViewModelListener{

    private IDetalleClimaViewModel viewModelListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_layout);
        viewModelListener = (IDetalleClimaViewModel) getSupportFragmentManager().findFragmentById(R.id.detalle_fragment);
        viewModelListener.setListener(this);

    }

}
