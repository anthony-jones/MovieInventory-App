package movieInventory.data;

import java.util.ArrayList;

public class MovieLibrary {

    private final ArrayList<Movie> movieList;

    public MovieLibrary() {
        this.movieList = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        if (this.containsID(movie.getTmdbID()) == -1) {
            this.movieList.add(movie);
        }
    }

    public void removeMovie(String tmdbID) {
        if (this.containsID(tmdbID) >= 0) {
            this.movieList.remove(this.containsID(tmdbID));
        }
    }

    private int containsID(String tmdbID) {
        for (int i = 0; i < this.movieList.size(); i++) {
            if (this.movieList.get(i).getTmdbID().equals(tmdbID)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
}
