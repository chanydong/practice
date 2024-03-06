package com.chany.practice

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Resources
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chany.practice.ui.theme.PracticeTheme
import com.google.android.material.slider.Slider

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
//                    DemoScreen2()
//                    FunctionA()
                    Composable1()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    PracticeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = false, showSystemUi = false)
@Composable
fun DemoTestView() {
//    DemoTest(message = "DemoTestView 2", fontSize = 12f)
    PracticeTheme {
        DemoScreen()
    }
}

@Composable
fun DemoTest(message: String, fontSize: Float) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DemoSlider(sliderPosition: Float, positionChange: (Float) -> Unit){
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..40f,
        value = sliderPosition,
        onValueChange = {
            positionChange(it)
        }
    )
}

@Composable
fun DemoScreen() {

    var sliderPosition by remember { mutableStateOf(25f) }

    val handlePositionChange = {
        position : Float -> sliderPosition = position
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        DemoTest(message = "Welcome to Compose" , fontSize = sliderPosition)

        Spacer(modifier = Modifier.height(150.dp))

        DemoSlider(sliderPosition = sliderPosition, positionChange =handlePositionChange )

        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = sliderPosition.toInt().toString() + "sp")
    }

}

@Composable
fun DemoScreen2() {
    var textState by rememberSaveable { mutableStateOf("") }

    val onTextChange = {
            text : String -> textState = text
    }

    MyTextField(text = textState, onTextChange = onTextChange)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(text: String, onTextChange: (String) -> Unit) {

    TextField(
        value = text,
        onValueChange = onTextChange
    )

}

@Composable
fun FunctionA() {
    var switchState by remember { mutableStateOf(false) }
    val onSwitchChange = { value: Boolean -> switchState = value }

    FunctionB(
        switchState = switchState,
        onSwitchChange = onSwitchChange
    )
}

@Composable
fun FunctionB(switchState: Boolean, onSwitchChange: (Boolean) -> Unit) {
    Switch(
        checked = switchState,
        onCheckedChange = onSwitchChange
    )
}

val localColor = staticCompositionLocalOf { Color(0xffffdbcf) }
@Composable
fun Composable1() {

    var color = if(isSystemInDarkTheme()) {
        Color(0xffa08d87)
    }else Color(0xFFffdbcf)

    Column() {
        Composable2()
        CompositionLocalProvider(localColor provides color ) {
            Composable3()
        }
    }
}

@Composable
fun Composable2() {
    Composable4()
}

@Composable
fun Composable3() {
    Composable5()
}

@Composable
fun Composable4() {
    Composable6()
}

@Composable
fun Composable5() {
    Composable7()
    Composable8()
}

@Composable
fun Composable6() {
    Text(text = "Composable 6")
}
@Composable
fun Composable7() {

}
@Composable
fun Composable8() {
    Text(text = "Composable 8",
            modifier = Modifier.background(localColor.current))
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    PracticeTheme {
        Column {
//            DemoScreen2()
//            FunctionA()
            Composable1()
        }
    }
}
