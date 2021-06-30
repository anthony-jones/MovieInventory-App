package movieInventory.tmdbAPI;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import movieInventory.data.Movie;

public class tmdbAPI {
    private final TmdbMovies movies = new TmdbApi("5c72e7d099864152b4262ef4ad8b8698").getMovies();

    public tmdbAPI() {
    }

    public Movie retrieveMovieData(String id){
        try{
            MovieDb movie = movies.getMovie(Integer.parseInt(id), "en");
            String title = movie.getTitle();
            String releaseDate = movie.getReleaseDate();
            String tagline = movie.getTagline();
            String posterPath = "https://www.themoviedb.org/t/p/original/" + movie.getPosterPath();
            return new Movie(title, releaseDate, id, tagline, posterPath);
        }
        catch (Exception e){
            System.out.println("TMDB ID DOES NOT EXIST");
            return null;
        }
    }
}
