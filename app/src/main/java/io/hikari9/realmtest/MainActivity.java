package io.hikari9.realmtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import io.hikari9.realmtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main); // replaces setContentView
        updateGreetingsLabel();

        // setup the listeners
        binding.firstName.addTextChangedListener(new GreetingsLabelWatcher());
        binding.lastName.addTextChangedListener(new GreetingsLabelWatcher());
        binding.clearButton.setOnClickListener(new ClearButtonListener());

    }

    class ClearButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            final Editable previousFirstName = binding.firstName.getText();
            final Editable previousLastName = binding.lastName.getText();
            binding.firstName.setText("");
            binding.lastName.setText("");
            Snackbar
                .make(view, "Fields successfully cleared", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.firstName.setText(previousFirstName);
                        binding.lastName.setText(previousLastName);
                    }
                }).show();
        }
    }

    class GreetingsLabelWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            updateGreetingsLabel();
        }

    }

    public void updateGreetingsLabel() {
        Editable firstName = binding.firstName.getText();
        Editable lastName = binding.lastName.getText();
        if (firstName.length() == 0 || lastName.length() == 0) {
            binding.welcomeMessage.setText("Please fill out both fields");
            binding.clearButton.setEnabled(false);
        } else {
            binding.welcomeMessage.setText("Welcome, " + firstName + " " + lastName + "!");
            binding.clearButton.setEnabled(true);
        }
    }

}
