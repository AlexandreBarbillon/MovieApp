package barbillon.movieapp.api;

import barbillon.movieapp.api.model.MovieResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("discover/movie")
    Single<MovieResponse> getTrendingMovies(@Query("api_key") String api_key);

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
