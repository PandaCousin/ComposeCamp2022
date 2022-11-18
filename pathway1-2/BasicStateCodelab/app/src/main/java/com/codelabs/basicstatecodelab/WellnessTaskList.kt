package com.codelabs.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onClose: (Int)->Unit = {}
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(list) { index, task ->
            WellnessTaskItem(
                message = "${index+1}번째 빈 잔!!",
                onClose = {
                    onClose(task.id)
                }
            )
        }
    }
}
