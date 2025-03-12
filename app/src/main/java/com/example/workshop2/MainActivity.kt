package com.example.workshop2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.workshop2.ui.theme.Workshop2Theme

class MainActivity : ComponentActivity() {
    var message by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Workshop2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        Modifier.padding(innerPadding)
                    ) {
                        TextField(message, onValueChange = {
                            message = it
                        })
                        Button(
                            onClick = {
                                val intent = Intent(Intent.ACTION_SEND)
                                intent.putExtra(Intent.EXTRA_TEXT, message)
                                intent.setType("text/plain")
                                startActivity(intent)
                            }
                        ) {
                            Text("Send Implicit")
                        }
                        Button(
                            onClick = {
                                val intent = Intent(this@MainActivity, DisplayMessageActivity::class.java)
                                intent.putExtra(Intent.EXTRA_TEXT, message)
                                intent.setType("text/plain")
                                startActivity(intent)
                            }
                        ) {
                            Text("Send Explicit")
                        }
                        val names: List<String> = List(1000) { "Item $it" }
                        LazyColumn (modifier = Modifier.fillMaxWidth()) {
                            items(names) {

                                var expanded by remember { mutableStateOf(false)}
                                Row (modifier = Modifier.fillMaxWidth()) {
                                    Text(it + if (expanded) " More" else " Less", modifier = Modifier.weight(1.0f))
                                    Button(onClick = {
                                        expanded = !expanded
                                    }) {
                                        Text("Show " + if (expanded) "Less" else "More")
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Workshop2Theme {
        Greeting("Android")
    }
}