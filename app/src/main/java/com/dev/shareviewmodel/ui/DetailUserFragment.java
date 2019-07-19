package com.dev.shareviewmodel.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dev.shareviewmodel.model.User;
import com.dev.shareviewmodel.R;
import com.dev.shareviewmodel.viewmodel.SharedViewModel;
import com.dev.shareviewmodel.databinding.FragmentDetailBinding;

public class DetailUserFragment extends Fragment {

    private FragmentDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_detail,container,false);
        SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        binding = DataBindingUtil.setContentView(getActivity() , R.layout.fragment_detail);
        model.getSelected().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                if( o != null && o.getClass().getName().equals("com.dev.shareviewmodel.model.User")){
                    User user = (User)o;
                    binding.setUser(user);
                }
            }
        });
        return view;
    }
}
