package com.samyotech.laundrymitra.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.core.app.NotificationCompat
import com.samyotech.laundrymitra.R
import com.samyotech.laundrymitra.ui.activity.Dashboard

class NotificationManagers(private val mCtx: Context) {
    fun displayNotification(
            title: String?,
            body: String?,
            url: String?
    ) {


//        val soundUri: Uri =
//                Uri.parse("android.resource://" + getApplicationContext().packageName + "/" + R.raw.sirene)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val mNotificationManager =
                    mCtx.getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager
            val importance = android.app.NotificationManager.IMPORTANCE_HIGH
            val mChannel =
                    NotificationChannel("Constant.CHANNEL_ID", "Constant.CHANNEL_NAME", importance)
            mChannel.description = "Constant.CHANNEL_DESCRIPTION"
            mChannel.enableLights(true)
            mChannel.lightColor = Color.RED
            mChannel.enableVibration(true)

//            val audioAttributes = AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
//                    .build()
//            mChannel.setSound(soundUri, audioAttributes)

            mNotificationManager.createNotificationChannel(mChannel)
        }

        val mBuilder =
                NotificationCompat.Builder(mCtx, "Constant.CHANNEL_ID")
                        .setSmallIcon(R.drawable.logonew)
                        .setLargeIcon(
                                BitmapFactory.decodeResource(
                                        mCtx.getResources(),
                                        R.drawable.logonew
                                )
                        )
                        .setContentTitle(title)
                        .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
                        // .setSound(soundUri)
                        .setAutoCancel(true)
                        .setOngoing(true)
                        .setContentText(body)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        /*
         *  Clicking on the notification will take us to this intent
         *  Right now we are using the MainActivity as this is the only activity we have in our application
         *  But for your project you can customize it as you want
         * */
        val resultIntent = Intent(mCtx, Dashboard::class.java)
        resultIntent.putExtra("url", url)
        /*
         *  Now we will create a pending intent
         *  The method getActivity is taking 4 parameters
         *  All paramters are describing themselves
         *  0 is the request code (the second parameter)
         *  We can detect this code in the activity that will open by this we can get
         *  Which notification opened the activity
         * */
        val pendingIntent = PendingIntent.getActivity(
                mCtx, 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        /*
         *  Setting the pending intent to notification builder
         * */mBuilder.setContentIntent(pendingIntent)
        val mNotifyMgr =
                mCtx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        /*
         * The first parameter is the notification id
         * better don't give a literal here (right now we are giving a int literal)
         * because using this id we can modify it later
         * */mNotifyMgr?.notify(1, mBuilder.build())
    }

    companion object {
        private var mInstance: NotificationManagers? = null

        @Synchronized
        fun getInstance(context: Context): NotificationManagers? {
            if (mInstance == null) {
                mInstance = NotificationManagers(context)
            }
            return mInstance
        }
    }

}
