package com.example.articlesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MediaDetails(
    val url:String?,
    val format:String?,
    val height:Int,
    val width:Int
) : Parcelable