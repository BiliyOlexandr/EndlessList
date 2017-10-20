package com.example.android.endless.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.android.endless.R;
import com.example.android.endless.model.EndlessDataBaseHelper;

public class UserActivity extends AppCompatActivity {

  UserPresenter mUserPresenter;
  UserAdapter mUserAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mUserPresenter = new UserPresenter(new EndlessDataBaseHelper(this));
    mUserAdapter = new UserAdapter(mUserPresenter);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    recyclerView.setAdapter(mUserAdapter);
  }
}
