package br.unicamp.ft.f102312_m203257.MoneyApp.operacoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.unicamp.ft.f102312_m203257.MoneyApp.R;
import br.unicamp.ft.f102312_m203257.MoneyApp.database.DatabaseHelper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExtratoActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ExtratoAdapter mAdapter;
    TextView txtSaldo;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        txtSaldo = (TextView)findViewById(R.id.txtSaldo);
        setContentView(R.layout.activity_extrato);
    }

    public void onStart() {
        super.onStart();
        txtSaldo = (TextView)findViewById(R.id.txtSaldo);
        dbHelper = new DatabaseHelper(this);
        sqLiteDatabase = dbHelper.getReadableDatabase();
        carregarExtrato(this.findViewById(android.R.id.content));
    }

    private void carregarExtrato(View view){
        Double receitas = 0.0;
        Double despesas = 0.0;
        String sql = "Select * from despesas";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        final ArrayList<Operacao> operacoes = new ArrayList<Operacao>();
        if (cursor.moveToFirst()) {
            do {
                Operacao operacao = new Operacao(cursor.getInt(0),cursor.getString(1),cursor.getString(2).equals("D") ? R.drawable.ic_remove_black_24dp : R.drawable.ic_add_black_24dp,Double.parseDouble(cursor.getString(3)));
                operacoes.add(operacao);
            } while (cursor.moveToNext());
        }

        sql = "Select SUM(valor) as valor from despesas where tipoOperacao='D' ";


        Cursor cursorDesp = sqLiteDatabase.rawQuery(sql, null);
        if (cursorDesp.moveToFirst()) {
            do {
                despesas = cursorDesp.getDouble(0);
            } while (cursorDesp.moveToNext());
        }

        sql = "Select SUM(valor) as valor from despesas where tipoOperacao='C'";
        Cursor cursorRec = sqLiteDatabase.rawQuery(sql, null);
        if (cursorRec.moveToFirst()) {
            do {
                receitas = cursorRec.getDouble(0);
            } while (cursorRec.moveToNext());
        }

        Double total = receitas - despesas;
        txtSaldo.setText("Saldo Total: " + total.toString());
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ExtratoAdapter(new ArrayList(operacoes));
        mAdapter.setItemLongClickListener(new ExtratoAdapter.MyOnLongItemClickListener() {
            @Override
            public void myOnLongItemClick(int position) {
                Operacao op = operacoes.get(position);
                deleteOperacao(op);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    private void deleteOperacao(Operacao operacao){
        sqLiteDatabase.execSQL("Delete from despesas where _id = " + operacao.getId());
        Toast.makeText(this, "Operação removida", Toast.LENGTH_LONG).show();

        carregarExtrato(this.findViewById(android.R.id.content));
    }
}
