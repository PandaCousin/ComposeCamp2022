package com.codelabs.basicstatecodelab

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val _tasks = mutableStateListOf<WellnessTask>()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun add(item: WellnessTask) {
        _tasks.add(item)
    }

    fun remove(id: Int) {
        _tasks.removeFirstOrNull()
    }

    fun clear() {
        _tasks.clear()
    }
}

