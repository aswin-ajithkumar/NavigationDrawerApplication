package com.example.navigationdrawerapplication.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.navigationdrawerapplication.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun StaggeredGridPage() {
    val imageUrls = listOf(
        "https://picsum.photos/500",
        "https://unsplash.com/photos/a-man-standing-on-top-of-a-mountain-next-to-a-lake-BcWAKeBRbvE",
        "https://unsplash.com/photos/a-black-and-white-photo-of-a-mountain-stream-TTg-UshvC4A",
        "https://unsplash.com/photos/a-person-sitting-on-a-dock-holding-a-fishing-pole-kSwpHS9rEYs",
        "https://unsplash.com/photos/a-train-is-coming-out-of-a-tunnel-xW4MBv18vS4",
        "https://unsplash.com/photos/a-train-traveling-through-a-tunnel-at-night-E7cdy9_T1FA",
    )

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2), // 2 columns
        modifier = Modifier.fillMaxSize(),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imageUrls.size) { index ->
//            Image(
//                painter = rememberImagePainter(imageUrls[index]),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height((100..300).random().dp),
//                contentScale = ContentScale.Crop
//            )

            GlideImage(
                contentScale = ContentScale.FillBounds,
                model = imageUrls[index],
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier
                    .clickable(onClick = {

                    })
                    .background(Color.LightGray)
                    .size(300.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStaggeredGrid() {
    StaggeredGridPage()
}