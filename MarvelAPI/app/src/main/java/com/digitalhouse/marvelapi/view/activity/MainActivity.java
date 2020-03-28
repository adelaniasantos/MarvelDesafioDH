package com.digitalhouse.marvelapi.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.digitalhouse.marvelapi.R;
import com.digitalhouse.marvelapi.model.Comics;
import com.digitalhouse.marvelapi.view.adapter.RecyclerViewMarvelAdapter;
import com.digitalhouse.marvelapi.view.interfaces.OnClick;
import com.digitalhouse.marvelapi.viewmodel.MarvelViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClick {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerViewMarvelAdapter adapter;
    private List<Comics> comicsList = new ArrayList<>();
    private MarvelViewModel viewModel;
    private Integer offset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);
        setScrollView();

        viewModel.getComics(offset);

        viewModel.getListaComics().observe(this, comicsList -> {
            adapter.atualizaLista(comicsList);
        });

        viewModel.getLoading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerViewComics);
        progressBar = findViewById(R.id.progress_bar);
        adapter = new RecyclerViewMarvelAdapter(comicsList, this);
        viewModel = ViewModelProviders.of(this).get(MarvelViewModel.class);
    }

    @Override
    public void click(Comics comics) {
        Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Comics", comics);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void setScrollView() {

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();

                int totalItemCount = layoutManager.getItemCount();

                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean ultimoItem = lastVisible + 5 >= totalItemCount;

                 if (totalItemCount > 0 && ultimoItem && offset <=68) {
                    offset+=20;
                    viewModel.getComics(offset);
                }
            }
        });
    }
}
