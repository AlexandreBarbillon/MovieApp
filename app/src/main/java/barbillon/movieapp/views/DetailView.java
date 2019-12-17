package barbillon.movieapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import barbillon.movieapp.R;
import barbillon.movieapp.api.model.MovieViewModel;
import barbillon.movieapp.views.movieadapters.MovieViewHolder;

/**
 * La vue détaillée des films, elle intégre l'affiche du film (donc pas besoin d'afficher le titre, il est généralement sur l'affiche), la date de sortie et la description
 */
public class DetailView extends AppCompatActivity {

    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        bundle = getIntent().getExtras();
        fillView();
    }

    /**
     * Remplie la vue avec les données récoltées dans le bundle
     */
    private void fillView(){
        ImageView poster = findViewById(R.id.detail_poster);
        //TextView title = findViewById(R.id.detailTitle);
        TextView year = findViewById(R.id.detailYear);
        TextView description = findViewById(R.id.detailDescription);
        Glide.with(this.getApplicationContext()).load(bundle.getString("poster")).into(poster);
        //title.setText(bundle.getString("title"));
        year.setText(bundle.getString("year"));
        description.setText(bundle.getString("description"));
    }
}
