package com.dev.shareviewmodel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dev.shareviewmodel.ui.ListUserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load_list_user();
    }

    private void load_list_user(){
        FragmentManager manager = getSupportFragmentManager();
        ListUserFragment list = new ListUserFragment();
        manager.beginTransaction().add( R.id.layout_container , list ).addToBackStack("LIST_USER").commit();
    }

    @Override
    public void onBackPressed() {
        Fragment f =  getSupportFragmentManager().findFragmentById(R.id.layout_container);
        if( f.getClass().getName().equals("com.dev.shareviewmodel.ui.DetailUserFragment") && getSupportFragmentManager().getBackStackEntryCount() > 0 ){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
