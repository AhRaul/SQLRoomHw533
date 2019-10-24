package com.example.sqlroomhw533;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RoomPresenter {

    private static final String TAG = "RoomPresenter";

    private UserDao userDao;

    public RoomPresenter() {
        userDao = App.getAppDatabase().userDao();
    }

    public void putData() {
        User user = new User();
        user.name = "Petya";
        user.surname = "Kozlov";
        user.age = "25";

        Disposable disposable = userDao.insert(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "putData: " + id);
                }, throwable -> {
                    Log.d(TAG, "putData: " + throwable);
                });
    }

    public void getData() {
        Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    Log.d(TAG, "getData: " + users + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "getData: " + throwable);
                });
    }

    public void deleteData() {
        User user = new User();
        user.id = 20;
        Disposable disposable = userDao.delete(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "deleteData: " + id);
                }, throwable -> {
                    Log.d(TAG, "deleteData: " + throwable);
                });
    }

    public void putListData() {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.name = "Kolya";
        user1.surname = "Petrov";
        user1.age = "17";
        users.add(user1);

        User user2 = new User();
        user1.name = "Nastia";
        user1.surname = "Sidorova";
        user1.age = "22";
        users.add(user2);

        User user3 = new User();
        user1.name = "Arakdiy";
        user1.surname = "Melnikov";
        user1.age = "35";
        users.add(user3);

        Disposable disposable = userDao.insertList(users).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "putData: " + id);
                }, throwable -> {
                    Log.d(TAG, "putData: " + throwable);
                });
    }

    public void updateData() {
        User user = new User();
        user.name = "UpdateName";
        user.surname = "UpdateSurname";
        user.age = "100";
        user.id = 24;

        Disposable disposable = userDao.update(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "deleteData: " + id);
                }, throwable -> {
                    Log.d(TAG, "deleteData: " + throwable);
                });
    }
}
