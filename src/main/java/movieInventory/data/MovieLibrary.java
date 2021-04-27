package movieInventory.data;

import java.util.ArrayList;

public class MovieLibrary {

    private final ArrayList<Movie> movieList;

    public MovieLibrary() {
        this.movieList = new ArrayList<>();
    }

    public void addMovie(Movie movie){
        if(this.movieList.contains(movie)){
            return;
        }
        this.movieList.add(movie);
    }

    public void removeMovie(String imdbID){
        if(this.containsID(imdbID) >= 0){
            this.movieList.remove(this.containsID(imdbID));
        }
    }

    private int containsID(String imdbID){
        for(int i = 0; i < this.movieList.size(); i++){
            if(this.movieList.get(i).getImdbID().equals(imdbID)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
}
