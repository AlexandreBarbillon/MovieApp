package barbillon.movieapp.api;

import barbillon.movieapp.api.model.MovieResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * MovieService permet de réaliser des requètes à l'API
 */
public interface MovieService {
    /**
     * Cette fonction renvoit une liste de film parmis ceux actuellement au cinéma
     * @param api_key la clé de l'api
     * @param language la langue des données reçues
     * @return une MovieResponse contenant les films actuellement au cinéma
     */
    @GET("movie/now_playing")
    Single<MovieResponse> getMovieOnTheater(@Query("api_key") String api_key, @Query("language") String language);

/*
    public String constructRequest(){
        String request = ApiConfig.BASE_URL+"discover/movie?";
        request += "api_key="+ApiConfig.API_KEY;
        request += "langague="+ApiConfig.LANGUAGE;
        request += "sort_by" + "popularity.desc";
        return request;
    }
*/
}
