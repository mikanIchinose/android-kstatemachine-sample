package io.github.mikan.sample.kstatemachine.data

import io.github.mikan.sample.kstatemachine.domain.ArticleRepository
import io.github.mikan.sample.qiita.model.Comment
import io.github.mikan.sample.qiita.model.Item
import io.github.mikan.sample.qiita.remote.UserApi

class ArticleRepositoryImpl(
    private val userApi: UserApi
) : ArticleRepository {
    private var items = emptyList<Item>()
    override suspend fun getArticles(): List<Item> {
        if (items.isNotEmpty()) return items
        items = userApi.getItems(perPage = 10).body()
        return items
    }

    override suspend fun getArticle(itemId: String): Item? {
        val item = userApi.getItem(itemId).body()
        return item
    }

    override suspend fun addLike(itemId: String) {
        userApi.createItemLike(itemId)
    }

    override suspend fun removeLike(itemId: String) {
        userApi.deleteItemLike(itemId)
    }

    override suspend fun isItemStock(itemId: String): Boolean {
        return userApi.isItemStock(itemId).success
    }

    override suspend fun isItemLiked(itemId: String): Boolean {
        return userApi.isItemLike(itemId).success
    }

    override suspend fun getComments(itemId: String): List<Comment> {
        val comments = userApi.getItemComments(itemId).body()
        return comments
    }
}