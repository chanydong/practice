package com.chany.animatevisibility

import android.R
import android.content.DialogInterface.OnShowListener
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chany.animatevisibility.ui.theme.PracticeTheme

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

                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    var boxVisible by remember { mutableStateOf(true) }

    val onClick = {
        newState: Boolean -> boxVisible = newState
    }

    Column(Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Crossfade(targetState = boxVisible, animationSpec = tween(5000)) {
                visible ->
                    when(visible) {
                        true -> {
                            CustomButton(text = "hide", targetState = false, onClick = onClick)
                        }
                        false -> {
                            CustomButton(text = "show", targetState = true, onClick = onClick )
                        }
                    }

            }
//            CustomButton(text = "Show", targetState = true , onClick = onClick )
//            CustomButton(text = "Hide", targetState = false , onClick = onClick )
        }

        Spacer(modifier = Modifier.height(20.dp))

        AnimatedVisibility(visible = boxVisible,
        enter = fadeIn(animationSpec = tween(durationMillis = 5500)),
        exit = fadeOut(animationSpec = tween(durationMillis = 5500))
        ) {
            Box(modifier = Modifier
                .size(200.dp, 200.dp)
                .background(Color.Blue))
        }
    }

}

@Composable
fun CustomButton(text: String, targetState: Boolean, onClick: (Boolean) -> Unit,
    bgColor: Color = Color.Blue) {

    Button(onClick = {onClick(targetState)},
        colors = ButtonDefaults.buttonColors(contentColor = Color.White)) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTest() {
    MainScreen()
}
