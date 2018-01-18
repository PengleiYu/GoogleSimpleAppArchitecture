package com.example.apparchitecture.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by yupenglei on 18/1/18.
 */

@SuppressWarnings("WeakerAccess")
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "fist_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() { return uid + ": " + firstName + " . " + lastName; }
}
