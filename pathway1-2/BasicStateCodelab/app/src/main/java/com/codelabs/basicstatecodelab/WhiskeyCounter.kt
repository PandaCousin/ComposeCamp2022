package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

private const val MAXIMUM_GLASSES = 20

@Composable
fun WhiskeyCounter(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel(),
    onAddClose: () -> Unit,
    onResetClose: () -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        var count = viewModel.tasks.count()
        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(message = "너 어제도 술 마셨어..") {
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
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                enabled = count < MAXIMUM_GLASSES,
                onClick = {
                    count++
                    onAddClose()
                }) {
                Text("한 잔 더!")
            }
            Button(
                modifier = Modifier.padding(start = 8.dp),
                onClick = {
                    count = 0
                    onResetClose()
                }
            ) {
                Text("컨디션/여명808!!!")
            }
        }
    }
}

