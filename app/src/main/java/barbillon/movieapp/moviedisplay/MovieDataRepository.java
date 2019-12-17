package barbillon.movieapp.moviedisplay;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observer;

import barbillon.movieapp.api.MovieService;
import barbillon.movieapp.api.model.MovieResponse;
import barbillon.movieapp.api.model.MovieViewModel;
import barbillon.movieapp.db.MovieDatabase;
import barbillon.movieapp.di.TempDependencyInjector;
import barbillon.movieapp.moviedisplay.local.MovieLocalDataSource;
import barbillon.movieapp.moviedisplay.remote.MovieRemoteDataSource;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static io.reactivex.Single.just;

public class MovieDataRepository implements MovieRepository {

    private final String DATE_CACHE = "date";
    private MovieLocalDataSource movieLocalDataSource;
    private MovieRemoteDataSource movieRemoteDataSource;
    private int weekNumber;
    private CompositeDisposable compositeDisposable;
    private SharedPreferences settings;

    //private MovieEntityMapper movieToMovieEntityMapper;

    public MovieDataRepository(MovieDatabase movieDatabase, SharedPreferences settings, int weekNumber){
        this.movieRemoteDataSource = new MovieRemoteDataSource(TempDependencyInjector.getBookDisplayService());
        this.movieLocalDataSource = new MovieLocalDataSource(movieDatabase);
        this.compositeDisposable = new CompositeDisposable();
        this.settings = settings;
        this.weekNumber = weekNumber;
    }

    @Override
    public Single<MovieResponse> getMovies() {
        compositeDisposable.clear();
        final Calendar now = Calendar.getInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Log.d("settings","weeknumber = "+weekNumber);
            Log.d("settings","actualWeekNumber = "+now.get(Calendar.WEEK_OF_YEAR));

            if(weekNumber == -1 || weekNumber != now.get(Calendar.WEEK_OF_YEAR)){
                Log.d("dao toggler","Get Online");
                Single<MovieResponse> response = this.movieRemoteDataSource.getMovies();
                compositeDisposable.add(response.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<MovieResponse>() {
                            @SuppressLint("CommitPrefEdits")
                            @Override
                            public void onSuccess(MovieResponse movieResponse) {
                                Log.d("Local","Save to local !");
                                Completable result = movieLocalDataSource.deleteMovies().andThen(movieLocalDataSource.addMovies(movieResponse));
                                settings.edit().putInt("week",now.get(Calendar.WEEK_OF_YEAR)).apply();
                            }

                            @Override
                            public void onError(Throwable e) {
                                System.out.println(e.toString());
                            }
                        }));
                return response;
            }
            else{
                Log.d("dao toggler","Get Local");
                return movieLocalDataSource.getLocalMovies();
            }
        }
        return null;
    }
}
