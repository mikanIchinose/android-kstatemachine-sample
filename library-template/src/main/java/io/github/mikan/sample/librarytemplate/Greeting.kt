package io.github.mikan.sample.librarytemplate

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greeting() {
    Text("Hello World")
}

@Preview
@Composable
private fun GreetingPreview() {
    MaterialTheme {
        Surface {
            Greeting()
        }
    }
}
