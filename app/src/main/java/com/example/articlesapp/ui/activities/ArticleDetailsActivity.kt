package com.example.articlesapp.ui.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.articlesapp.R
import com.example.articlesapp.data.model.Article
import com.example.articlesapp.databinding.ArticleDetailsLayoutBinding
import com.example.articlesapp.utils.ARTICLE

class ArticleDetailsActivity : AppCompatActivity() {
    lateinit var layoutBinding: ArticleDetailsLayoutBinding
    var article:Article?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding=DataBindingUtil.setContentView(this, R.layout.article_details_layout)
         article = intent.getParcelableExtra<Article>(ARTICLE)
        article?.let {
            layoutBinding.articleDetails=it
        }



    }

    companion object{
        fun start(context: Context, article: Article) {
            val intent=Intent(context, ArticleDetailsActivity::class.java)
            intent.putExtra(ARTICLE, article)
            context.startActivity(intent)
        }
    }

    fun back(view: View) {
        finish()
    }

    fun openLink(view: View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(article?.url)
        startActivity(intent)
    }

}