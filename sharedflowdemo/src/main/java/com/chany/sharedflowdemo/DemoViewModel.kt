package com.chany.sharedflowdemo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class DemoViewModel : ViewModel() {
    private val TAG = "DemoViewModelTAG"
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        sharedFlowInit()
    }

    fun sharedFlowInit() {
        viewModelScope.launch {
            for(i in 1..1000) {
                delay(2000)
                _sharedFlow.emit(i)
            }
        }
    }

    fun test() {
        val executor: ExecutorService = Executors.newFixedThreadPool(4)

        executor.submit {
            Log.d(TAG, Thread.currentThread().name)
        }
        executor.submit {
            Log.d(TAG, Thread.currentThread().name)
        }

        executor.shutdown()
    }
}