package com.wada811.viewbindingktx

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wada811.viewbinding.withBinding
import com.wada811.viewbindingktx.databinding.ViewBindingFragmentBinding

class ViewBindingFragment : Fragment(R.layout.view_binding_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        withBinding(ViewBindingFragmentBinding::bind) { binding ->
            binding.textView.text = """
                withBinding(ViewBindingFragmentBinding::bind) { binding ->
                    // You can use binding
                }
            """.trimIndent()
        }
    }
}
