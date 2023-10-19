package com.muhsantech.newsappkotlin

object ColorPicker {
    val colors = arrayOf("#3Eb9DF","3685BC","#D36280","FA8056","#7D659F","51BAB3","4FB66C","E3AD17","627991")

    var colorIndex = 1
    fun getColor() :String {
        return colors[colorIndex++ % colors.size]
    }
}