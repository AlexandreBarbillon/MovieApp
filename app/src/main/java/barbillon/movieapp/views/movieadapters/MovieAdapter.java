package barbillon.movieapp.views.movieadapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import barbillon.movieapp.views.DetailView;
import barbillon.movieapp.api.model.MovieViewModel;

public abstract class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    Activity mainActivity;
    List<MovieViewModel> movies;
    RecyclerView recyclerView;
    public MovieAdapter(Activity mainActivity, List<MovieViewModel> movies, RecyclerView recyclerView){
        this.mainActivity = mainActivity;
        this.movies = movies;
        this.recyclerView = recyclerView;
    }

    public void generateOnClickOnView(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = recyclerView.getChildLayoutPosition(view);
                MovieViewModel movie = movies.get(position);
                Intent intent = new Intent(recyclerView.getContext(), DetailView.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",movie.getTitle());
                bundle.putString("poster",movie.getPoster_path());
                bundle.putString("year",movie.getRelease_date());
                bundle.putString("description",movie.getOverview());
                intent.putExtras(bundle);
                recyclerView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return this.movies.size();
    }
}
