package com.codelab.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyCollapsable(
                    modifier = Modifier.fillMaxSize(),
                    data = List(1000) { "$it" }
                )
            }
        }
    }
}

@Composable
private fun MyCollapsable(
    modifier: Modifier = Modifier,
    data: List<String> = emptyList()
) {
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface(modifier = modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            LazyColumn(modifier = modifier.padding(4.dp)) {
                items(items = data) { data ->
                    Greeting("$data!!!")
                }
            }
        }
    }
}

@Composable
private fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the REAL WORLD!")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Composable
private fun Greeting(name: String) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            val expanded = remember { mutableStateOf(false) }
            val extraPadding = if (expanded.value) 48.dp else 0.dp
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(
                    text = "Hello, ",
                    color = Color.White
                )
                Text(
                    text = name,
                    color = Color.Yellow,
                    fontWeight = FontWeight.Bold
                )
            }
            OutlinedButton(
                modifier = Modifier.defaultMinSize(minWidth = 130.dp),
                shape = MaterialTheme.shapes.large,
                onClick = { expanded.value = !expanded.value }
            ) {
                val text = if (expanded.value) "Show LESS" else "Show MORE"
                Text(text)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    BasicsCodelabTheme {
        OnboardingScreen(onContinueClicked = { /*Nothing to do*/ })
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    BasicsCodelabTheme {
        Greeting("Android")
    }
}