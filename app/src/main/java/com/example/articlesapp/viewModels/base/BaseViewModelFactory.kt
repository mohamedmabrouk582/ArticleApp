package com.example.articlesapp.viewModels.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articlesapp.callBacks.ArticlesCallBack
import com.example.articlesapp.data.api.ArticleRepository
import com.example.articlesapp.viewModels.ArticlesViewModel
import dagger.hilt.android.qualifiers.ApplicationContext

class BaseViewModelFactory(private val application: Application, @ApplicationContext val context: Context, val articleRepository: ArticleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticlesViewModel::class.java)){
            return ArticlesViewModel<ArticlesCallBack>(application,articleRepository) as T
        }
        throw Exception("this View Model not found ")
    }
}