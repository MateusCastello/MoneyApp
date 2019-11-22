package br.unicamp.ft.f102312_m203257.MoneyApp.ui.home;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import br.unicamp.ft.f102312_m203257.MoneyApp.MainActivity;
import br.unicamp.ft.f102312_m203257.MoneyApp.R;
import br.unicamp.ft.f102312_m203257.MoneyApp.database.DatabaseHelper;
import br.unicamp.ft.f102312_m203257.MoneyApp.operacoes.Operacao;

public class HomeFragment extends Fragment {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    private HomeViewModel homeViewModel;
    private String sql;
    private double despesas;
    private String despesasText = "Despesas";
    private double receitas;
    private String receitasText = "Receitas";
    private double total = despesas + receitas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        dbHelper = new DatabaseHelper(getContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        setupChart();
        return root;
    }



    private void setupChart() {
        getOperacoes();
        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry((float)despesas, despesasText));
        pieEntries.add(new PieEntry((float)receitas,receitasText));

        PieDataSet dataSet = new PieDataSet(pieEntries, "Balanço dos gastos");
        PieData data = new PieData(dataSet);

        final int[] MY_COLORS = {Color.rgb(192,0,0), Color.rgb(0,200,127), Color.rgb(255,192,0),
                Color.rgb(127,127,127), Color.rgb(146,208,80), Color.rgb(0,176,80), Color.rgb(79,129,189)};
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for(int c: MY_COLORS) colors.add(c);

        dataSet.setColors(colors);

        PieChart chart = getActivity().findViewById(R.id.homeChart);
        chart.setEntryLabelTextSize(12);
        chart.setData(data);
        chart.invalidate();
    }

    private void getOperacoes (){


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

    }
}