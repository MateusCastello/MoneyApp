package br.unicamp.ft.f102312_m203257.MoneyApp.ui.despesas;

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

import br.unicamp.ft.f102312_m203257.MoneyApp.R;

public class DespesasFragment extends Fragment {

    private DespesasViewModel despesasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        despesasViewModel =
                ViewModelProviders.of(this).get(DespesasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_despesas, container, false);
        final TextView textView = root.findViewById(R.id.text_despesas);
        despesasViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}