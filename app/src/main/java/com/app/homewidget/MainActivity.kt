package com.app.homewidget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.app.homewidget.ui.theme.HomeWidgetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeWidgetTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
    AsyncImage(
        model = "https://play-lh.googleusercontent.com/Xh_OlrdkF1UnGCnMN__4z-yXffBAEl0eUDeVDPr4UthOERV4Fll9S-TozSfnlXDFzw",
        contentDescription = "Logo"
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeWidgetTheme {
        Greeting("Android")
    }
}