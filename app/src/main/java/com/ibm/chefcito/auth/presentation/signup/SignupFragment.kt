package com.ibm.chefcito.auth.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ibm.chefcito.R
import com.ibm.chefcito.databinding.FragmentSignupBinding
import com.ibm.chefcito.recipes.RecipesMainActivity

class SignupFragment : Fragment() {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignin.setOnClickListener {
            //startActivity(Intent(context, RecipesMainActivity::class.java))
            redirectToMainActivity()
        }
        binding.tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signunFragment_to_loginFragment)
        }
    }

    private fun redirectToMainActivity() {
        val intent = Intent(context, RecipesMainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK  )
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}