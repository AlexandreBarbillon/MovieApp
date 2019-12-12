package barbillon.movieapp.views.movieadapters;

import android.app.Activity;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import barbillon.movieapp.api.model.MovieViewModel;

public abstract class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    Activity mainActivity;
    List<MovieViewModel> movies;

    public MovieAdapter(Activity mainActivity, List<MovieViewModel> movies){
        this.mainActivity = mainActivity;
        this.movies = movies;
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }
}
