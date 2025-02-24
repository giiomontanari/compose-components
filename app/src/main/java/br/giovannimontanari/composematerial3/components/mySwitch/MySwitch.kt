package br.giovannimontanari.composematerial3.components.myRadioButton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MySwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                    tint = Color.Black
                )
            }
        } else {
            null
        },
        colors = SwitchDefaults.colors(
            uncheckedIconColor = Color(0xFF16603e),
            checkedIconColor = Color(0xFFd9fdd3),
            uncheckedThumbColor = Color(0xFF16603e),
            checkedThumbColor = Color(0xFFd9fdd3),
            checkedTrackColor = Color(0xFF16603e),
            uncheckedTrackColor = Color(0xFFd9fdd3)

        )
    )
}

@Preview(showBackground = true)
@Composable
private fun MySwitchUiPreview() {

    val options = listOf(1, 2, 3)

    var switchState by remember {
        mutableIntStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        options.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                MySwitch(
                    checked = item == switchState,
                    onCheckedChange = {
                        switchState = item
                    }
                )
                Text("Opção: $item")
            }
        }
    }
}