package com.dev.shareviewmodel.repository;

import android.arch.lifecycle.MutableLiveData;

import com.dev.shareviewmodel.model.RESPONSE.listUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class userRepository extends repository {
    private static userRepository repository;

    public userRepository() {
        super();
    }

    public synchronized static userRepository getInstance() {
        if (repository == null) {
            repository = new userRepository();
        }
        return repository;
    }

    public MutableLiveData<listUser> getList(){
        final MutableLiveData<listUser> list = new MutableLiveData<>();
        API.listuser().enqueue(new Callback<listUser>() {
            @Override
            public void onResponse(Call<listUser> call, Response<listUser> response) {
                list.setValue(response.body());
            }

            @Override
            public void onFailure(Call<listUser> call, Throwable t) {
                list.setValue(null);
            }
        });
        return list;
    }
}
