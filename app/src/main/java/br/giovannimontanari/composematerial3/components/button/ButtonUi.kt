package br.giovannimontanari.composematerial3.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    outlined: Boolean = false,
    onclick: () -> Unit
) {

    if(outlined) {
        OutlinedButton(modifier = modifier,
            enabled = enabled,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0XFFF44336),
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color(0xFFFD928A)
            ),
            border = if (enabled) {
                BorderStroke(1.dp, Color(0XFFF44336))
            } else {
                BorderStroke(1.dp, Color(0xFFFD928A))
            },
            content = {
                Text(text = text)
            },
            onClick = { /*TODO*/ }
        )
    } else {
        Button(modifier = modifier,
            enabled = enabled,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFFF44336),
                contentColor = Color.White,
                disabledContainerColor = Color(0xFFFD928A),
                disabledContentColor = Color.White.copy(alpha = 0.6f)
            ),
            content = {
                Text(text = text)
            },
            onClick = { /*TODO*/ }
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun ButtonUiPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleButton(
            "Login",
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            onclick = {}
        )

        Spacer(modifier = Modifier.height(24.dp))

        SimpleButton(
            "Login",
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            outlined = true,
            onclick = {}
        )
    }
}