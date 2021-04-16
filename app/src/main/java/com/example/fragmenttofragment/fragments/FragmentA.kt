package com.example.fragmenttofragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmenttofragment.Communicator
import com.example.fragmenttofragment.R
import com.example.fragmenttofragment.databinding.FragmentABinding


class FragmentA : Fragment() {

    lateinit var communicator: Communicator
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        val view =  binding.root

        communicator = activity as Communicator
        binding.btnSend.setOnClickListener { communicator.passData(binding.inputMessage.text.toString()) }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}