package com.dev.shareviewmodel.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.shareviewmodel.adapter.ListUserAdapter;
import com.dev.shareviewmodel.model.RESPONSE.listUser;
import com.dev.shareviewmodel.model.User;
import com.dev.shareviewmodel.R;
import com.dev.shareviewmodel.viewmodel.SharedViewModel;
import com.dev.shareviewmodel.viewmodel.userViewModel;

public class ListUserFragment extends Fragment {
    private SharedViewModel model;
    private userViewModel   usermodel ;
    private RecyclerView recyclerView;
    private ListUserAdapter adapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usermodel = ViewModelProviders.of(getActivity()).get(userViewModel.class);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        usermodel.getUsers().observe(this, new Observer<listUser>() {
            @Override
            public void onChanged(@Nullable listUser listUser) {
                adapter = new ListUserAdapter( );
                adapter.setUsers( listUser.getData() );
                recyclerView.setAdapter(adapter);
                adapter.setOnUserClick(new ListUserAdapter.userClickListener() {
                    @Override
                    public void UserClick(User user) {
                        model.select(user);
                        FragmentManager manager = getFragmentManager();
                        DetailUserFragment detail = new DetailUserFragment();
                        manager.beginTransaction().add( R.id.layout_container , detail ).addToBackStack("DETAIL_USER").commit();
                    }
                });
            }
        });

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_user,container,false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}
