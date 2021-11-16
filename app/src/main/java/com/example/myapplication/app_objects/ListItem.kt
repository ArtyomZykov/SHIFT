package com.example.myapplication.app_objects

sealed class ListItem

data class StudentItem(
    val name: String,
    val secondName: String,
    val description: String,
    val hasPortfolio: Boolean,
) : ListItem()

data class BannerItem(
    val title: String,
    val description: String,
) : ListItem()

