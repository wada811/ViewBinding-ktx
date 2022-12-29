package com.wada811.viewbindingktx.sample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wada811.viewbindingktx.sample.databinding.ViewBindingActivityBinding
import com.wada811.viewbindingktx.withBinding

class ViewBindingActivity : AppCompatActivity(R.layout.view_binding_activity) {
    @SuppressLint("SetTextI18n")
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
