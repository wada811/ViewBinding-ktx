package com.wada811.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.wada811.viewbindingktx.viewBinding
import com.wada811.viewbindingktx.withBinding
import kotlin.properties.ReadOnlyProperty

@Deprecated("Import com.wada811.viewbindingktx", ReplaceWith("viewBinding()", "com.wada811.viewbindingktx.viewBinding"))
inline fun <reified T : ViewBinding> Fragment.viewBinding(): ReadOnlyProperty<Fragment, T> = this.viewBinding()

@Deprecated("Import com.wada811.viewbindingktx", ReplaceWith("viewBinding(bind)", "com.wada811.viewbindingktx.viewBinding"))
fun <T : ViewBinding> Fragment.viewBinding(bind: (View) -> T): ReadOnlyProperty<Fragment, T> = this.viewBinding(bind)

@Deprecated("Import com.wada811.viewbindingktx", ReplaceWith("viewBinding(block)", "com.wada811.viewbindingktx.viewBinding"))
inline fun <reified T : ViewBinding> Fragment.withBinding(noinline block: (binding: T) -> Unit) = this.withBinding(block)

@Deprecated("Import com.wada811.viewbindingktx", ReplaceWith("viewBinding(bind, block)", "com.wada811.viewbindingktx.viewBinding"))
fun <T : ViewBinding> Fragment.withBinding(bind: (View) -> T, block: (binding: T) -> Unit) = this.withBinding(bind, block)
