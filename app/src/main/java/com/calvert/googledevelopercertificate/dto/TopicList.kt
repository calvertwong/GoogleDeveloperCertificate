package com.calvert.googledevelopercertificate.dto

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
    ),
    TopicObject(
        "RecyclerView",
        listOf("Vertical", "Horizontal", "Grid", "Staggered Grid"),
        listOf(
            R.id.action_goto_vertical_landingpage_recyclerview,
            R.id.action_goto_horizontal_recyclerview,
            R.id.action_goto_grid_recyclerview,
            R.id.action_goto_staggered_grid_recyclerview
        )
    ),
    TopicObject(
        "Custom View",
        listOf("Speed Controller", "Light Bulb"),
        listOf(
            R.id.action_goto_custom_view_speed_controller,
            R.id.action_goto_custom_view_light_bulb
        )
    )
)