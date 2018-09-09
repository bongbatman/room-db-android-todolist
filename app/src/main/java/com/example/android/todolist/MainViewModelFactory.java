package com.example.android.todolist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final TaskRepository taskRepository;


    public MainViewModelFactory(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        /**
         * adding noinspection unchecked comment removes the warning of unchecked cast
         */

        //noinspection unchecked
        return (T) new MainViewModel(taskRepository);
    }
}
