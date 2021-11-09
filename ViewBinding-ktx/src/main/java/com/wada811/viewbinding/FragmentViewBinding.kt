package com.wada811.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding(): ReadOnlyProperty<Fragment, T> {
    return object : ReadOnlyProperty<Fragment, T> {
        @Suppress("UNCHECKED_CAST")
        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
            (requireView().getTag(R.id.view_binding_tag) as? T)?.let { return it }
            val bind: (View) -> T = {
                T::class.java.getMethod("bind", View::class.java).invoke(null, it) as T
            }
            return bind(requireView()).also {
                requireView().setTag(R.id.view_binding_tag, it)
            }
        }
    }
}

fun <T : ViewBinding> Fragment.viewBinding(bind: (View) -> T): ReadOnlyProperty<Fragment, T> {
    return object : ReadOnlyProperty<Fragment, T> {
        @Suppress("UNCHECKED_CAST")
        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
            (requireView().getTag(R.id.view_binding_tag) as? T)?.let { return it }
            return bind(requireView()).also {
                requireView().setTag(R.id.view_binding_tag, it)
            }
        }
    }
}

inline fun <reified T : ViewBinding> Fragment.withBinding(withBinding: (binding: T) -> Unit) {
    view?.let { view ->
        val bind: (View) -> T = {
            T::class.java.getMethod("bind", View::class.java).invoke(null, it) as T
        }
        val binding = bind(view)
        withBinding(binding)
    }
}
