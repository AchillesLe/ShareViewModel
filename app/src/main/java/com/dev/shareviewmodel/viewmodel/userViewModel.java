package com.dev.shareviewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.dev.shareviewmodel.model.RESPONSE.listUser;
import com.dev.shareviewmodel.repository.userRepository;

public class userViewModel extends ViewModel {
    private MutableLiveData<listUser> users;
    public LiveData<listUser> getUsers() {
        if (users == null) {
            users = new MutableLiveData<listUser>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        users = userRepository.getInstance().getList();
    }
}
