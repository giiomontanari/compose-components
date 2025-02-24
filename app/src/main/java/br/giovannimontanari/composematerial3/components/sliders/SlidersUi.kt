package br.giovannimontanari.composematerial3.components.sliders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderMinimalExample() {

    var sliderPosition by remember { mutableFloatStateOf(0f) }

    val slideValue = (sliderPosition * 100).toInt()

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it }
    )
    Text(text = slideValue.toString())
}

@Composable
fun SliderAdvancedExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps = 3,
            valueRange = 0f..100f
        )
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }

    val slideStarValue = (sliderPosition.start).toInt()

    val slideEndValue = (sliderPosition.endInclusive).toInt()

    Column {
        RangeSlider(
            value = sliderPosition,
            steps = 3,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f
        )
        Text(text = "$slideStarValue .. $slideEndValue")
    }
}

@Preview
@Composable
private fun SlidersUiPreview() {

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Simples",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth()
        )

        SliderMinimalExample()

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Avançado",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth()
        )

        SliderAdvancedExample()

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Range",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth()
        )

        RangeSliderExample()

    }

}