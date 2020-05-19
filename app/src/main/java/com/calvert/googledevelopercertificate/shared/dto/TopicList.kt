package com.calvert.googledevelopercertificate.shared.dto

import com.calvert.googledevelopercertificate.R

val TOPIC_LIST: List<TopicObject> = listOf(
    TopicObject(
        "Toast",
        listOf("The Basics", "Positioning your Toast", "Creating a Custom Toast View"),
        listOf(
            R.id.action_goto_basic_toast,
            R.id.action_goto_positioning_your_toast,
            R.id.action_goto_custom_toast
        )
    ),
    TopicObject(
        "View Binding",
        listOf("Basic Demo"),
        listOf(
            R.id.action_goto_view_binding
        )
    ),
    TopicObject(
        "Constraint Layout",
        listOf("Barrier", "Chain", "Keyframe Animation"),
        listOf(
            R.id.action_goto_barrier,
            R.id.action_goto_chain,
            R.id.action_goto_keyframe_animation
        )
    )
)