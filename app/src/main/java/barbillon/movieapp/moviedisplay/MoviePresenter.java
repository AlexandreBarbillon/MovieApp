package barbillon.movieapp.moviedisplay;

import java.util.List;

import barbillon.movieapp.api.model.MovieResponse;
import barbillon.movieapp.api.model.MovieViewModel;
import barbillon.movieapp.views.MainList;
import io.reactivex.Scheduler;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MoviePresenter implements MovieContract {

    private MovieRepository movieRepository;
    private CompositeDisposable compositeDisposable;
    private ViewContract viewContract;
    public MoviePresenter(MovieRepository bookDisplayRepository) {
        this.movieRepository = bookDisplayRepository;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void displayMovies() {
        compositeDisposable.clear();
        compositeDisposable.add(movieRepository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<MovieResponse>() {
                    @Override
                    public void onSuccess(MovieResponse movieResponse) {
                        viewContract.displayMovies(movieResponse.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }
                }));
    }

    public void attachView(ViewContract view) {
        this.viewContract = view;
    }
}
