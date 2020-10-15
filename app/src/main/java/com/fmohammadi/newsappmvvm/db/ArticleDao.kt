package com.fmohammadi.newsappmvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fmohammadi.newsappmvvm.models.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticle(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}