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

public class MainList extends AppCompatActivity implements ViewContract {

    private RecyclerView movieList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter movieListAdapter;
    private MoviePresenter moviePresenter;
    private String type = "LIST";
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

    @Override
    public void displayMovies(List<MovieViewModel> movieViewModelList) {
        this.movieViewModelList = movieViewModelList;
        displayMovies();
    }

    public void displayMovies(){
        if(type.equals("LIST")){
            movieList.setLayoutManager(this.layoutManager);
            movieList.setAdapter(new MovieListItemAdapter(this,this.movieViewModelList));
        }
        else{
            movieList.setLayoutManager((new GridLayoutManager(this, 2)));
            movieList.setAdapter(new MovieGridItemAdapter(this, this.movieViewModelList));
        }
    }

    public void setButton(){
        ImageButton switch_button = findViewById(R.id.change_display);
        switch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_view();
            }
        });
    }

    public void switch_view(){
        if(type.equals("GRID")) type = "LIST";
        else type = "GRID";
        displayMovies();
    }
}
