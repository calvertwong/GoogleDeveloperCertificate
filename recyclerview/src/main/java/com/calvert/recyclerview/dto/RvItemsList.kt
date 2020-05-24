package com.calvert.recyclerview.dto

import com.calvert.recyclerview.R

val RV_ITEMS_LIST: List<RvItemObject> = listOf(
    RvItemObject(
        "Recycler View With Animated Items (Always)",
        "Items are always animated as you scroll.",
        R.id.action_goto_animate_always_recyclerview
    ),
    RvItemObject(
        "Recycler View With Animated Items (Once)",
        "Items are animated only once.",
        R.id.navigation_vertical_animate_once_recyclerview
    ),

    RvItemObject(
        "Recycler View With List Selection",
        "Long hold to enable item selection.(Basic)",
        R.id.action_goto_list_selection_recyclerview
    ),
    RvItemObject(
        "Recycler View With Multiple View Holder",
        "Items can be displayed with multiple view holders of different layouts.",
        R.id.action_goto_multi_views_recyclerview
    )
)