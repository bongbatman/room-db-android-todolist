package com.example.android.todolist;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.android.todolist.db.TaskDao;
import com.example.android.todolist.db.TaskEntry;

import java.util.List;

public class TaskRepository {

    private static final String LOG_TAG =TaskRepository.class.getSimpleName();
    private final TaskDao taskDao;
    private LiveData<List<TaskEntry>> tasks;

    private final AppExecutors mExecutors;
    private boolean mInitialized = false;
    private static final Object LOCK = new Object();
    private static TaskRepository sInstance;

    private TaskRepository(TaskDao taskDao, AppExecutors executors) {
        this.taskDao = taskDao;
        this.mExecutors = executors;
        tasks = taskDao.loadAllTasks();
    }


    /**
     *Using this method will make depemdency injection during testing difficult so not recommended but will work fine
     * Use singleton approach with injector utils
     */
//    public TaskRepository(Application application) {
//        AppDatabase appDatabase = AppDatabase.getInstance(application);
//        taskDao = appDatabase.taskDao();
//        tasks = taskDao.loadAllTasks();
//
//    }

    public synchronized static TaskRepository getInstance(
            TaskDao taskDao,
            AppExecutors executors) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new TaskRepository(taskDao,
                        executors);
                Log.d(LOG_TAG, "Made new repository");
            }
        }
        return sInstance;
    }

    public void insertTask(final TaskEntry taskEntry){
        AppExecutors.getInstance().diskIo().execute(new Runnable() {
            @Override
            public void run() {
                taskDao.insertTask(taskEntry);
            }
        });
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
