package com.example.articlesapp.utils

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DataBindAdapterUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("app:loadImage")
        fun loadImages(view: ImageView, url: String?) {
            url?.apply {
                Glide.with(view)
                    .load(url)
                    .into(view)




            }
        }


        @JvmStatic
        @BindingAdapter("app:loadImageResource")
        fun loadImage(view: ImageView, resource: Int) {
            view.setImageResource(resource)
        }
    }
}
