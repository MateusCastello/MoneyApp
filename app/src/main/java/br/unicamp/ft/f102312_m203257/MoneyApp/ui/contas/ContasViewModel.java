package br.unicamp.ft.f102312_m203257.MoneyApp.ui.contas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}