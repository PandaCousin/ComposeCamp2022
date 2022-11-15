package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private const val MAXIMUM_GLASSES = 20

@Composable
fun WhiskeyCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(taskName = "너 어제도 술 마셨어..") {
                    showTask = false
                }
            }
        }
        Text("당신은 $count 잔의 술을 마셨습니다.")
        when (count) {
            in 10 until MAXIMUM_GLASSES -> {
                Text("취하겠어 그만 마셔...")
            }
        }
        Button(onClick = { count++ }, enabled = count < MAXIMUM_GLASSES) {
            Text("한 잔 더!")
        }
    }
}

