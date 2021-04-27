package movieInventory;

import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import movieInventory.data.Movie;
import movieInventory.data.MovieLibrary;
import movieInventory.imdbAPI.imdbAPI;

public class Controller {
    private final MovieLibrary movieLibrary;
    private final imdbAPI imdbApi;
    public TextField addTextField;
    public ListView<Movie> movieListView;
    public Label titleValueLabel;
    public Label releaseValueLabel;
    public Label idValueLabel;

    public Controller() {
        this.movieLibrary = new MovieLibrary();
        this.imdbApi = new imdbAPI();
    }

    public void addButtonPressed() throws UnirestException {
        if(!this.addTextField.getText().isEmpty()){
            String id = this.addTextField.getText();
            this.movieLibrary.addMovie(this.imdbApi.retrieveMovieData(id));
            this.updateList();
        }
    }

    public void removeButtonPressed(){
        if(!this.idValueLabel.getText().isEmpty()){
            this.movieLibrary.removeMovie(this.idValueLabel.getText());
            this.updateList();
        }
    }

    public void movieSelected(){
        Movie movie = this.movieListView.getSelectionModel().getSelectedItem();
        if(movie != null){
            this.updateCurrentData(movie);
        }
    }

    private void updateList(){
        ObservableList<Movie> list = FXCollections.observableArrayList(this.movieLibrary.getMovieList());
        this.movieListView.setItems(list);
    }

    private void updateCurrentData(Movie movie){
        this.titleValueLabel.setText(movie.getTitle());
        this.releaseValueLabel.setText(movie.getReleaseDate());
        this.idValueLabel.setText(movie.getImdbID());
    }
}

