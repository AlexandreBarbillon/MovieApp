package barbillon.movieapp.di;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import barbillon.movieapp.api.MovieService;
import barbillon.movieapp.api.config.ApiConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Récupéré depuis le TP Book, cet objet permet de récupérer plusieurs outils utiles pour le projet.
 */
public class TempDependencyInjector {

    private static MovieService movieService;
    private static Retrofit retrofit;
    private static Gson gson;
    private static Context applicationContext;

    /**
     * @return un objet MovieService
     */
    public static MovieService getMovieDisplayService() {
        if (movieService == null) {
            movieService = getRetrofit().create(MovieService.class);
        }
        return movieService;
    }

    /**
     * @return Retrofit configuré sur l'API moviedb
     */
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConfig.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
        }
        return retrofit;
    }

}
