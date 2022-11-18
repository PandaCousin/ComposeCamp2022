package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    message: String,
    isChecked: Boolean? = null,
    onCheckedChange: (Boolean) -> Unit = {},
    onClose: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = message
        )
        if (isChecked != null) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = onCheckedChange
            )
        }
        IconButton(
            onClick = onClose
        ) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}
