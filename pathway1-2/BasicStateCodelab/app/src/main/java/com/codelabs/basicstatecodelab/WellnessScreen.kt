package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        WhiskeyCounter(
            onAddClose = {
                viewModel.add(WellnessTask.DEFAULT)
            },
            onResetClose = {
                viewModel.clear()
            }
        )
        if (viewModel.tasks.isNotEmpty()) {
            WellnessTaskList(
                list = viewModel.tasks,
                onClose = { index ->
                    viewModel.remove(index)
                }
            )
        }
    }
}