package com.example.android.endless.presentation;

import com.example.android.endless.model.EndlessDataBaseHelper;
import com.example.android.endless.model.User;
import com.google.common.collect.EvictingQueue;
import java.util.Queue;

class UserPresenter {

  private static final int DEFAULT_MAX_ELEMENTS_IN_MEMORY = 50;
  private Queue<User> mCache;

  private EndlessDataBaseHelper mEndlessDataBaseHelper;

  UserPresenter(EndlessDataBaseHelper endlessDataBaseHelper) {
    mEndlessDataBaseHelper = endlessDataBaseHelper;

    if (mEndlessDataBaseHelper.isUserTableEmpty()) {
      fillDataBase();
    }

    mCache = EvictingQueue.create(DEFAULT_MAX_ELEMENTS_IN_MEMORY);
  }

  EndlessDataBaseHelper getDataBase() {
    return mEndlessDataBaseHelper;
  }

  // Fill the data base with information
  private void fillDataBase() {
    for (int i = 0; i < 1000; i++) {
      String firstName = "first_name" + i;
      String lastName = "last_name" + i;
      mEndlessDataBaseHelper.insertUser(firstName, lastName);
    }
  }

  // Get information from cache
  User getCache(int index){
    for(User user : mCache){
      if(index == user.getId()){
        return user;
      }
    }
    return null;
  }
  // Fill cache
  void walkTroughCache(User user) {
    mCache.add(user);
  }
}
