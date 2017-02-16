package io.hikari9.realmtest.models;

import android.databinding.ObservableField;

public class User {
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();
    public User(String firstName, String lastName) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }
    @Override
    public String toString() {
        return this.firstName.get() + " " + this.lastName.get();
    }
}
