package com.calvert.notification.util

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.VISIBILITY_PRIVATE
import androidx.core.content.ContextCompat
import com.calvert.notification.R

class JetpackNotification @JvmOverloads constructor(
    private val context: Context,
    private val channelId: String,
    private val title: String? = null,
    private val contentText: String? = null,
    private val smallIcon: Int? = 0,
    private val iconLevel: Int? = 0,
    private val notificationPriority: Int = NotificationCompat.PRIORITY_HIGH,
    private val style: NotificationStyle? = null,
    private val bigPicDrawable: Int? = null,
    private val bigPicIcon: Int? = null,
    private val autoCancel: Boolean? = true,
    private val notificationColor: Int = R.color.colorAccent,
    private val summary: String? = null,
    private val pendingIntentList: Map<String, PendingIntent>? = null,
    private val notificationName: String? = null,
    private val notificationDesc: String? = null
) {
    /**
     * On Android 8.0 and higher (API level 26), register the app's notification channel with the system by passing an
     * instance of NotificationChannel to createNotificationChannel()
     *
     * A notification channel is needed before notifications can be posted. The code should be executed asap and it is
     * safe to call this repeatedly.
     */
    @SuppressLint("RestrictedApi")
    fun createNotificationChannel() {
        val builder = NotificationCompat.Builder(context, channelId).apply {
            setChannelId(channelId)

            title?.let {
                setContentTitle(it)
            }

            contentText?.let {
                setContentText(it)
            }

            smallIcon?.let { iconId ->
                iconLevel?.let {
                    setSmallIcon(iconId, iconLevel)
                }
            }

            /**
             * Set this to support Android 7.1 and lower. Higher version requires an "importance".
             */
            priority = notificationPriority

            /**
             * Notification text content is truncated to fit one line. To enable longer notification, enable expandable notification
             * by adding a style template.
             */
            style?.let {
                when (it) {
                    NotificationStyle.BIG_PICTURE_STYLE -> setStyle(bigPicStyle())
                    NotificationStyle.BIG_TEXT_STYLE -> setStyle(bigTextStyle())
                }
            }

            autoCancel?.let { setAutoCancel(it) }

            setColorized(true)
            color = ContextCompat.getColor(context, notificationColor)

            // max 3 actions
            pendingIntentList?.forEach {
                val action: NotificationCompat.Action = NotificationCompat.Action.Builder(0, it.key, it.value).build()
                addAction(action)
            }

            pendingIntentList?.let{
                setContentIntent(it.get("Action 1"))
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = notificationName
            val descriptionText = notificationDesc

            /**
             * Although this has been set, it doesn't guarantee the alert behavior and the system could override it based on other factors
             */
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
                canShowBadge()
            }
            // register the channel with the system
            val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(0, builder.build())
        }
    }

    private fun bigPicStyle(): NotificationCompat.Style? {
        val bigPic = bigPicDrawable?.let {
            BitmapFactory.decodeResource(
                context.resources,
                it
            )
        }

        val bigIcon: Bitmap? = bigPicIcon?.let {
            BitmapFactory.decodeResource(
                context.resources,
                it
            )
        }

        return NotificationCompat.BigPictureStyle()
            .bigPicture(bigPic)
            .bigLargeIcon(bigIcon)
    }

    /**
     * Enable multi-lines descriptions in the notification
     */
    private fun bigTextStyle(): NotificationCompat.Style? {
        return NotificationCompat.BigTextStyle()
            .bigText(contentText)
            .setBigContentTitle(title)
            .setSummaryText(summary)
    }

    enum class NotificationStyle {
        BIG_TEXT_STYLE,
        BIG_PICTURE_STYLE
    }
}