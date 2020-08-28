package com.calvert.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.calvert.mockdata.R

// GLide does the url null-checking and call the error/fallback drawable
fun ImageView.loadImage(url: String?, isCircle: Boolean) {
    Glide.with(context).load(url).error(R.drawable.ic_baseline_broken_image_24).fallback(R.drawable.ic_baseline_broken_image_24).apply {
        if (isCircle) circleCrop()
    }.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}