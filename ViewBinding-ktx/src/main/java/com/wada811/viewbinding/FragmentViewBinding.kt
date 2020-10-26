package com.wada811.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding(
    crossinline bind: (View) -> T = { T::class.java.getMethod("bind", View::class.java).invoke(null, it) as T }
): ReadOnlyProperty<Fragment, T> = object : ReadOnlyProperty<Fragment, T> {
    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        (requireView().getTag(property.name.hashCode()) as? T)?.let { return it }
        return bind(requireView()).also {
            requireView().setTag(property.name.hashCode(), it)
        }
    }
}

