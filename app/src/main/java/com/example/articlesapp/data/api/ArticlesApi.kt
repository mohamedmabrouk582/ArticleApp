package com.example.articlesapp.data.api

import com.example.articlesapp.BuildConfig
import com.example.articlesapp.data.model.ArticleResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ArticlesApi {
    @GET("all-sections/7.json?api-key=${BuildConfig.API_KEY}")
    fun getArticles() : Deferred<ArticleResponse>
}