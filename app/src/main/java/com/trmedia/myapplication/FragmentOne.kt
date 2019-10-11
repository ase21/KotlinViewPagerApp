package com.trmedia.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import java.lang.StringBuilder

class FragmentOne : Fragment() {

    val set = hashSetOf(1, 7, 2)
    val list = listOf(1, 5, 3)
    val map = hashMapOf(1 to "one", 7 to "seven")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        joinToString(list, ";", "(", ")")
        return inflater.inflate(R.layout.fragment_one, null)
    }

    private fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String) {
        val result = StringBuilder(prefix)
        for ((index, element) in collection.withIndex()){
            if (index > 0)
                result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        println(result)
    }
}
