package com.example.navigationdrawerapplication.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.*

@Composable
fun BottomSheetContent(
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Expanded Bottom",
            fontSize = 30.sp
        )
        Button(onClick = onClick) {
            Text("Hide bottom sheet")
        }
    }

}