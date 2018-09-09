package com.example.android.todolist.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;

import com.example.android.todolist.AddTaskActivity;
import com.example.android.todolist.R;

public class NotificationUtils {

    private static final int NOTIFICATION_ID = 420;
    private static final String NOTIFICATION_CHANNEL_NAME = "Task Notifications";
    private static final String NOTIFICATION_CHANNEL_ID = "100";

    public static void createNotification(Context context, @Nullable String description){

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID
            , NOTIFICATION_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            context.getSystemService(NotificationManager.class).createNotificationChannel(notificationChannel);
        }

        Intent intent = new Intent(context, AddTaskActivity.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(context);
        taskStackBuilder.addNextIntentWithParentStack(intent);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(4, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder
                = new NotificationCompat.Builder(
                        context,
                NOTIFICATION_CHANNEL_ID
        ).setSmallIcon(R.drawable.priority_circle)
                .setContentTitle("Task Reminder")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(false);

        if (description == null) {
            builder.setContentText("Kuch nai aya yahan bhak");
        }else{
            builder.setContentText(description);
        }

        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build());


    }





}
