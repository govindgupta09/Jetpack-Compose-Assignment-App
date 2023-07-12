package com.govi.jetpackassignment

sealed class Screen(val route : String){
    object FeedPage : Screen("feed_page")
    object CommentPage : Screen("comment_page")
}
