package com.codelabs.basicstatecodelab

import kotlin.random.Random

data class WellnessTask(
    val id: Int,
    val label: String
) {

    companion object {
        val DEFAULT: WellnessTask
            get() {
                val id = Random(System.currentTimeMillis()).nextInt()
                return WellnessTask(
                    id = id,
                    label = "${id + 1}번째 빈 칸!"
                )
            }
    }
}
