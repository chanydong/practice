package com.chany.sharedflowdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chany.sharedflowdemo.ui.theme.PracticeTheme
import kotlinx.coroutines.flow.SharedFlow

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
                    ScreenSetup(DemoViewModel())

                }
            }
        }
    }
}

@Composable
fun ScreenSetup(viewmodel: DemoViewModel = viewModel()) {
//    MainScreen(viewmodel.sharedFlow)
    testScreen(viewModel = viewmodel)
}

@Composable
fun testScreen(viewModel: DemoViewModel) {

    viewModel.test()
}

@Composable
fun MainScreen(sharedFlow: SharedFlow<Int>) {

    val messages = remember { mutableStateListOf<Int>() }
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(key1 = Unit) {
        sharedFlow.collect {
            messages.add(it)
        }
    }

    LazyColumn() {
        items(messages) {
            Text(
                "Collected Value = $it",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val viewmodel: DemoViewModel = viewModel()
//    MainScreen(sharedFlow = viewmodel.sharedFlow)
    testScreen(viewModel = viewmodel)
}