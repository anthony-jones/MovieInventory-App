//package movieInventory.imdbAPI;
//
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import movieInventory.data.Movie;
//import org.json.JSONObject;
//
//public class imdbAPI {
//
//    public Movie retrieveMovieData(String movieID) throws UnirestException {
//        String host = "https://movies-tvshows-data-imdb.p.rapidapi.com/?type=get-movie-details&imdb=";
//        HttpResponse<JsonNode> response = Unirest.get(host + movieID)
//                .header("x-rapidapi-key", "API KEY")
//                .header("x-rapidapi-host", "movies-tvshows-data-imdb.p.rapidapi.com")
//                .asJson();
//        JSONObject object = response.getBody().getObject();
//        String status = object.getString("status");
//        if (status.equals("OK") && object.has("title")) {
//            String title = object.getString("title");
//            String releaseDate = object.getString("release_date");
//            String rated = object.getString("rated");
//            return new Movie(title, releaseDate, movieID, rated);
//        }
//        return null;
//    }
//
//    public String retrieveCoverArt(String movieID) throws UnirestException {
//        String host = "https://movies-tvshows-data-imdb.p.rapidapi.com/?type=get-movies-images-by-imdb&imdb=";
//        HttpResponse<JsonNode> response = Unirest.get(host + movieID)
//                .header("x-rapidapi-key", "API KEY")
//                .header("x-rapidapi-host", "movies-tvshows-data-imdb.p.rapidapi.com")
//                .asJson();
//        JSONObject object = response.getBody().getObject();
//        String coverURL = object.getString("poster");
//        return coverURL;
//    }
//}
