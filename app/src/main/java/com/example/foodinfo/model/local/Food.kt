package com.example.foodinfo.model.local

import android.graphics.drawable.Drawable

data class Food(
    val calories: Int,
    val previewURL: String,
    val protein: Int,
    val fat: Int,
    val carb: Int,
    var preview: Drawable?
)