/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults.elevation
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.MySootheRepository
import com.example.androiddevchallenge.ui.components.CircleItemList
import com.example.androiddevchallenge.ui.components.DoubleCardItemList
import com.example.androiddevchallenge.ui.components.EditText
import com.example.androiddevchallenge.ui.theme.typography
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import java.util.Locale

private enum class HomeTab(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    Home(R.string.home_tab, Icons.Default.Spa),
    Account(R.string.profile_tab, Icons.Default.AccountCircle)
}

@Composable
fun HomeScreen() {
    val (selectedTab, onTabSelect) = remember { mutableStateOf(HomeTab.Home) }
    val tabs = HomeTab.values().toList()
    Scaffold(
        modifier = Modifier.padding(top = 56.dp),
        bottomBar = { HomeBottomBar(tabs, selectedTab, onTabSelect) },
        floatingActionButton = {
            FloatingActionButton(
                elevation = elevation(0.dp, 0.dp),
                backgroundColor = MaterialTheme.colors.primary,
                onClick = { }
            ) { Icon(Icons.Default.PlayArrow, null) }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        backgroundColor = MaterialTheme.colors.background
    ) { innerPadding ->
        HomeTabContent(Modifier.padding(innerPadding))
    }
}

@Composable
private fun HomeBottomBar(
    tabs: List<HomeTab>,
    selectedTab: HomeTab,
    onTabSelect: (HomeTab) -> Unit
) {
    BottomNavigation(
        modifier = Modifier.navigationBarsHeight(56.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                modifier = Modifier.navigationBarsPadding(),
                icon = { Icon(tab.icon, null, Modifier.size(18.dp)) },
                label = {
                    Text(
                        text = stringResource(tab.title).toUpperCase(Locale.getDefault()),
                        style = typography.h2
                    )
                },
                selected = tab == selectedTab,
                onClick = { onTabSelect(tab) }
            )
        }
    }
}

@Composable
fun HomeTabContent(modifier: Modifier = Modifier) {
    val scrollableState = rememberScrollState()
    val (searchKey, setSearchKey) = remember { mutableStateOf("") }
    Column(modifier.scrollable(scrollableState, Orientation.Vertical)) {

        EditText(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            value = searchKey,
            onValueChange = setSearchKey,
            placeholderText = R.string.search,
            leadingIcon = Icons.Default.Search
        )

        SectionTitle(R.string.favorite_collections)
        Spacer(Modifier.size(8.dp))
        DoubleCardItemList(MySootheRepository.favoriteCollectionItems)

        SectionTitle(R.string.align_your_body)
        Spacer(Modifier.size(8.dp))
        CircleItemList(MySootheRepository.alignYourBodyItems)

        SectionTitle(R.string.align_your_mind)
        Spacer(Modifier.size(8.dp))
        CircleItemList(MySootheRepository.alignYourMindItems)
    }
}

@Composable
fun SectionTitle(@StringRes title: Int) =
    Text(
        text = stringResource(title).toUpperCase(Locale.getDefault()),
        modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 8.dp).padding(start = 16.dp),
        color = MaterialTheme.colors.onBackground,
        style = typography.h2
    )
