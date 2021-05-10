package com.wada811.viewbindingktx

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wada811.viewbinding.viewBinding
import com.wada811.viewbindingktx.databinding.ViewBindingFragmentBinding
import com.wada811.viewbindingktx.databinding.ViewStubBinding

class ViewBindingFragment : Fragment(R.layout.view_stub) {
    private val viewStubBinding: ViewStubBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewStubBinding.viewStub.setOnInflateListener { _, inflated ->
            val binding = ViewBindingFragmentBinding.bind(inflated)
            binding.text.text = requireArguments().getString(EXTRA_TEXT)
        }
        viewStubBinding.viewStub.inflate()
    }

    companion object {
        private const val EXTRA_TEXT = "text"
        fun newInstance(text: String) = ViewBindingFragment().also { fragment ->
            fragment.arguments = Bundle().also { bundle ->
                bundle.putString(EXTRA_TEXT, text)
            }
        }
    }
}
