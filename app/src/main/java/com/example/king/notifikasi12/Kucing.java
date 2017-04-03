package com.example.king.notifikasi12;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

/**
 * Created by king on 3/17/2017.
 */
public class Kucing extends AppCompatActivity {
    // identititas id unik untuk notification
    public static final int NOTIFICATION_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kucing);


        getSupportActionBar().setSubtitle("Belajar di okedroid.com");

    }

    public void tampilNotification(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.okedroid.com/"));
        //menginisialiasasi intent
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        //untuk memanggil activity di Notification
        /*
Menmbangun atau mensetup Notification dengan NotificationCompat.Builder
 */
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.tuxmdpi) //ikon notification
                .setContentTitle("1 Postingan Baru")//judul konten
                .setContentIntent(pendingIntent)//memanggil object pending intent
                .setAutoCancel(true)//untuk menswipe atau menghapus notification
                .setContentText("Kunjungi blog okedroid.com"); //isi text

/*
Kemudian kita harus menambahkan Notification dengan menggunakan NotificationManager
 */

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, builder.build()
        );
    }


}
