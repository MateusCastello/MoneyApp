package br.unicamp.ft.f102312_m203257.MoneyApp.operacoes;

import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.unicamp.ft.f102312_m203257.MoneyApp.R;

public class ExtratoAdapter extends RecyclerView.Adapter {
    private ArrayList<Operacao> operacoes;
    MyOnItemClickListener itemClickListener;
    MyOnLongItemClickListener myOnLongItemClickListener;

    public ExtratoAdapter(ArrayList<Operacao> alunos) {
        this.operacoes = operacoes;
    }

    public class ExtratoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgOp;
        private TextView txtDescricao;
        private TextView txtTipoOp;
        private TextView txtValor;

        public ExtratoViewHolder(View itemView) {
            super(itemView);
            imgOp = itemView.findViewById(R.id.imgOp);
            txtDescricao = itemView.findViewById(R.id.txtDescricao);
            txtValor = itemView.findViewById(R.id.txtDescricao);
        }

        public void Bind(final Operacao operacao) {
            imgOp.setImageResource(operacao.getFoto());
            txtValor.setText(operacao.getValor().toString());
            txtDescricao.setText(Html.fromHtml(operacao.getDescricao()));
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount(){
        return operacoes.size();
    }

    public interface MyOnItemClickListener{
        void MyOnItemClick(String nome);
    }

    public void setItemClickListener(MyOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface MyOnLongItemClickListener{
        void myOnLongItemClick(int position);
    }

    public void setItemLongClickListener(MyOnLongItemClickListener myOnLongItemClickListener) {
        this.myOnLongItemClickListener = myOnLongItemClickListener;
    }
}
