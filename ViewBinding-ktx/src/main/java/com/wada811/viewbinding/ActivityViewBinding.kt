@file:JvmName("ActivityViewBinding")

package com.wada811.viewbinding

import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.wada811.viewbindingktx.viewBinding
import com.wada811.viewbindingktx.withBinding

@Deprecated("Import com.wada811.viewbindingktx", ReplaceWith("viewBinding()", "com.wada811.viewbindingktx.viewBinding"))
inline fun <reified T : ViewBinding> FragmentActivity.viewBinding(): Lazy<T> = this.viewBinding()

@Deprecated("Import com.wada811.viewbindingktx", ReplaceWith("viewBinding(bind)", "com.wada811.viewbindingktx.viewBinding"))
fun <T : ViewBinding> FragmentActivity.viewBinding(bind: (View) -> T): Lazy<T> = this.viewBinding(bind)

@Deprecated("Import com.wada811.viewbindingktx", ReplaceWith("withBinding(block)", "com.wada811.viewbindingktx.withBinding"))
inline fun <reified T : ViewBinding> FragmentActivity.withBinding(noinline block: (binding: T) -> Unit) = this.withBinding(block)

@Deprecated("Import com.wada811.viewbindingktx", ReplaceWith("withBinding(bind, block)", "com.wada811.viewbindingktx.withBinding"))
fun <T : ViewBinding> FragmentActivity.withBinding(bind: (View) -> T, block: (binding: T) -> Unit) = this.withBinding(bind, block)

