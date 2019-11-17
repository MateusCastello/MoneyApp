package br.unicamp.ft.f102312_m203257.MoneyApp.ui.despesas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DespesasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DespesasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}