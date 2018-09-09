package com.example.android.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.todolist.db.AppDatabase;
import com.example.android.todolist.db.TaskEntry;

public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> taskEntryLiveData;

    public AddTaskViewModel(AppDatabase appDatabase, int mId) {
        taskEntryLiveData = appDatabase.taskDao().loadTaskById(mId);

    }

    public LiveData<TaskEntry> getTaskEntryLiveData() {
        return taskEntryLiveData;
    }
}
