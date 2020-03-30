package com.digitalhouse.marvelapi.view.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.digitalhouse.marvelapi.R;
import com.digitalhouse.marvelapi.model.Comics;
import com.squareup.picasso.Picasso;
import static com.digitalhouse.marvelapi.util.Util.COMICS;

public class PosterActivity extends AppCompatActivity {
    private Button botaoFechar;
    private ImageView imageViewPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster);

        imageViewPoster = findViewById(R.id.imagemPoster);

        if (getIntent() != null){
            Comics comics = getIntent().getParcelableExtra(COMICS);
            Picasso.get().load(comics.getThumbnail().getPath() + "." + comics.getThumbnail().getExtension()).into(imageViewPoster);
        }

        botaoFechar = findViewById(R.id.botaFechar);
        botaoFechar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}