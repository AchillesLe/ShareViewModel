package com.dev.shareviewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SharedViewModel<T> extends ViewModel {
    private final MutableLiveData<T> selected = new MutableLiveData<T>();

    public void select(T item) {
        selected.setValue(item);
    }

    public LiveData<T> getSelected() {
        return selected;
    }
}
