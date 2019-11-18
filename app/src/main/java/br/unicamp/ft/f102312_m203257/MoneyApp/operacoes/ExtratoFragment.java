package br.unicamp.ft.f102312_m203257.MoneyApp.operacoes;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.unicamp.ft.f102312_m203257.MoneyApp.R;
import br.unicamp.ft.f102312_m203257.MoneyApp.database.DatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtratoFragment extends Fragment {

    RecyclerView mRecyclerView;
    ExtratoAdapter mAdapter;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    public ExtratoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_extrato, container, false);


        if(view == null) {
            return inflater.inflate(R.layout.fragment_extrato, container, false);
        }

        return view;
    }

    public void onStart() {
        super.onStart();
        //getActivity().deleteDatabase("EXEMPLO");
        dbHelper = new DatabaseHelper(getActivity());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        carregarExtrato(getView());
    }

    private void carregarExtrato(View view){
        String sql = "Select * from despesas";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        ArrayList<Operacao> operacoes = new ArrayList<Operacao>();
        if (cursor.moveToFirst()) {
            do {
                Operacao operacao = new Operacao(cursor.getString(1),cursor.getString(2),Double.parseDouble(cursor.getString(3)));
                operacoes.add(operacao);
            } while (cursor.moveToNext());
        }

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new ExtratoAdapter(new ArrayList(operacoes));
        mRecyclerView.setAdapter(mAdapter);
    }
}
