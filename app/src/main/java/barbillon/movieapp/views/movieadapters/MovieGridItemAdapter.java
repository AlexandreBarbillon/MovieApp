package barbillon.movieapp.views.movieadapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import barbillon.movieapp.DetailView;
import barbillon.movieapp.R;
import barbillon.movieapp.api.model.MovieViewModel;

public class MovieGridItemAdapter extends MovieAdapter {

    public MovieGridItemAdapter(Activity mainActivity, List<MovieViewModel> movies, RecyclerView recyclerView) {
        super(mainActivity, movies, recyclerView);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity.getApplicationContext()).inflate(R.layout.fragment_movie_grid_item,parent,false);
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
        MovieViewHolder mvh = new MovieGridItemViewHolder(view,this.mainActivity);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.fillView(movies.get(position));
    }


}
