package com.example.instagramrepilca.model

data class Post(
    val userImageResId: Int,
    val username: String,
    val postImageResId: Int,
    val likesCount: Int,
    val caption: String
)
