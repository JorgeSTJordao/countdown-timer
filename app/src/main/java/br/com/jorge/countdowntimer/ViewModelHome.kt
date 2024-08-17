package br.com.jorge.countdowntimer

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ViewModelHome: ViewModel(){

    var timeState = MutableStateFlow(Timer())
        private set

    fun onEvent(event: Event){
        when(event){
            is Event.StartCount -> {

            }
            is Event.ResetCount -> {

            }
            is Event.SelectTime -> {

            }
        }
    }
}