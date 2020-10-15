package com.fmohammadi.newsappmvvm.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fmohammadi.newsappmvvm.repository.NewsRepository

@Suppress("UNCHECKED_CAST")
class NewsViewModelsProviderFactory(
    val app: Application,
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModels(app, newsRepository) as T
    }
}