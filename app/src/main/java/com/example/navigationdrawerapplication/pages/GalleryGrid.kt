package com.example.navigationdrawerapplication.pages

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationdrawerapplication.R

@Composable
fun GalleryGrid(navController: NavController) {
    Scaffold() { innerPadding ->
        val orientation = LocalConfiguration.current
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            when (orientation.orientation) {
                Configuration.ORIENTATION_PORTRAIT ->
                    HeaderPortrait(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Cyan)
                    )
                else ->
                    HeaderLandscape(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Cyan)
                    )
            }
            Spacer(modifier = Modifier.height(12.dp))
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 130.dp),
                modifier = Modifier.padding(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) { items(30) { HeaderPortrait() } }
        }
    }
}

@Composable
private fun HeaderPortrait(
    category: String? = "Apple",
    modifier: Modifier = Modifier,
    weight: Float? = 1f
) {
    Row(modifier = modifier) {
        Column(modifier = Modifier.weight(weight!!).padding(16.dp,48.dp,16.dp,0.dp)) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "",
                modifier = Modifier.padding(start = 6.dp),
            )
            Text(text = category!!)
            Button(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.round_add_24),
                    contentDescription = "",
                )
                Text(text = "Subscribe")
            }
        }
    }
}

@Composable
private fun HeaderLandscape(
    category: String? = "Apple",
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(top = 48.dp, start = 16.dp, end = 16.dp)) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "",
            modifier = Modifier.align(CenterVertically),
        )
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = category!!,)
            Button(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.round_add_24),
                    contentDescription = "",
                )
                Text(text = "Subscribe")
            }
        }
    }
}