package com.wada811.viewbindingktx.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wada811.viewbindingktx.sample.databinding.ViewBindingFragmentBinding
import com.wada811.viewbindingktx.withBinding

class ViewBindingFragment : Fragment(R.layout.view_binding_fragment) {
    @SuppressLint("SetTextI18n")
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
