package com.example.android.endless.presentation;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.endless.R;
import com.example.android.endless.model.EndlessDataBaseHelper;
import com.example.android.endless.model.User;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

  private UserPresenter mUserPresenter;
  private Cursor mCursor;

  UserAdapter(UserPresenter userPresenter) {
    mUserPresenter = userPresenter;
    mCursor = mUserPresenter.getDataBase().getCursor();
  }

  //Creating a new view
  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
    return new ViewHolder(view);
  }

  // Filling a given view with data
  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.textUser.setText(getInfo(position).toString());
  }

  //Get information from cache if it do not empty,
  //else get information from data base and add it to cache
  private User getInfo(int position) {

    User user = mUserPresenter.getCache(position);
    if(user == null){
      mCursor.moveToPosition(position);
      user = new User(mCursor.getString(mCursor.getColumnIndex(EndlessDataBaseHelper.FIRST_NAME)),
          mCursor.getString(mCursor.getColumnIndex(EndlessDataBaseHelper.LAST_NAME)));
      mUserPresenter.walkTroughCache(user);
    }
    return user;
  }

  //Return count of option in data set
  @Override public int getItemCount() {
    return mCursor.getCount();
  }

  //Data is sent through constructor
  static class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView textUser;

    ViewHolder(final View itemView) {
      super(itemView);
      textUser = (TextView) itemView.findViewById(R.id.text_user);
    }
  }
}

