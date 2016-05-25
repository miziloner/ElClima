package app.com.example.alumno.elclima.ViewModel;

import app.com.example.alumno.elclima.Model.Clima;

/**
 * Created by miziloner on 30/03/16.
 */
public interface IClimaViewModelListener {

    public void getWeatherFromService();

    void launchDetail(Clima clima);

}
