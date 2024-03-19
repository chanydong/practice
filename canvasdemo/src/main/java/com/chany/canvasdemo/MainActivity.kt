package com.chany.canvasdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chany.canvasdemo.ui.theme.PracticeTheme
import java.lang.Math.PI
import java.lang.Math.sin

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
//    DrawLine()
//    DrawRect()
//    GradientFill()
//    DrawPath()
//    DrawPoints()
    DrawImage()
}

@Composable
fun DrawImage() {
    val image = ImageBitmap.imageResource(id = R.drawable.vacation)

    Canvas(modifier = Modifier.size(300.dp, 270.dp)) {
        drawImage(
            image = image,
            topLeft = Offset(0f,0f),
            colorFilter = ColorFilter.tint(
                Color(0xADFFAA2E),
                blendMode = BlendMode.ColorBurn)
        )
    }
}

@Composable
fun DrawPoints() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val height = size.height
        val width = size.width
        val points = mutableListOf<Offset>()


        for (x in 0..size.width.toInt()) {
            val y = (kotlin.math.sin(x * (2f * PI / width))
                * (height / 2) + (height / 2)).toFloat()
            points.add(Offset(x.toFloat(), y))
        }

        drawPoints(
            points = points,
            strokeWidth = 3f,
            pointMode = PointMode.Points,
            color = Color.Black
        )
    }
}

@Composable
fun DrawPath() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val path = Path().apply {
            moveTo(0f, 0f)
            quadraticBezierTo(50.dp.toPx(), 200.dp.toPx(), 300.dp.toPx(), 300.dp.toPx())
            lineTo(270.dp.toPx(), 100.dp.toPx())
            quadraticBezierTo(60.dp.toPx(), 80.dp.toPx(), 0.dp.toPx(), 0.dp.toPx())
            close()
        }

        drawPath(
            path = path,
            Color.Black
        )
    }
}

@Composable
fun GradientFill() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val canvasSize = size
        val colorList: List<Color> = listOf(Color.Red, Color.Blue, Color.Magenta, Color.Yellow,
            Color.Green, Color.Cyan)
        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0f,
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )

        drawRect(
            size = canvasSize,
            brush = brush
        )

    }
}
@Composable
fun DrawRect() {
    Canvas( modifier = Modifier.size(300.dp)) {
//        val size = Size(600f, 250f)
        val size = Size(200.dp.toPx(), 100.dp.toPx())
        inset(200f,300f) {
            drawRect(
                color = Color.Blue,
                size = size / 2f
            )
        }
    }
    // 타원 원 생략
}

@Composable
fun DrawLine() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val height = size.height
        val width = size.width

        drawLine(
            start = Offset(x=0f, y=0f),
            end = Offset(x = width, y = height),
            color = Color.Blue,
            strokeWidth = 16.0f,
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(50f, 10f, 20f, 10f), phase = 0f)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    MainScreen()
}