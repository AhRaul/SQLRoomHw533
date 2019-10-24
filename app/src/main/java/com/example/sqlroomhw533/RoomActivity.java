package com.example.sqlroomhw533;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoomActivity extends AppCompatActivity {

    private RoomPresenter roomPresenter;

    @BindView(R.id.buttonAddUser)
    Button bAddUser;

    @BindView(R.id.buttonAddUserList)
    Button bAddUserList;

    @BindView(R.id.buttonDeleteUser)
    Button bDeleteLastUser;

    @BindView(R.id.buttonUpdateUser)
    Button bUpdateLastUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);

        roomPresenter = new RoomPresenter();
    }

    @OnClick(R.id.buttonAddUser)
    public void onClickAddUser(View view) {
        roomPresenter.putData();
    }

    @OnClick(R.id.buttonAddUserList)
    public void onClickAddUserList(View view) {
        roomPresenter.putListData();
    }

    @OnClick(R.id.buttonDeleteUser)
    public void onClickDeleteLastUser(View view) {
        roomPresenter.deleteData();
    }

    @OnClick(R.id.buttonUpdateUser)
    public void onClickUpdateLastUser(View view) {
        roomPresenter.updateData();
    }

}
