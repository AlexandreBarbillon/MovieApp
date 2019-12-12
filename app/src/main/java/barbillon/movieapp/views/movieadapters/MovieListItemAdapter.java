package barbillon.movieapp.views.movieadapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import barbillon.movieapp.R;
import barbillon.movieapp.api.model.MovieViewModel;

public class MovieListItemAdapter extends MovieAdapter {
    Activity mainActivity;
    List<MovieViewModel> movies;
    public MovieListItemAdapter(Activity mainActivity, List<MovieViewModel> movies){
        super(mainActivity,movies);
        this.movies = movies;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mlf = LayoutInflater.from(mainActivity.getApplicationContext()).inflate(R.layout.fragment_movie_list_item,parent,false);
        MovieViewHolder mvh = new MovieListItemViewHolder(mlf,this.mainActivity);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.fillView(movies.get(position));
    }
}
