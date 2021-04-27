package movieInventory.data;

public class Movie {
    private final String title;
    private final String releaseDate;
    private final String imdbID;

    public Movie(String title, String releaseDate, String imdbID) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getImdbID() {
        return imdbID;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
