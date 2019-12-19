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

/**
 * MoviePresenter permet de déclencher l'affichage des données une fois celles-ci récupérees. Une vue doit s'y être attaché.
 */
public class MoviePresenter implements MovieContract {

    private MovieRepository movieRepository;
    private CompositeDisposable compositeDisposable;
    private ViewContract viewContract;
    public MoviePresenter(MovieRepository bookDisplayRepository) {
        this.movieRepository = bookDisplayRepository;
        this.compositeDisposable = new CompositeDisposable();
    }

    /**
     * Cette fonction permet d'aller récupérer les données via un MovieRepository. Une fois les données récupérées, la fonction displayMovies d'une vue répondant à l'interface ViewContract sera appelée pour afficher le résultat
     */
    @Override
    public void displayMovies() {
        compositeDisposable.clear();
        compositeDisposable.add(movieRepository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<MovieResponse>() {
                    @Override
                    public void onSuccess(MovieResponse movieResponse) {
                        if(movieResponse!=null){
                            viewContract.displayMovies(movieResponse.getResults());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }
                }));
    }

    /**
     * Attache une vue afin qu'elle soit appelée lors de l'appel à displayMovies()
     * @param view
     */
    public void attachView(ViewContract view) {
        this.viewContract = view;
    }
}
