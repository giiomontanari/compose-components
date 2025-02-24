package br.giovannimontanari.composematerial3.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.giovannimontanari.composematerial3.components.divider.HorizontalDividerUi
import br.giovannimontanari.composematerial3.components.divider.VerticalDividerUi

@Composable
fun CardUi(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray.copy(alpha = 0.5f))
                        .height(200.dp)
                )

                Text(
                    text = "titulo do card",
                    modifier = Modifier.padding(vertical = 16.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                HorizontalDividerUi()

                Text(
                    text = "Descrição do nosso card. Descrição do nosso card. Descrição do nosso card. Descrição do nosso card",
                    modifier = Modifier.padding(vertical = 16.dp),
                    fontSize = 16.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.End),
                    content = {
                        Text(text = "Detalhes")
                    })
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun CardUiPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardUi(
            onClick = {}
        )
    }
}