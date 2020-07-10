package com.health.WekayaApp.PublicOperations;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.health.WekayaApp.R;
import com.health.WekayaApp.UI.MainActivity;

import java.util.Calendar;

public class Operations {

    // this method is used to get hour from the system .
    public static Calendar getHour(){
        Calendar calendar = Calendar.getInstance() ;
        calendar.set(Calendar.HOUR_OF_DAY , 7);
        calendar.set(Calendar.MINUTE , 47);
        calendar.set(Calendar.SECOND , 0);
        calendar.set(Calendar.MILLISECOND , 0);
        Calendar car = Calendar.getInstance() ;
        if (car.after(calendar)){
            calendar.add(Calendar.DATE , 1);
        }
        return calendar ;
    }


    // this method is used to create notification
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createNotification(Context context ) {
        String CHANNEL_ID = "my_channel_01";// The id of the channel.
        CharSequence name = context.getString(R.string.channel_name);// The user-visible name of the channel.
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_virus)
                .setContentTitle("حافظ علي نفسك ")
                .setContentText("سلامتك تهمنا ديما, ادخل ع التطبيق واتبع تعليمات الوقايه")
                .setChannelId(CHANNEL_ID)
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        Intent i = new Intent(context, MainActivity.class) ;
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                0 , i , PendingIntent.FLAG_UPDATE_CURRENT);
        nBuilder.setContentIntent(pendingIntent) ;
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(0,nBuilder.build());
    }


    private void anotherNotification(Context context){
        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(context, MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(R.drawable.ic_virus)
                .setContentTitle("حافظ علي نفسك ")
                .setContentText("سلامتك تهمنا ديما, ادخل ع التطبيق واتبع تعليمات الوقايه")
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});  // Declair VIBRATOR Permission in AndroidManifest.xml
        notificationManager.notify(15, mNotifyBuilder.build());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String CHANNEL_ID = "my_channel_01";
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "02")
                    .setContentTitle("حافظ علي نفسك ")
                    .setContentText("سلامتك تهمنا ديما, ادخل ع التطبيق واتبع تعليمات الوقايه")
                    .setSmallIcon(R.drawable.ic_virus)
                    .setAutoCancel(true)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setChannelId(CHANNEL_ID)
                    .setContentIntent(pendingIntent).setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});  // Declair VIBRATOR Permission in AndroidManifest.xml
            ;

            // For Oreo and greater than it, we required Notification Channel.
            CharSequence name = "My New Channel";                   // The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance); //Create Notification Channel
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(89 /* ID of notification */, notificationBuilder.build());

        }
    }
}
