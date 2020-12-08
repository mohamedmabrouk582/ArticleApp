package com.example.articlesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val id:Long,
    val title:String,
    val byline:String?,
    val abstract:String?,
    val url:String?,
    val published_date:String?,
    val section:String?,
    val subsection:String?,
    val uri:String,
    val adx_keywords:String?,
    val media:ArrayList<Media>
) : Parcelable{
    val mediaDetail:MediaDetails
    get() {
        return media[0].mediaDetails[2]
    }

}