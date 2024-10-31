package com.example.textfieldedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textfieldedu.ui.theme.TextFieldEduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextFieldEduTheme {
                Basic()
            }
        }
    }
}

@Composable
fun Basic(modifier: Modifier = Modifier){
    var text by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    Box {
        TextField(
            value = "코딩일기 구독 좋아요 알림설정 부탁드립니다~",
            onValueChange = {text = it},
            label = {
                Text(
                    text = "Basic"
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            modifier = modifier.fillMaxWidth().padding(10.dp)
        )
    }
}

@Composable
fun Outlined(modifier: Modifier = Modifier){
    var text by remember { mutableStateOf("") }
    Box {
        OutlinedTextField(
            value = "코딩일기 구독 좋아요 알림설정 부탁드립니다~",
            onValueChange = {text = it},
            label = {
                Text(
                    text = "Outlined"
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Red
            ),
            modifier = modifier.fillMaxWidth().padding(10.dp)
        )
    }
}

@Composable
fun Brush(modifier: Modifier = Modifier){
    val rainbowColors: List<Color> = listOf(Color.Red, Color.Yellow, Color.Green, Color.Blue)
    var text by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }
    TextField(
        value = "코딩일기 구독 좋아요 알림설정 부탁드립니다~",
        onValueChange = {text = it},
        label = {
            Text(
                text = "Basic"
            )
        },
        textStyle = TextStyle(brush),
        modifier = modifier.fillMaxWidth().padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun BasicPreview() {
    TextFieldEduTheme {
        Basic()
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedPreview() {
    TextFieldEduTheme {
        Outlined()
    }
}

@Preview(showBackground = true)
@Composable
fun BrushPreview() {
    TextFieldEduTheme {
        Brush()
    }
}