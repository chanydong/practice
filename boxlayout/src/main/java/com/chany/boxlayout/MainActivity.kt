package com.chany.boxlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chany.boxlayout.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    val height = 200.dp
    val width = 200.dp

    Column() {
        Box(contentAlignment = Alignment.TopStart,
            modifier = Modifier.size(400.dp, 400.dp)) {
            TextCall(text = "1",Modifier.size(width, height))
            TextCall(text = "2",Modifier.size(width, height))
            TextCall(text = "3",Modifier.size(width, height))
        }
        Row() {
            Box(modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Blue))

            Box(modifier = Modifier.size(200.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.Cyan))
        }

    }

}

@Composable
fun TextCall(text: String, modifier: Modifier = Modifier, fontSize: Int = 150) {

    val cellModifier = Modifier
        .padding(4.dp)
        .border(width = 5.dp, color = Color.Black)

    Text(text = text,
        cellModifier.then(modifier),
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center)
}