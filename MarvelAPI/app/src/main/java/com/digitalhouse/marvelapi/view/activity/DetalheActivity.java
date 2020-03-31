package com.digitalhouse.marvelapi.view.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.digitalhouse.marvelapi.R;
import com.digitalhouse.marvelapi.model.Comics;
import com.digitalhouse.marvelapi.util.Util;
import com.squareup.picasso.Picasso;
import static com.digitalhouse.marvelapi.util.Util.COMICS;

public class DetalheActivity extends AppCompatActivity {
    private ImageView imageViewDetalhe;
    private ImageView imagemMiniPoster;
    private TextView  txtTitulo;
    private TextView  txtDescricao;
    private TextView  txtPreco;
    private TextView  txtDataPublicacao;
    private TextView  txtPaginas;
    private Comics    comics;
    private Button    botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        initViews();

        if (getIntent() != null){
            comics = getIntent().getParcelableExtra(COMICS);
            Picasso.get().load(comics.getThumbnail().getPath() + "." + comics.getThumbnail().getExtension()).into(imageViewDetalhe);
            Picasso.get().load(comics.getThumbnail().getPath()+"."+comics.getThumbnail().getExtension()).into(imagemMiniPoster);
            txtTitulo.setText(comics.getTitle());
            txtDescricao.setText(comics.getDescription());
            //txtDataPublicacao.setText(Util.ConvertToDate(comics.getDates().get(0).getDate()));
            txtPreco.setText(comics.getPrices().get(0).getPrice().toString());
            txtPaginas.setText(comics.getPageCount().toString());

            imagemMiniPoster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DetalheActivity.this, PosterActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("Comics", comics);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            botaoVoltar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    finish();
                }
            });
        }
    }

    private void initViews() {
         imageViewDetalhe = findViewById(R.id.imageComicsDetalhes);
         txtTitulo = findViewById(R.id.textTitulo);
         txtDescricao = findViewById(R.id.textDescricao);
         txtDataPublicacao = findViewById(R.id.textPublishesd);
         txtPreco = findViewById(R.id.textPreco);
         txtPaginas = findViewById(R.id.textPaginas);
         botaoVoltar = findViewById(R.id.botaoVoltar);
         imagemMiniPoster = findViewById(R.id.imagemMiniPoster);
    }
}