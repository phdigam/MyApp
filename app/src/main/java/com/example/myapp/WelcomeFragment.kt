package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class WelcomFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        val startButton = view.findViewById<Button>(R.id.start)
        val doubleStartButton = view.findViewById<Button>(R.id.doubleStart)

        startButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomFragment_to_messageFragment)
        }
        doubleStartButton.setOnClickListener(){
            view.findNavController().navigate(R.id.action_welcomFragment_to_anotherWelcomFragment)
        }
        return view
    }

}
