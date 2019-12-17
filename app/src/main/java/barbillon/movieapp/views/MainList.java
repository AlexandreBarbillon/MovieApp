package barbillon.movieapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;


import java.util.List;

import barbillon.movieapp.R;
import barbillon.movieapp.api.model.MovieViewModel;
import barbillon.movieapp.moviedisplay.MovieDataRepository;
import barbillon.movieapp.moviedisplay.MoviePresenter;
import barbillon.movieapp.moviedisplay.ViewContract;
import barbillon.movieapp.views.movieadapters.MovieGridItemAdapter;
import barbillon.movieapp.views.movieadapters.MovieListItemAdapter;

/**
 * Affichage principal de l'application. Il contient une RecyclerView qui se met à jour suivant l'affichage souhaité, soit par grille, soit par list (contenant alors le titre et la date de sortie du film)
 */
public class MainList extends AppCompatActivity implements ViewContract {

    private RecyclerView movieList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter movieListAdapter;
    private MoviePresenter moviePresenter;
    private boolean isListView = true; /** défini si l'affichage est une list ou une grille*/
    private List<MovieViewModel> movieViewModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.LTGRAY);

        movieList = findViewById(R.id.mainList);
        movieList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        moviePresenter = new MoviePresenter(new MovieDataRepository());
        moviePresenter.attachView(this);
        moviePresenter.displayMovies();
        setButton();
        //movieListAdapter = new MovieListAdapter();
    }

    /**
     * Cette fonction correspond au contrat qu'implémente cette vue, c'est cette fonction qui est appellée lorsque l'appel à l'API est terminé dans le MoviePresenter.
     * @param movieViewModelList
     */
    @Override
    public void displayMovies(List<MovieViewModel> movieViewModelList) {
        this.movieViewModelList = movieViewModelList;
        displayMovies();
    }

    /**
     * Cette fonction actualise la RecyclerView avec les données présentent dans l'attribut movieViewModelList. Elle affichera alors une grille ou une liste suivant l'état de l'attribut isListView
     */
    public void displayMovies(){
        if(movieViewModelList != null){
            if(isListView){
                movieList.setLayoutManager(this.layoutManager);
                movieList.setAdapter(new MovieListItemAdapter(this,this.movieViewModelList,movieList));
            }
            else{
                movieList.setLayoutManager((new GridLayoutManager(this, 2)));
                movieList.setAdapter(new MovieGridItemAdapter(this, this.movieViewModelList,movieList));
            }
        }
    }

    /**
     * Initialise le bouton de la page principal qui inverse les vues
     */
    public void setButton(){
        ImageButton switch_button = findViewById(R.id.change_display);
        switch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_view();
            }
        });
    }

    /**
     * Inverse l'attribut isListView
     */
    public void switch_view(){
        isListView = !isListView;
        displayMovies();
    }
}
