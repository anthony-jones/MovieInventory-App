package movieInventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import movieInventory.data.Movie;
import movieInventory.data.MovieLibrary;
import movieInventory.tmdbAPI.tmdbAPI;

public class Controller {
    private final MovieLibrary movieLibrary;
    private final tmdbAPI tmdbAPI;
    public TextField addTextField;
    public ListView<Movie> movieListView;
    public Label titleValueLabel;
    public Label releaseValueLabel;
    public Label idValueLabel;
    public Label taglineValueLabel;
    public ImageView coverArtViewer;

    public Controller() {
        this.tmdbAPI = new tmdbAPI();
        this.movieLibrary = new MovieLibrary();
    }

    public void addButtonPressed() {
        if (!this.addTextField.getText().isEmpty()) {
            String id = this.addTextField.getText();
            Movie movie = this.tmdbAPI.retrieveMovieData(id);
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

    public void movieSelected() {
        Movie movie = this.movieListView.getSelectionModel().getSelectedItem();
        if (movie != null) {
            this.updateCurrentData(movie);
        }
    }

    private void updateList() {
        ObservableList<Movie> list = FXCollections.observableArrayList(this.movieLibrary.getMovieList());
        this.movieListView.setItems(list);
    }

    private void updateCurrentData(Movie movie) {
        this.titleValueLabel.setText(movie.getTitle());
        this.releaseValueLabel.setText(movie.getReleaseDate());
        this.idValueLabel.setText(movie.getTmdbID());
        this.taglineValueLabel.setText(movie.getTagline());
        this.updateDisplayedImage(movie);
    }

    private void updateDisplayedImage(Movie movie) {
        Image image = new Image(movie.getPosterPath());
        this.coverArtViewer.setImage(image);
    }

    private void resetCurrentData() {
        this.titleValueLabel.setText("");
        this.releaseValueLabel.setText("");
        this.idValueLabel.setText("");
        this.taglineValueLabel.setText("");
        this.coverArtViewer.setImage(null);
    }
}

