package com.wada811.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.wada811.viewbindingktx.viewBinding
import com.wada811.viewbindingktx.withBinding
import kotlin.properties.ReadOnlyProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding(): ReadOnlyProperty<Fragment, T> = this.viewBinding()

fun <T : ViewBinding> Fragment.viewBinding(bind: (View) -> T): ReadOnlyProperty<Fragment, T> = this.viewBinding(bind)

inline fun <reified T : ViewBinding> Fragment.withBinding(noinline withBinding: (binding: T) -> Unit) = this.withBinding(withBinding)

fun <T : ViewBinding> Fragment.withBinding(bind: (View) -> T, withBinding: (binding: T) -> Unit) = this.withBinding(bind, withBinding)
