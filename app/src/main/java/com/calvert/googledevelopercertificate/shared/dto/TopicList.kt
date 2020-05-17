package com.calvert.googledevelopercertificate.shared.dto

import com.calvert.googledevelopercertificate.R

val TOPIC_LIST: List<TopicObject> = listOf(
    TopicObject(
        "Toast",
        listOf("The Basics", "Positioning your Toast", "Creating a Custom Toast View"),
        listOf(R.id.action_goto_donate, R.id.action_goto_donate, R.id.action_goto_donate)
    ),
    TopicObject(
        "Snackbar",
        listOf(""),
        listOf(0)
    )
)