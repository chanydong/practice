package com.chany.listdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontSynthesis.Companion.Style
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.chany.listdemo.ui.theme.PracticeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private var itemArray: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemArray = resources.getStringArray(R.array.car_array)

        setContent {
            PracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(itemArray as Array<out String>)
//                    MainScreen(itemArray = itemArray as Array<out String>)
                }
            }
        }
    }
}

@Composable
fun MainScreen(itemArray: Array<out String>) {
//    ColumnList()
//    RowList()
    val context = LocalContext.current
    val onListItemClick = {
        text: String ->
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
    }
    LazyColumn() {
        items(itemArray) {
            model ->
            MyListItem(item = model, onItemClick = onListItemClick)
        }
    }
//    ImageLoader("Plymouth GTX")
}

@Composable
fun ColumnList() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
            modifier = Modifier
                .weight(0.5f)
                .padding(2.dp)) {
                Text("Top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(scrollState.maxValue)
                }
            },
            modifier = Modifier
                .weight(0.5f)
                .padding(2.dp)) {
                Text("End")
            }
        }
        Column(Modifier.verticalScroll(scrollState)) {
            repeat(500) {
                Text("List item $it",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(5.dp))
            }
        }
    }
}

@Composable
fun RowList() {
    val verticalState = rememberScrollState()

    Row(Modifier.horizontalScroll(verticalState)) {
        repeat(50) {
            index -> Text("$index", modifier = Modifier.padding(2.dp))
        }
    }
}

@Composable
fun ImageLoader(item: String) {
    val url = "https://www.ebookfrenzy.com/book_examples/car_logos/" +
            item.substringBefore(" ") + "_logo.png"

    Image(
        painter = rememberImagePainter(url),
        contentDescription = "car image",
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(75.dp)
    )
}

@Composable
fun MyListItem(item: String, onItemClick: (String) -> Unit) {
    Card(modifier =
    Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clickable { onItemClick(item) },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(5.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ImageLoader(item = item)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = item, style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(8.dp))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    val itemArray: Array<String> = arrayOf("Cadillac Eldorado","Ford Fairlane","Plymouth Fury")
    PracticeTheme {
//        MainScreen(itemArray)
    }
}