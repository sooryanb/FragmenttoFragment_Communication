package com.example.fragmenttofragment.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import com.example.fragmenttofragment.Communicator
import com.example.fragmenttofragment.MainActivity
import com.example.fragmenttofragment.R
import com.example.fragmenttofragment.databinding.FragmentABinding
import java.util.*


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

        val context = context as MainActivity
        
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)

        binding.inputMessage.setOnClickListener {
            val datePicker =
                DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.inputMessage.text = "$dayOfMonth"
                }, year, month, day)
                
                datePicker.show()
        }

        return view
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}