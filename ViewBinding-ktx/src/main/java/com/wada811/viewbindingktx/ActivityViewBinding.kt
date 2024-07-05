@file:JvmName("ActivityViewBinding")

package com.wada811.viewbindingktx

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> FragmentActivity.viewBinding(): Lazy<T> {
    return viewBinding {
        T::class.java.getMethod("bind", View::class.java).invoke(null, it) as T
    }
}

fun <T : ViewBinding> FragmentActivity.viewBinding(bind: (View) -> T): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE) {
        val getContentView: FragmentActivity.() -> View = {
            checkNotNull(findViewById<ViewGroup>(android.R.id.content).getChildAt(0)) {
                "Call setContentView or Use Activity's secondary constructor passing layout res id."
            }
        }
        bind(getContentView())
    }
}

inline fun <reified T : ViewBinding> FragmentActivity.withBinding(block: (binding: T) -> Unit) {
    withBinding({
        T::class.java.getMethod("bind", View::class.java).invoke(null, it) as T
    }, block)
}


inline fun <T : ViewBinding> FragmentActivity.withBinding(bind: (View) -> T, block: (binding: T) -> Unit) {
    val getContentView: FragmentActivity.() -> View = {
        checkNotNull(findViewById<ViewGroup>(android.R.id.content).getChildAt(0)) {
            "Call setContentView or Use Activity's secondary constructor passing layout res id."
        }
    }
    val binding = bind(getContentView())
    block(binding)
}

