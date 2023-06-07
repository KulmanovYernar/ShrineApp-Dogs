package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.codelabs.mdc.kotlin.shrine.databinding.ShrLoginFragmentBinding

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment(){

    private lateinit var binding:ShrLoginFragmentBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        // Snippet from "Navigate to the next Fragment" section goes here.
        binding = ShrLoginFragmentBinding.inflate(layoutInflater)
        val view = binding.root

        binding.nextButton.setOnClickListener{
            if(!isPasswordValid(binding.passwordEditText.text!!)){
                binding.passwordTextInput.error = getString(R.string.shr_error_password)
            }
            else{
                binding.passwordTextInput.error = null
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }

        }

        binding.passwordEditText.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(binding.passwordEditText.text!!)) {
                binding.passwordTextInput.error = null
            }
            false

        }

        return view
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
        private fun isPasswordValid(text:Editable?):Boolean{
            return text != null && text.length >= 8

        }
}
