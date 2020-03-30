package com.digitalhouse.marvelapi.view.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalhouse.marvelapi.R;
import com.digitalhouse.marvelapi.model.Comics;
import com.digitalhouse.marvelapi.view.interfaces.OnClick;
import com.squareup.picasso.Picasso;
import java.util.List;

public class RecyclerViewMarvelAdapter extends RecyclerView.Adapter<RecyclerViewMarvelAdapter.ViewHolder> {
    private List<Comics> comicsList;
    private OnClick listener;

    public RecyclerViewMarvelAdapter(List<Comics> comicsList, OnClick listener) {
        this.comicsList = comicsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comics comics = comicsList.get(position);
        holder.onBind(comics);
        holder.itemView.setOnClickListener(v -> listener.click(comics));
    }

    @Override
    public int getItemCount() {
        return comicsList.size();
    }

    public void atualizaLista(List<Comics> novaLista) {
        if (this.comicsList.isEmpty()) {
            this.comicsList = novaLista;
        } else {
            this.comicsList.addAll(novaLista);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgComic);
            textView = itemView.findViewById(R.id.txtIssueNumber);
        }

        public void onBind(Comics comics) {
            textView.setText("#"+comics.getIssueNumber().toString());
            Picasso.get().load(comics.getThumbnail().getPath() + "." + comics.getThumbnail().getExtension()).into(imageView);
        }
    }
}