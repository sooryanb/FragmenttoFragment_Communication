package com.example.fragmenttofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenttofragment.fragments.FragmentA
import com.example.fragmenttofragment.fragments.FragmentB

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragmentA).commit()
    }

    override fun passData(editTextData: String) {
        val bundle = Bundle()
        bundle.putString("message", editTextData)

        val fragmentB = FragmentB()
        fragmentB.arguments = bundle

        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer, fragmentB)
        transaction.commit()

    }
}