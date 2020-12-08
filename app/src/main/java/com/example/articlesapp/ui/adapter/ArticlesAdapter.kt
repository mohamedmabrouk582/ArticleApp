package com.example.articlesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.articlesapp.R
import com.example.articlesapp.data.model.Article
import com.example.articlesapp.databinding.ArticleItemViewBinding

class ArticlesAdapter(val listener: ArticlesListener) : RecyclerView.Adapter<ArticlesAdapter.Holder>() {
    var data:ArrayList<Article> = ArrayList()
    set(value) {
        field=value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflate = DataBindingUtil.inflate<ArticleItemViewBinding>(LayoutInflater.from(parent.context), R.layout.article_item_view, parent, false)
        return Holder(inflate)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        data[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = data.size

    inner class Holder(private val itemViewBinding: ArticleItemViewBinding) : RecyclerView.ViewHolder(itemViewBinding.root){

        fun bind(item:Article){
            itemViewBinding.article=item
            itemViewBinding.executePendingBindings()
            itemViewBinding.root.setOnClickListener { listener.onArticleClick(item) }
        }
    }

    interface ArticlesListener{
        fun onArticleClick(item:Article)
    }


}