package app.com.example.alumno.elclima.ViewModel;

import java.util.ArrayList;

import app.com.example.alumno.elclima.Model.Clima;

/**
 * Created by miziloner on 30/03/16.
 */
public interface IClimaViewModel {

    void setListener(IClimaViewModelListener listener);

    void paintClimasOnListView(ArrayList<Clima> losClimasDelWB);


}
