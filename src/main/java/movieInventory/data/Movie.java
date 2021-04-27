package movieInventory.data;

public class Movie {
    private final String title;
    private final String releaseDate;
    private final String imdbID;
    private final String rated;

    public Movie(String title, String releaseDate, String imdbID, String rated) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.imdbID = imdbID;
        this.rated = rated;
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

    public String getRated() {
        return rated;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
