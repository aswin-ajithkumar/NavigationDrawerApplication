package com.example.navigationdrawerapplication.models

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title: String,
    val icon: ImageVector? = null,
    val notificationCount: Int? = null,
    val contentDesc: String? = null
)