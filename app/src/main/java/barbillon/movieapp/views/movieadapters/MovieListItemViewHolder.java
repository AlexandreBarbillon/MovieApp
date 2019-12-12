package barbillon.movieapp.views.movieadapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import barbillon.movieapp.R;
import barbillon.movieapp.api.model.MovieViewModel;

class MovieListItemViewHolder extends barbillon.movieapp.views.movieadapters.MovieViewHolder {


    public MovieListItemViewHolder(@NonNull View itemView, Activity mainActivity) {
        super(itemView, mainActivity);
    }

    public void fillView(MovieViewModel mvm){
        ImageView image = this.itemView.findViewById(R.id.imageView);
        TextView title = itemView.findViewById(R.id.title);
        TextView year =  itemView.findViewById(R.id.year);
        TextView description =  itemView.findViewById(R.id.description);
        Log.d("poster",mvm.getPoster_path());
        Glide.with(this.mainActivity.getApplicationContext()).load(mvm.getPoster_path()).into(image);
        title.setText(mvm.getTitle());
        year.setText(mvm.getRelease_date());
        description.setText(mvm.getOverview());
    }
}
