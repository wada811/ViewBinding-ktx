package com.wada811.viewbindingktx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wada811.viewbinding.withBinding
import com.wada811.viewbindingktx.databinding.ViewBindingActivityBinding

class ViewBindingActivity : AppCompatActivity(R.layout.view_binding_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        withBinding(ViewBindingActivityBinding::bind) { binding ->
            binding.textView.text = """
                withBinding(ViewBindingActivityBinding::bind) { binding ->
                    // You can use binding
                }
            """.trimIndent()
            supportFragmentManager.beginTransaction()
                .replace(binding.fragment.id, ViewBindingFragment())
                .commit()
        }
    }
}
