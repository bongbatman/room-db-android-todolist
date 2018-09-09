package com.example.android.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.todolist.db.TaskEntry;

import java.util.List;

public class MainViewModel extends ViewModel {


    private final LiveData<List<TaskEntry>> listLiveData;

    private final TaskRepository mTaskRepository;


    MainViewModel(TaskRepository taskRepository) {
        mTaskRepository = taskRepository;
        listLiveData = mTaskRepository.getTasks();
    }

    public LiveData<List<TaskEntry>> loadAllTaks() {
        return listLiveData;
    }
}
