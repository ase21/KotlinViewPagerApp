package com.trmedia.myapplication.objects

class Rectangle(val h: Int,  val w: Int) {
    val isSquare: Boolean
        get() = h == w
}