package com.example.android.todolist.workers;

import android.support.annotation.NonNull;

import com.example.android.todolist.AddTaskActivity;
import com.example.android.todolist.utils.NotificationUtils;

import androidx.work.Worker;

public class TaskReminderWorker extends Worker {




    @NonNull
    @Override
    public Result doWork() {

        String description = getInputData().getString(AddTaskActivity.DESCRIPTION_FOR_NOTIFICATION);
        NotificationUtils.createNotification(getApplicationContext(), description);

        return Result.SUCCESS;
    }
}
