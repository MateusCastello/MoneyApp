package br.unicamp.ft.f102312_m203257.MoneyApp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import br.unicamp.ft.f102312_m203257.MoneyApp.newsapi.Colors;
import br.unicamp.ft.f102312_m203257.MoneyApp.newsapi.Time;
import br.unicamp.ft.f102312_m203257.MoneyApp.noticias.Artigo;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>  {

    private List<Artigo> artigos;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public Adapter(List<Artigo> artigos, Context context) {
        this.artigos = artigos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.noticia, parent, false);
        return new MyViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int posicao) {
        final MyViewHolder holder = holders;
        Artigo modelo = artigos.get(posicao);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(Colors.getRandomDrawbleColor());
        requestOptions.error(Colors.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();

        Glide.with(context)
                .load(modelo.getUrlDaImagem())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.imageView);
        holder.titulo.setText(modelo.getTitulo());
        holder.descricao.setText(modelo.getDescricao());
        holder.fonte.setText(modelo.getFonte().getNome());
        holder.horas.setText(Time.DateToTimeFormat(modelo.getPublicadoEm()));
        holder.publicadoEm.setText(Time.DateFormat(modelo.getPublicadoEm()));

    }

    @Override
    public int getItemCount() {
        return artigos.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView titulo, descricao, publicadoEm, fonte, horas;
        ImageView imageView;
        OnItemClickListener onItemClickListener;

        public MyViewHolder (View itemView, OnItemClickListener onItemClickListener){
            super(itemView);

            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imagem);
            horas = itemView.findViewById(R.id.horas);
            titulo = itemView.findViewById(R.id.titulo);
            descricao = itemView.findViewById(R.id.descricao);
            publicadoEm = itemView.findViewById(R.id.publicadoEm);
            fonte = itemView.findViewById(R.id.fonte);
            this.onItemClickListener = onItemClickListener;
        }
        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v, getAdapterPosition());

        }
    }
}
