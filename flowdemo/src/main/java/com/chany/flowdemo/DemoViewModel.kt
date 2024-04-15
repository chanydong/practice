package com.chany.flowdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DemoViewModel : ViewModel() {

    val myFlow: Flow<Int> = flow {

        for(i in 1..5) {
            delay(1000)
            emit(i)
        }
    }

    val newFlow = myFlow
    .map {
        "Current value = $it"
    }

    fun doubleIt(value: Int) = flow {
        emit(value)
        delay(1000)
        emit(value + value)
    }

    // shared flow
    private val _sharedFlow = MutableSharedFlow<Int>(
        replay = 10,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun startSharedFlow() {
        viewModelScope.launch {
            for( i in 1..5) {
                _sharedFlow.emit(i)
                delay(2000)
            }
        }
    }

}