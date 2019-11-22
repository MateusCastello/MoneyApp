package br.unicamp.ft.f102312_m203257.MoneyApp.ui.noticias;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NoticiasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NoticiasViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}