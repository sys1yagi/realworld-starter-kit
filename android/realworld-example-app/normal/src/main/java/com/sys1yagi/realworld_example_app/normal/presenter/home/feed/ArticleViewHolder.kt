package com.sys1yagi.realworld_example_app.normal.presenter.home.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sys1yagi.realworld_example_app.domain.article.Article
import com.sys1yagi.realworld_example_app.normal.R

class ArticleViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
) {

    private val nameView = itemView.findViewById<TextView>(R.id.name)
    var article: Article? = null

    fun bindTo(article: Article?) {
        this.article = article
        nameView.text = article?.title
    }
}
