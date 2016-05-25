package app.com.example.alumno.elclima.ViewModel;

import app.com.example.alumno.elclima.Controller.DetalleClimaActivity;
import app.com.example.alumno.elclima.Model.Clima;

/**
 * Created by miziloner on 20/05/16.
 */
public interface IDetalleClimaViewModel {

    void setListener(IDetalleClimaViewModelListener listener);
    void setDetail(Clima detalleClima);




}
