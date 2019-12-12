package barbillon.movieapp.views.movieadapters;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import barbillon.movieapp.R;
import barbillon.movieapp.api.model.MovieViewModel;

public class MovieGridItemViewHolder extends MovieViewHolder {


    public MovieGridItemViewHolder(@NonNull View itemView, Activity mainActivity) {
        super(itemView, mainActivity);
    }

    @Override
    public void fillView(MovieViewModel movie) {
        ImageView image = this.itemView.findViewById(R.id.grid_poster);
        Glide.with(this.mainActivity.getApplicationContext()).load(movie.getPoster_path()).into(image);
    }
}
