package com.samyotech.laundrymitra.service

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

@RequiresApi(api = Build.VERSION_CODES.M)
class FirebaseMessageService : FirebaseMessagingService() {
    override fun onNewToken(s: String) {
        super.onNewToken(s)
        Log.e("NEW_TOKEN", s)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.e("TAG", "notif " + remoteMessage.notification!!.title)
        val title = remoteMessage.notification!!.title
        val body = remoteMessage.notification!!.body
        NotificationManagers(this).displayNotification(
                title,
                body,
                remoteMessage.data["url"]
        )
        if (remoteMessage.data.size > 0) {
            Log.e("TAG", "notif " + remoteMessage.notification!!.body)

        }

    }


    companion object {
        private const val TAG = "FCM Service"
    }
}