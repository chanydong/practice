package com.chany.roomdemo

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chany.roomdemo.ui.theme.PracticeTheme

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
                    val owner = LocalViewModelStoreOwner.current

                    owner?.let {
                        val viewModel: MainViewModel = viewModel(it,
                            "MainViewModel",
                            MainViewModelFactory(LocalContext.current.applicationContext as Application))

                        ScreenSetup(viewModel)


                    }

                }
            }
        }
    }
}

class MainViewModelFactory(val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(application) as T
    }
}

@Composable
fun ScreenSetup(viewModel: MainViewModel) {
    
//    val allProducts by viewModel.allProducts.observe(listOf())
}
@Composable
fun TitleRow(head1: String, head2: String, head3: String) {
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .fillMaxWidth()
        .padding(5.dp)) {

        Text(text = head1, color = Color.White, modifier = Modifier.weight(0.1f))
        Text(text = head2, color = Color.White, modifier = Modifier.weight(0.2f))
        Text(text = head3, color = Color.White, modifier = Modifier.weight(0.2f))
    }
}

@Composable
fun ProductRow(id: Int, name: String, quantity: Int) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Text(id.toString(), Modifier.weight(0.1f))
        Text(name, Modifier.weight(0.2f))
        Text(quantity.toString(), Modifier.weight(0.2f))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType
) {
    OutlinedTextField(value = textState, onValueChange = { onTextChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        label = { Text(title) },
        modifier = Modifier.padding(10.dp),
        textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
    )
}