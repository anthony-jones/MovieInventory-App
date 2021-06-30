package movieInventory.data;

public class Movie {
    private final String tmdbID;
    private final String title;
    private final String releaseDate;
    private final String tagline;
    private final String posterPath;

    public Movie(String title, String releaseDate, String tmdbID, String tagline, String posterPath) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.tmdbID = tmdbID;
        this.tagline = tagline;
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTmdbID() {
        return tmdbID;
    }

    public String getTagline() {
        return tagline;
    }

    public String getPosterPath() {
        return posterPath;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
