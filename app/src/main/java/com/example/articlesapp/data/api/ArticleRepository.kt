package com.example.articlesapp.data.api

import android.content.Context
import com.example.articlesapp.data.model.ArticleResponse
import com.example.articlesapp.utils.network.RequestCoroutines
import com.example.articlesapp.utils.network.RequestListener
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ArticleRepository @Inject constructor(val api: ArticlesApi, @ApplicationContext val context: Context) : RequestCoroutines {

    suspend fun getArticles(listener: RequestListener<ArticleResponse>) = api.getArticles().handelEx(context,listener)

}