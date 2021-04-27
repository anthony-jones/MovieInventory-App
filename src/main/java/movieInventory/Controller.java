package movieInventory;

import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public Label ratingValueLabel;
    public ImageView coverArtViewer;

    public Controller() {
        this.movieLibrary = new MovieLibrary();
        this.imdbApi = new imdbAPI();
    }

    public void addButtonPressed() throws UnirestException {
        if (!this.addTextField.getText().isEmpty()) {
            String id = this.addTextField.getText();
            Movie movie = this.imdbApi.retrieveMovieData(id);
            if (movie != null) {
                this.movieLibrary.addMovie(movie);
                this.updateList();
                this.updateCurrentData(movie);
            }
        }
    }

    public void removeButtonPressed() {
        if (!this.idValueLabel.getText().isEmpty()) {
            this.movieLibrary.removeMovie(this.idValueLabel.getText());
            this.updateList();
            this.resetCurrentData();
        }
    }

    public void movieSelected() throws UnirestException {
        Movie movie = this.movieListView.getSelectionModel().getSelectedItem();
        if (movie != null) {
            this.updateCurrentData(movie);
        }
    }

    private void updateList() {
        ObservableList<Movie> list = FXCollections.observableArrayList(this.movieLibrary.getMovieList());
        this.movieListView.setItems(list);
    }

    private void updateCurrentData(Movie movie) throws UnirestException {
        this.titleValueLabel.setText(movie.getTitle());
        this.releaseValueLabel.setText(movie.getReleaseDate());
        this.idValueLabel.setText(movie.getImdbID());
        this.ratingValueLabel.setText(movie.getRated());
        this.updateDisplayedImage(movie);
    }

    private void updateDisplayedImage(Movie movie) throws UnirestException {
        Image image = new Image(this.imdbApi.retrieveCoverArt(movie.getImdbID()));
        this.coverArtViewer.setImage(image);
    }

    private void resetCurrentData() {
        this.titleValueLabel.setText("");
        this.releaseValueLabel.setText("");
        this.idValueLabel.setText("");
        this.ratingValueLabel.setText("");
        this.coverArtViewer.setImage(null);
    }
}

