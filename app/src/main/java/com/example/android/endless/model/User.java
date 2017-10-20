package com.example.android.endless.model;

public class User {
  private String mFirstName;
  private String mLastName;

  public User(String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
  }

  @Override public String toString() {
    return mFirstName + " " + mLastName;
  }
}

