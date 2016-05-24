package app.com.example.alumno.elclima.View;

import android.app.Fragment;
import android.content.Intent;

import app.com.example.alumno.elclima.Controller.DetalleClimaActivity;
import app.com.example.alumno.elclima.Model.Clima;
import app.com.example.alumno.elclima.ViewModel.IDetalleClimaViewModel;

/**
 * Created by miziloner on 20/05/16.
 */
public class DetalleClimaView extends Fragment implements IDetalleClimaViewModel {

    IDetalleClimaViewModel viewModelListener;


    @Override
    public void setListener(DetalleClimaActivity detalleClimaActivity) {

    }

    @Override
    public void launchDetail() {

        Intent i = new Intent(getApplicationContext(), DetalleClimaView.class);
        startActivity(i);

    }

    public void setDetail(Clima detalleClima){


    }

}
