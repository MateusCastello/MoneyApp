package br.unicamp.ft.f102312_m203257.MoneyApp.operacoes;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.unicamp.ft.f102312_m203257.MoneyApp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtratoFragment extends Fragment {


    public ExtratoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extrato, container, false);
    }

}
