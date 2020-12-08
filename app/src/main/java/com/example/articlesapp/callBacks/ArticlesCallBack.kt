package com.example.articlesapp.callBacks

import com.example.articlesapp.data.model.Article

interface ArticlesCallBack : BaseCallBack{
    fun getAllArticles(data:ArrayList<Article>)
}