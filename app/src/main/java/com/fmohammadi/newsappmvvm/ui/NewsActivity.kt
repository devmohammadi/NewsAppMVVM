package com.fmohammadi.newsappmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.fmohammadi.newsappmvvm.R
import com.fmohammadi.newsappmvvm.db.ArticleDatabase
import com.fmohammadi.newsappmvvm.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModels: NewsViewModels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelsProviderFactory = NewsViewModelsProviderFactory(application , newsRepository)
        viewModels = ViewModelProvider(this , viewModelsProviderFactory).get(NewsViewModels::class.java)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}