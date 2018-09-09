package com.example.android.todolist;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.example.android.todolist.utils.NotificationUtils;
import com.example.android.todolist.workers.TaskReminderWorker;

import java.util.concurrent.TimeUnit;

import static com.example.android.todolist.AddTaskActivity.DESCRIPTION_FOR_NOTIFICATION;

public class TaskWorkRequestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving

        // an Intent broadcast.

//        if(intent != null && intent.getAction().contentEquals(AddTaskActivity.ACTION_REMIND_TASK)){
//            Data data = new Data.Builder()
//                    .putString(DESCRIPTION_FOR_NOTIFICATION, intent.getStringExtra(DESCRIPTION_FOR_NOTIFICATION))
//                    .build();
//
//
//            PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(TaskReminderWorker.class
//            ,15, TimeUnit.MINUTES)
//                    .build();
//
//            OneTimeWorkRequest.Builder oneTimeWorkRequest = new OneTimeWorkRequest.Builder(TaskReminderWorker.class)
//                    .setInputData(data);
////                    .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 1, TimeUnit.MINUTES);
//
//
//            WorkManager.getInstance().enqueue(oneTimeWorkRequest.build());

//            NotificationUtils.createNotification(context, intent.getStringExtra(DESCRIPTION_FOR_NOTIFICATION);
//        }


    }
}
