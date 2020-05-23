package com.calvert.recyclerview.verticalrecyclerview.dto

import com.calvert.recyclerview.R

val VERTICAL_ITEMS_LIST: List<VerticalItemObject> = listOf(
    VerticalItemObject(
        "Recycler View With Animated Items (Always)",
        "Items are always animated as you scroll.",
        R.id.action_goto_animate_always_recyclerview
    ),
    VerticalItemObject(
        "Recycler View With Animated Items (Once)",
        "Items are animated only once.",
        R.id.navigation_vertical_animate_once_recyclerview
    ),

    VerticalItemObject(
        "Recycler View With List Selection",
        "Long hold to enable item selection.(Basic)",
        R.id.action_goto_list_selection_recyclerview
    ),
    VerticalItemObject(
        "Recycler View With Multiple View Holder",
        "Items can be displayed with multiple view holders of different layouts.",
        R.id.action_goto_multi_views_recyclerview
    )
)