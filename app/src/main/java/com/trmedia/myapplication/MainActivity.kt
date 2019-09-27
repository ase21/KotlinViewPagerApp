package com.trmedia.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.trmedia.myapplication.objects.Color
import com.trmedia.myapplication.objects.Color.*
import com.trmedia.myapplication.objects.Expr
import com.trmedia.myapplication.objects.Expr.Num
import com.trmedia.myapplication.objects.Expr.Sum
import com.trmedia.myapplication.objects.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CustomSimpleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CustomSimpleAdapter(supportFragmentManager)

        adapter.addFragment(FragmentOne(), "First")
        adapter.addFragment(FragmentTwo(), "Second")
        adapter.addFragment(FragmentTwo(), "Second")
        adapter.addFragment(FragmentTwo(), "Second")
        adapter.addFragment(FragmentTwo(), "Second")

        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)

//
//        Toast.makeText(applicationContext, "some " + getMnemonic(GREEN), Toast.LENGTH_SHORT).show()
//        Toast.makeText(applicationContext, "some " + mix(RED, YELLOW), Toast.LENGTH_SHORT).show()


//        Toast.makeText(applicationContext, "some " + eval(Sum(Sum(Num(1), Num(2)), Num(4))), Toast.LENGTH_SHORT).show()
        for (i in 1..100){
            println(fizzBuzz(i))
        }
    }

    private fun fizzBuzz(i: Int) = when {
        i % 15 == 0 -> "FizzBuzz"
        i % 5 == 0 -> "Fizz"
        i % 3 == 0 -> "Buzz"
        else -> "$i"
    }

    private fun mix(color: Color, color1: Color) = when (setOf(color, color1)){
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        else -> {
            throw Exception("ololo")
        }
    }

    private fun getMnemonic(color: Color) = when (color) {
        GREEN, BLUE -> "Холодно"
        RED, ORANGE, YELLOW -> "Тепло"
    }

    private fun eval(e: Expr): Int =
        when (e) {
            is Num -> {
                e.value
            }
            is Sum -> {
                val f = eval(e.first)
                val s = eval(e.second)
                f + s
            }
            else -> throw IllegalAccessException("unknown")
        }

}
