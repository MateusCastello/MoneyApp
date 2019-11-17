package br.unicamp.ft.f102312_m203257.MoneyApp.ui.operacoes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import br.unicamp.ft.f102312_m203257.MoneyApp.R;
import br.unicamp.ft.f102312_m203257.MoneyApp.database.DatabaseHelper;

public class OperacoesFragment extends Fragment {

    private View root;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    private OperacoesViewModel operacoesViewModel;
    Button btnSalvar;
    EditText txtDescricao;
    EditText txtValor;
    Spinner spinner;
    String[] boards = {"Despesa", "Receita"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        operacoesViewModel =
                ViewModelProviders.of(this).get(OperacoesViewModel.class);
        root = inflater.inflate(R.layout.fragment_operacoes, container, false);
        btnSalvar = (Button) root.findViewById(R.id.btn_salvar);
        txtDescricao = (EditText)root.findViewById(R.id.txt_descricao);
        txtValor = (EditText)root.findViewById(R.id.txt_valor);
        spinner = (Spinner)root.findViewById(R.id.spinner_operacao);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_item  ,boards);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnSalvar.setOnClickListener(salvarClick);

        return root;
    }

    View.OnClickListener salvarClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(validarCampos()){
                String tipoOp = spinner.getSelectedItem().toString().equals("Despesa") ? "D" : "C";
                String descricao = txtDescricao.getText().toString();
                Double valor = Double.parseDouble(txtValor.getText().toString());
                inserirDespesa(descricao,tipoOp,valor);
                Toast.makeText(getContext(), "Operação Inserida com Sucesso", Toast.LENGTH_LONG).show();
                limparCampos();
            }
        }
    };

    private void inserirDespesa(String descricao,String tipoOp, Double valor){

        ContentValues contentValues = new ContentValues();
        contentValues.put("descricao", descricao);
        contentValues.put("tipoOperacao", tipoOp);
        contentValues.put("valor", valor);

        sqLiteDatabase.insert("despesas", null, contentValues);
    }

    private void limparCampos(){
        txtDescricao.setText("");
        txtValor.setText("");
    }

    private boolean validarCampos() {
        boolean validado = true;
        if (txtValor.getText().toString().length() == 0 || txtDescricao.getText().toString().length() == 0) {
            Toast.makeText(getContext(), "Valor e Descricao devem ser preenchidos", Toast.LENGTH_LONG).show();
            validado = false;
        }
        return validado;
    }

    public void onStart() {
        super.onStart();
        dbHelper = new DatabaseHelper(getActivity());
        sqLiteDatabase = dbHelper.getReadableDatabase();
    }
}