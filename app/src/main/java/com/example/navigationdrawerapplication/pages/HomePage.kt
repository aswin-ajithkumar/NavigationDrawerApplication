package com.example.navigationdrawerapplication.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.example.navigationdrawerapplication.models.MenuItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var showBottomSheet by remember { mutableStateOf(false) }
    val controller = rememberNavController()

    val menuItems1 = listOf(
        MenuItem(id = "item1", title = "Item 1"),
        MenuItem(id = "item2", title = "Item 2"),
    )

    val menuItems2 = listOf(
        MenuItem(
            id = "settings",
            title = "Settings",
            icon = Icons.Outlined.Settings,
            notificationCount = 20,
            contentDesc = "Settings"
        ),
        MenuItem(
            id = "help",
            title = "Help and feedback",
            icon = Icons.AutoMirrored.Outlined.ExitToApp,
            contentDesc = "Help & Feedback"
        )
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Drawer Title",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                    HorizontalDivider()
                    menuItems1.forEach { item ->
                        NavigationDrawerItem(
                            label = { Text(item.title) },
                            selected = false,
                            icon = item.icon?.let { { Icon(it, contentDescription = item.title) } },
                            badge = item.notificationCount?.let { { Text(it.toString()) } },
                            onClick = {
                                when (item.id) {
                                    "item1" -> {
                                        scope.launch { drawerState.close() }
                                    }

                                    "item2" -> {
                                        scope.launch { drawerState.close() }
                                    }

                                    else -> Unit
                                }
                            }
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                    Text(
                        "Section 2",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                    menuItems2.forEach { item ->
                        NavigationDrawerItem(
                            label = { Text(item.title) },
                            selected = false,
                            icon = item.icon?.let { { Icon(it, contentDescription = item.title) } },
                            badge = item.notificationCount?.let { { Text(it.toString()) } },
                            onClick = {
                                when (item.id) {
                                    "settings" -> {
                                        scope.launch { drawerState.close() }
                                        navController.navigate("settings")
                                    }

                                    "help" -> {
                                        scope.launch { drawerState.close() }
                                        navController.navigate("staggered")
                                    }
                                }
                            }
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Navigation Drawer") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show bottom sheet") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        showBottomSheet = true
                    }
                )
            }
        ) { contentPadding ->
            Box(
                modifier = Modifier.padding(contentPadding)
            )
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    BottomSheetContent {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    }
                }
            }
            Box(
                modifier = Modifier.padding(contentPadding)
            ) {

            }
        }
    }
}