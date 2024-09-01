package br.com.jorge.countdowntimer

import android.os.CountDownTimer
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jorge.countdowntimer.TimeFormatExt.timeFormat
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class CountDownTimerViewModel(): ViewModel() {

    private var countDownTimer: CountDownTimer? = null

    private val userInputHour = TimeUnit.HOURS.toMillis(1)
    private val userInputMinute = TimeUnit.MINUTES.toMillis(10)
    private val userInputSecond = TimeUnit.SECONDS.toMillis(30)

    val initialTotalTimeInMillis = userInputHour + userInputMinute + userInputSecond
    var timeLeft = mutableLongStateOf(initialTotalTimeInMillis)
    val countDownInterval = 1000L

    val timerText = mutableStateOf(timeLeft.longValue.timeFormat())

    val isPlaying = mutableStateOf(false)

    fun startCountDownTimer() = viewModelScope.launch {
        isPlaying.value = true
        countDownTimer = object : CountDownTimer(timeLeft.longValue, countDownInterval){

            override fun onTick(millisUntilFinished: Long) {
                timerText.value = millisUntilFinished.timeFormat()
                timeLeft.longValue = millisUntilFinished
            }

            override fun onFinish() {
                timerText.value = initialTotalTimeInMillis.timeFormat()
                isPlaying.value = false
            }

        }.start()

    }

    fun stopCountDownTimer() = viewModelScope.launch {
        isPlaying.value = false
        countDownTimer?.cancel()
    }

    fun resetCountDownTimer() = viewModelScope.launch {
        isPlaying.value = false
        countDownTimer?.cancel()
        timerText.value = initialTotalTimeInMillis.timeFormat()
        timeLeft.longValue = initialTotalTimeInMillis
    }
}