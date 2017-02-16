package io.hikari9.realmtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import io.hikari9.realmtest.databinding.ActivityMainBinding;
import io.hikari9.realmtest.presenters.ActivityMainPresenter;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main); // replaces setContentView
        binding.setPresenter(new ActivityMainPresenter());

    }

}
