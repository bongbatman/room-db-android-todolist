package com.example.android.todolist.utils;

import android.content.Context;

import com.example.android.todolist.AppExecutors;
import com.example.android.todolist.MainViewModelFactory;
import com.example.android.todolist.TaskRepository;
import com.example.android.todolist.db.AppDatabase;

public class InjectorUtils {


    public static TaskRepository provideRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context.getApplicationContext());
        AppExecutors executors = AppExecutors.getInstance();
        return TaskRepository.getInstance(database.taskDao(), executors);
    }

    public static MainViewModelFactory provideMainActivityViewModelFactory(Context context) {
        TaskRepository repository = provideRepository(context.getApplicationContext());
        return new MainViewModelFactory(repository);
    }


}
