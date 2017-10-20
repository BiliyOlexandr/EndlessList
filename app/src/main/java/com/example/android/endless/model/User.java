package com.example.android.endless.model;

public class User {
  private String mFirstName;
  private String mLastName;
  private int mId;

  public User(String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
  }
  public User(int id, String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
    mId = id;
  }

  @Override public String toString() {
    return mFirstName + " " + mLastName;
  }

  public int getId() {
    return mId;
  }
}

