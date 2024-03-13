package com.chany.layoutmodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.chany.layoutmodifier.ui.theme.PracticeTheme
import kotlinx.coroutines.NonDisposableHandle.parent

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

@Composable
fun MainScreen() {
    ConstraintLayout(Modifier.size(400.dp, 400.dp)) {
        val (button1, button2, button3) = createRefs()
        val guide = createGuidelineFromStart(fraction = .60f)

//        createHorizontalChain(button1, button2, button3,
//            chainStyle = ChainStyle.Packed)

        MyButton(text = "Button1", Modifier.constrainAs(button1) {
//            centerVerticallyTo(parent)
            top.linkTo(parent.top, margin = 30.dp)
            end.linkTo(guide, margin = 30.dp)
        })
        MyButton(text = "Button2", Modifier.constrainAs(button2) {
            centerVerticallyTo(parent)
        })
        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            centerVerticallyTo(parent)
        })
    }

    /*
    Box(modifier = Modifier.size(120.dp, 80.dp)) {
        ColorBox(modifier = Modifier
            .exampleLayout(90, 50)
            .background(Color.Blue))
    }
     */
    /*
    Box() {
        CascadeLayout(50) {
            Box(modifier = Modifier.size(60.dp).background(Color.Blue))
            Box(modifier = Modifier.size(60.dp).background(Color.Red))
            Box(modifier = Modifier.size(60.dp).background(Color.Cyan))
        }
    }
     */
}

@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(onClick = {},
        modifier = modifier
    ) {
        Text(text = text)
    }
}


fun Modifier.exampleLayout(
    x: Int,
    y: Int
) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x,y)
    }
}

@Composable
fun ColorBox(modifier: Modifier) {
    Box(
        Modifier
            .padding(1.dp)
            .size(width = 50.dp, height = 10.dp)
            .then(modifier))
}

@Composable
fun DoNothingLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(modifier = modifier, content = content) {
        measureables, constraints ->
        val placeables = measureables.map { measurable -> measurable.measure(constraints) }

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach {
                placeable -> placeable.placeRelative(x=0,y=0)
            }
        }
    }
}

@Composable
fun CascadeLayout(
    spacing: Int = 0,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) {
        measurables, constraints ->
        var indent = 0
        layout(constraints.maxWidth, constraints.maxHeight) {
            var yCoord = 0
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }
            placeables.forEach() {
                placeable ->
                placeable.placeRelative(indent,yCoord)
                indent += placeable.width + spacing
                yCoord += placeable.height + spacing
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeTheme {
        MainScreen()
    }
}