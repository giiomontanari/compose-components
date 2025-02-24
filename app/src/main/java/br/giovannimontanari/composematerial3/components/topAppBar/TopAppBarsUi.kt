package br.giovannimontanari.composematerial3.components.topAppBar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarUi(
    title: String,
    modifier: Modifier = Modifier,
    centerAligned: Boolean = false,
    onClick: () -> Unit,
    menuOnClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = if (centerAligned) {
                    TextAlign.Center
                } else {
                    TextAlign.Start
                }
            )
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onClick, content = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            })
        },
        actions = {
            IconButton(onClick = menuOnClick, content = {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            })
        }
    )

    TopAppBar(
        title = {
            Text(title)
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onClick, content = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            })
        },
        actions = {
            IconButton(onClick = menuOnClick, content = {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarsUiPreview(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBarUi("Login", centerAligned = true, onClick = {}, menuOnClick = {}) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

            }
        }
    )
}