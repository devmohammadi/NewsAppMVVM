package com.fmohammadi.newsappmvvm.ui.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.fmohammadi.newsappmvvm.R
import com.fmohammadi.newsappmvvm.ui.NewsActivity
import com.fmohammadi.newsappmvvm.ui.NewsViewModels
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment :Fragment(R.layout.fragment_article) {

    lateinit var viewModels: NewsViewModels
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModels = (activity as NewsActivity).viewModels

        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url!!)
        }

        fab.setOnClickListener {
            viewModels.saveArticle(article)
            Snackbar.make(view , "Article Saved Successfully" , Snackbar.LENGTH_SHORT)
        }
    }
}