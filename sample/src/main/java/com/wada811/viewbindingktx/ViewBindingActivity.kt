package com.wada811.viewbindingktx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wada811.viewbinding.viewBinding
import com.wada811.viewbindingktx.databinding.ViewBindingActivityBinding

class ViewBindingActivity : AppCompatActivity(R.layout.view_binding_activity) {
    private val binding :ViewBindingActivityBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.button.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.fragment)!!
            if (fragment.isDetached) {
                binding.button.text = "Detach"
                supportFragmentManager.beginTransaction()
                    .attach(fragment)
                    .commit()
            } else {
                binding.button.text = "Attach"
                supportFragmentManager.beginTransaction()
                    .detach(fragment)
                    .commit()
            }
        }
        if (savedInstanceState == null) {
            val text = "Fragment is attached."
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, ViewBindingFragment.newInstance(text), text)
                .commit()
        }
    }
}
