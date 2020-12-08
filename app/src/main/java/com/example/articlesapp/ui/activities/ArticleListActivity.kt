package com.example.articlesapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.articlesapp.R
import com.example.articlesapp.callBacks.ArticlesCallBack
import com.example.articlesapp.data.model.Article
import com.example.articlesapp.databinding.ArticlesListLayoutBinding
import com.example.articlesapp.ui.adapter.ArticlesAdapter
import com.example.articlesapp.viewModels.ArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListActivity : AppCompatActivity() , ArticlesCallBack , ArticlesAdapter.ArticlesListener {
    lateinit var layoutBinding: ArticlesListLayoutBinding
    val viewModel: ArticlesViewModel<ArticlesCallBack> by viewModels()
    val adapter: ArticlesAdapter by lazy {
        ArticlesAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding=DataBindingUtil.setContentView(this, R.layout.articles_list_layout)
        viewModel.attachView(this)
        layoutBinding.articlesRcv.adapter=adapter
        layoutBinding.articleVm=viewModel
        viewModel.loadArticles()
    }

    override fun onArticleClick(item: Article) {
     ArticleDetailsActivity.start(this,article = item)
    }

    override fun getAllArticles(data: ArrayList<Article>) {
        adapter.data=data
    }
}