package com.example.articlesapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Media(
    val type:String?,
    @SerializedName("media-metadata")
    val mediaDetails:ArrayList<MediaDetails>
) : Parcelable