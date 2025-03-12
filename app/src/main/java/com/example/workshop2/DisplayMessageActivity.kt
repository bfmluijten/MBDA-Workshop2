package com.example.workshop2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.workshop2.ui.theme.Workshop2Theme

class DisplayMessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = getIntent()
        val message = intent.getStringExtra(Intent.EXTRA_TEXT)
        enableEdgeToEdge()
        setContent {
            Workshop2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(message ?: "empty", modifier = Modifier.padding(innerPadding).fillMaxSize(), fontSize = 30.sp, textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Workshop2Theme {
        Greeting2("Android")
    }
}