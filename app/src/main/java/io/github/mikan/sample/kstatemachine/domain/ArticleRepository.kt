package io.github.mikan.sample.kstatemachine.domain

import io.github.mikan.sample.qiita.model.Comment
import io.github.mikan.sample.qiita.model.Item

interface ArticleRepository {
    suspend fun getArticles(): List<Item>
    suspend fun getArticle(itemId: String): Item?
    suspend fun addLike(itemId: String)
    suspend fun removeLike(itemId: String)
    suspend fun isItemStock(itemId: String): Boolean
    suspend fun isItemLiked(itemId: String): Boolean
    suspend fun getComments(itemId: String): List<Comment>
}