package br.com.jorge.countdowntimer

sealed class Event {
    data object StartCount: Event()
    data object ResetCount: Event()
    data class SelectTime(
        val newHours: Int,
        val newMinutes: Int,
        val newSeconds: Int
    ): Event()
}