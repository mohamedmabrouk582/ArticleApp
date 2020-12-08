package com.example.articlesapp.viewModels

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.example.articlesapp.callBacks.ArticlesCallBack
import com.example.articlesapp.data.api.ArticleRepository
import com.example.articlesapp.data.model.ArticleResponse
import com.example.articlesapp.utils.network.RequestListener
import com.example.articlesapp.viewModels.base.BaseViewModel
import com.mabrouk.loaderlib.RetryCallBack
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ArticlesViewModel<V : ArticlesCallBack> @ViewModelInject constructor(application: Application,val articleRepository: ArticleRepository) : BaseViewModel<V>(application)  {
    val loader:ObservableBoolean= ObservableBoolean()
    val errorMsg:ObservableField<String> = ObservableField()
    val callBack: RetryCallBack = object : RetryCallBack{
        override fun onRetry() {
          loadArticles()
        }
    }

    fun loadArticles(){
        loader.set(true)
        errorMsg.set(null)
        viewModelScope.launch {
            articleRepository.getArticles(object : RequestListener<ArticleResponse>{
                override suspend fun onResponse(data: Flow<ArticleResponse>) {
                    loader.set(false)
                    data.collect { response->
                        view.getAllArticles(response.results)
                    }
                }

                override fun onError(msg: String) {
                    loader.set(false)
                    errorMsg.set(msg)
                }

                override fun onNetWorkError(msg: String) {
                    loader.set(false)
                    errorMsg.set(msg)
                }

            })
        }
    }
}