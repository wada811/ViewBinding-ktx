@file:JvmName("ActivityViewBinding")

package com.wada811.viewbinding

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> FragmentActivity.viewBinding(
    crossinline bind: (View) -> T = {
        T::class.java.getMethod("bind", View::class.java).invoke(null, it) as T
    }
): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) {
    val getContentView: FragmentActivity.() -> View = {
        checkNotNull(findViewById<ViewGroup>(android.R.id.content).getChildAt(0)) {
            "Call setContentView or Use Activity's secondary constructor passing layout res id."
        }
    }
    bind(getContentView())
}
