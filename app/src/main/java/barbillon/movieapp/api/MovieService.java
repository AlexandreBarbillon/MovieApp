package barbillon.movieapp.api;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

import barbillon.movieapp.api.config.ApiConfig;
import barbillon.movieapp.movie.MovieResponse;
import barbillon.movieapp.movie.MovieViewModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("discover/movie")
    Call<MovieResponse> getTrendingMovies(@Query("api_key") String api);


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
