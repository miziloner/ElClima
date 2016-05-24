package app.com.example.alumno.elclima.View;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import app.com.example.alumno.elclima.Controller.DetalleClimaActivity;
import app.com.example.alumno.elclima.Model.Clima;
import app.com.example.alumno.elclima.R;
import app.com.example.alumno.elclima.ViewModel.IDetalleClimaViewModel;
import app.com.example.alumno.elclima.ViewModel.IDetalleClimaViewModelListener;

/**
 * Created by miziloner on 20/05/16.
 */
public class DetalleClimaView extends Fragment implements IDetalleClimaViewModel {

    IDetalleClimaViewModelListener mListener;


    private View rootView;
    private TextView tvubicacion;
    private TextView tvempactual;
    private TextView tvhumedad;
    private TextView tvpresion;
    private TextView tvniveldelmar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.detalle_fragment, container, false);
        TextView tvubicacion = (TextView) rootView.findViewById(R.id.tvubicacion);
        TextView tvempactual = (TextView) rootView.findViewById(R.id.tvtempactual);
        TextView tvhumedad = (TextView)rootView.findViewById(R.id.tvhumedad);
        TextView tvpresion = (TextView)rootView.findViewById(R.id.tvpresion);
        TextView tvniveldelmar = (TextView)rootView.findViewById(R.id.tvniveldelmar);
        return rootView;

    }

    @Override
    public void setListener(IDetalleClimaViewModelListener listener) {

        mListener = listener;

    }

    public void setDetail(Clima detalleClima){

        tvubicacion.setText("ubicacion:");
        tvempactual.setText("Temperatura Actual:");
        tvhumedad.setText("Humedad:");
        tvpresion.setText("Presion:");
        tvniveldelmar.setText("Nivel del mar:");




    }

}
