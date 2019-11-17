package br.unicamp.ft.f102312_m203257.MoneyApp.ui.operacoes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OperacoesViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    public OperacoesViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is gallery fragment");*/
    }

    public LiveData<String> getText() {
        return mText;
    }
}