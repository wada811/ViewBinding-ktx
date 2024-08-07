package com.wada811.viewbindingktx

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding(): ReadOnlyProperty<Fragment, T> {
    return viewBinding {
        T::class.java.getMethod("bind", View::class.java).invoke(null, it) as T
    }
}

fun <T : ViewBinding> Fragment.viewBinding(bind: (View) -> T): ReadOnlyProperty<Fragment, T> {
    return object : ReadOnlyProperty<Fragment, T> {
        @Suppress("UNCHECKED_CAST")
        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
            (requireView().getTag(property.key) as? T)?.let { return it }
            return bind(requireView()).also {
                requireView().setTag(property.key, it)
            }
        }
    }
}

private val KProperty<*>.key: Int
    get() = name.hashCode()


inline fun <reified T : ViewBinding> Fragment.withBinding(withBinding: (binding: T) -> Unit) {
    withBinding({
        T::class.java.getMethod("bind", View::class.java).invoke(null, it) as T
    }, withBinding)
}

inline fun <T : ViewBinding> Fragment.withBinding(bind: (View) -> T, withBinding: (binding: T) -> Unit) {
    view?.let { view ->
        val binding = bind(view)
        withBinding(binding)
    }
}
