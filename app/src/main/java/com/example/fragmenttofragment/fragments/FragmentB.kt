package com.example.fragmenttofragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmenttofragment.R
import com.example.fragmenttofragment.databinding.FragmentABinding
import com.example.fragmenttofragment.databinding.FragmentBBinding


class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!
    var displayMessage: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        val view =  binding.root

        displayMessage = arguments?.getString("message")
        binding.displayText.text = displayMessage

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}