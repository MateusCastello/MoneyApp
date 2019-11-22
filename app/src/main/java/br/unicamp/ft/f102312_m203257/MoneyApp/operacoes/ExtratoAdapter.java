package br.unicamp.ft.f102312_m203257.MoneyApp.operacoes;

import android.text.Html;
import android.view.LayoutInflater;
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

    public ExtratoAdapter(ArrayList<Operacao> operacoes) {
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
            txtValor = itemView.findViewById(R.id.txtValor);
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    TextView txtNome = view.findViewById(R.id.txtDescricao);
                    itemClickListener.MyOnItemClick(txtNome.getText().toString());
                }
            }
        });
        return new ExtratoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ExtratoViewHolder) holder).Bind(operacoes.get(position));

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myOnLongItemClickListener.myOnLongItemClick(position);
                return true;
            }
        });
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
