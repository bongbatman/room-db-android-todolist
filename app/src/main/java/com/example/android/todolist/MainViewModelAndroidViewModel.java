package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.todolist.db.AppDatabase;
import com.example.android.todolist.db.TaskEntry;

import java.util.List;


public class MainViewModelAndroidViewModel extends AndroidViewModel {

    private static final String LOG_TAG = MainViewModelAndroidViewModel.class.getSimpleName() ;
    private LiveData<List<TaskEntry>> listLiveData;

    public MainViewModelAndroidViewModel(@NonNull Application application) {
        super(application);

        Log.d(LOG_TAG, "MainViewModelAndroidViewModel: View Model At work");
        AppDatabase appDatabase = AppDatabase.getInstance(this.getApplication());
        listLiveData = appDatabase.taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getListLiveData() {
        return listLiveData;
    }
}
