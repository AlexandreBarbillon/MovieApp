package barbillon.movieapp.views.movieadapters;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import barbillon.movieapp.api.model.MovieViewModel;

public abstract class MovieViewHolder extends RecyclerView.ViewHolder {

    protected Activity mainActivity;
    protected View itemView;
    public MovieViewHolder(@NonNull View itemView, Activity mainActivity) {
        super(itemView);
        this.itemView = itemView;
        this.mainActivity = mainActivity;
    }

    public abstract void fillView(MovieViewModel movie);
}
