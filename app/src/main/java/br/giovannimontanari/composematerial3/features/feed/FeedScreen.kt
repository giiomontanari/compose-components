package br.giovannimontanari.composematerial3.features.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.giovannimontanari.composematerial3.components.dialogs.CommonDialog
import br.giovannimontanari.composematerial3.components.sheets.BottomSheetUi
import br.giovannimontanari.composematerial3.components.textField.DefaultOutlinedTextField
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen() {

    val scope = rememberCoroutineScope()

    //TextField
    var textValue by remember {
        mutableStateOf("")
    }

    //Dialog
    var openAlertDialog by remember { mutableStateOf(false) }

    //BottomSheet
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Color(0xFFd9fdd3),
        content = { contentPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("FeedScreen")
                Button(
                    onClick = { openAlertDialog = true },
                    content = {
                        Text(text = "Abrir Dialog")
                    }
                )

                DefaultOutlinedTextField(
                    modifier = Modifier.padding(32.dp),
                    value = textValue,
                    label = "Nome",
                    placeholder = "Placeholder",
                    onValueChanged = {
                        textValue = it
                    }
                )

                if (openAlertDialog) {
                    CommonDialog(
                        onDismissRequest = {
                            openAlertDialog = false
                        },
                        onConfirmation = {
                            openAlertDialog = false
                            println("Confirmation registered") // Add logic here to handle confirmation.
                        },
                        dialogTitle = "Atenção",
                        dialogText = "Estamos aprendendo sobre Material3",
                        icon = Icons.Default.Warning
                    )
                }
            }
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState,
                    content = {
                        BottomSheetUi(
                            onDismiss = {
                                scope.launch { sheetState.hide() }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        showBottomSheet = false
                                    }
                                }
                            }
                        )
                    }
                )
            }
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
    )
}

@Preview
@Composable
fun FeedScreenPreview(modifier: Modifier = Modifier) {
    FeedScreen()
}
