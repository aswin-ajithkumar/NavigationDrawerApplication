package com.example.navigationdrawerapplication.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.*
import com.example.navigationdrawerapplication.R

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun StaggeredGridPage(navController: NavHostController) {
    val imageUrls = listOf(
        "https://picsum.photos/500?grayscale",
        "https://picsum.photos/id/237/200/300",
        "https://picsum.photos/seed/picsum/200/300",
        "https://picsum.photos/id/237/200/300",
        "https://picsum.photos/500?grayscale",
        "https://picsum.photos/seed/picsum/200/300",
        "https://picsum.photos/500?blur",
        "https://picsum.photos/500?grayscale&blur=2",
        "https://picsum.photos/500?grayscale",
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Staggered Grid")},
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ){innerPaddings->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(150.dp),
            modifier = Modifier.fillMaxSize().padding(innerPaddings),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(imageUrls.size) { index ->
                GlideImage(
                    contentScale = ContentScale.FillBounds,
                    model = imageUrls[index],
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier.clickable(onClick = {}).background(Color.LightGray)
                )
            }
        }
    }
}