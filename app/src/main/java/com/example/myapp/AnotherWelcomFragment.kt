package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class AnotherWelcomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_another_welcom, container, false)
        val nextButton = view.findViewById<Button>(R.id.next)

        nextButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_anotherWelcomFragment_to_messageFragment)
        }
        return view
    }

}