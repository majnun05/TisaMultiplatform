package com.badista.tisakmp.android.ui.bottom_navigation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.badista.tisakmp.android.R
import com.badista.tisakmp.android.common.theming.MainColor
import com.badista.tisakmp.android.common.theming.MavenBold
import com.badista.tisakmp.android.navigation.Screen
import com.badista.tisakmp.android.ui.home.HomeScreen
import com.badista.tisakmp.android.ui.partners.PartnersScreen
import com.badista.tisakmp.android.ui.profile.ProfileScreen
import com.badista.tisakmp.android.ui.visits.VisitsScreen

@Composable
fun HomeNavigationScreen() {
    MyBottomAppBar()
}

@Composable
fun MyBottomAppBar() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val iconHome = Icons.Default.Home
    val iconVisit = Icons.Default.Place
    val iconPartners = Icons.Default.List
    val iconProfile = Icons.Default.AccountCircle
    val selected = remember {
        mutableStateOf(iconHome)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White
            ) {
                IconButton(
                    onClick = {
                        selected.value = iconHome
                        navigationController.navigate(Screen.Home.route) { popUpTo(0)}
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = if (selected.value == iconHome){
                                painterResource(id = R.drawable.ic_asset_tab_home_active)
                            } else {
                                painterResource(id = R.drawable.ic_asset_tab_home)
                            },
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == iconHome) MainColor else Color.DarkGray
                        )

                        if (selected.value == iconHome) {
                            Text(
                                text = "Home",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = MavenBold,
                                    color = if (selected.value == iconHome) MainColor else Color.DarkGray
                                )
                            )
                        } else {
                            null
                        }
                    }
                }

                IconButton(
                    onClick = {
                        selected.value = iconVisit
                        navigationController.navigate(Screen.Visits.route) { popUpTo(0)}
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = if (selected.value == iconVisit){
                                painterResource(id = R.drawable.ic_asset_tab_visits_active)
                            } else {
                                painterResource(id = R.drawable.ic_asset_tab_visits)
                            },
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == iconVisit) MainColor else Color.DarkGray
                        )

                        if (selected.value == iconVisit) {
                            Text(
                                text = "Visits",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = MavenBold,
                                    color = if (selected.value == iconVisit) MainColor else Color.DarkGray
                                )
                            )
                        } else {
                            null
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f),
                    contentAlignment = Alignment.TopCenter
                ) {
                    FloatingActionButton(
                        onClick = { Toast.makeText(context, "Open Bottom Sheet", Toast.LENGTH_SHORT).show() },
                        shape = RoundedCornerShape(30.dp),
                        containerColor = MainColor
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
                    }
                }

                IconButton(
                    onClick = {
                        selected.value = iconPartners
                        navigationController.navigate(Screen.Partners.route) { popUpTo(0)}
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = if (selected.value == iconPartners){
                                painterResource(id = R.drawable.ic_asset_tab_partners_active)
                            } else {
                                painterResource(id = R.drawable.ic_asset_tab_partners)
                            },
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == iconPartners) MainColor else Color.DarkGray
                        )

                        if (selected.value == iconPartners) {
                            Text(
                                text = "Data Outlet",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = MavenBold,
                                    color = if (selected.value == iconPartners) MainColor else Color.DarkGray
                                )
                            )
                        } else {
                            null
                        }
                    }
                }

                IconButton(
                    onClick = {
                        selected.value = iconProfile
                        navigationController.navigate(Screen.Profile.route) { popUpTo(0)}
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = if (selected.value == iconProfile){
                                painterResource(id = R.drawable.ic_asset_tab_profile_active)
                            } else {
                                painterResource(id = R.drawable.ic_asset_tab_profile)
                            },
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == iconProfile) MainColor else Color.DarkGray
                        )

                        if (selected.value == iconProfile) {
                            Text(
                                text = "Profile",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = MavenBold,
                                    color = if (selected.value == iconProfile) MainColor else Color.DarkGray
                                )
                            )
                        } else {
                            null
                        }
                    }
                }

            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Visits.route) { VisitsScreen() }
            composable(Screen.Partners.route) { PartnersScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNavigationScreen() {
    HomeNavigationScreen()
}