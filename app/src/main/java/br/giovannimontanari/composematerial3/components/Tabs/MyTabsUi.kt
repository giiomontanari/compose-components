package br.giovannimontanari.composematerial3.components.Tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyTabsUi(modifier: Modifier = Modifier) {

    var tabIndex by remember { mutableIntStateOf(0) }
    val pageState = rememberPagerState {
        TabNavItem.items.size
    }

    LaunchedEffect(tabIndex) {
        pageState.animateScrollToPage(tabIndex)
    }

    LaunchedEffect(pageState.currentPage) {
        tabIndex = pageState.currentPage
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            tabs = {
                TabNavItem.items.forEachIndexed { index, tab ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = {
                            Text(
                                text = stringResource(id = tab.title),
                                style = TextStyle(
                                    fontSize = 12.sp
                                ),
                            )
                        },
                        icon = {
                            Icon(
                                painter = if (tabIndex == index) {
                                    painterResource(id = tab.selectedIcon)
                                } else {
                                    painterResource(id = tab.unselectedIcon)
                                },
                                contentDescription = stringResource(id = tab.title)
                            )
                        }
                    )
                }
            }
        )

        HorizontalPager(
            state = pageState,
            modifier = Modifier.fillMaxSize(),
            pageContent = { tabPosition ->
                val tab = TabNavItem.items[tabPosition]
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = stringResource(id = tab.title))
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun MyTabsUiPreview() {
    MyTabsUi()
}