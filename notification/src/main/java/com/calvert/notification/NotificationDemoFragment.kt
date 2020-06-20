package com.calvert.notification

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.calvert.notification.databinding.FragmentNotificationDemoBinding
import com.calvert.notification.util.JetpackNotification
import com.calvert.notification.util.JetpackNotification.NotificationStyle

class NotificationDemoFragment : Fragment() {

    private var _binding: FragmentNotificationDemoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentNotificationDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNormalNotification.setOnClickListener {
            JetpackNotification(
                requireContext(),
                "normal notification",
                "Normal notification",
                "Basic notification with minimum views.",
                R.drawable.ic_baseline_notifications_24,
                notificationName = "Bit Text",
                notificationDesc = "Low"
            ).createNotificationChannel()
        }

        binding.btnBigPicNotification.setOnClickListener {
            JetpackNotification(
                requireContext(),
                "big picture notification",
                "Big picture notification",
                "Notification with an image.",
                R.drawable.ic_baseline_notifications_24,
                style = JetpackNotification.NotificationStyle.BIG_PICTURE_STYLE,
                bigPicDrawable = R.drawable.ic_wallpaper,
                bigPicIcon = R.drawable.ic_wallpaper,
                notificationColor = R.color.colorPrimaryDark,
                notificationName = "Big Picture",
                notificationDesc = "Low"
            ).createNotificationChannel()
        }

        val firstIntent = Intent(requireContext(), requireActivity()::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val firstPendingIntent: PendingIntent = PendingIntent.getActivity(requireContext(), 0, firstIntent, 0)

        val secondIntent = Intent(requireContext(), requireActivity()::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val secondPendingIntent: PendingIntent = PendingIntent.getActivity(requireContext(), 0, secondIntent, 0)

        val thirdIntent = Intent(requireContext(), requireActivity()::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val thirdPendingIntent: PendingIntent = PendingIntent.getActivity(requireContext(), 0, thirdIntent, 0)

        binding.btnBigTextNotification.setOnClickListener {
            JetpackNotification(
                requireContext(),
                "big text notification",
                "Big text notification",
                "Notification with big texts.",
                R.drawable.ic_baseline_notifications_24,
                style = NotificationStyle.BIG_TEXT_STYLE,
                notificationColor = R.color.colorPrimaryDark,
                notificationName = "Bit Text",
                notificationDesc = "High",
                pendingIntentList = mapOf<String, PendingIntent>("Action 1" to firstPendingIntent, "Action 2" to secondPendingIntent, "Action 3" to thirdPendingIntent)
            ).createNotificationChannel()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}