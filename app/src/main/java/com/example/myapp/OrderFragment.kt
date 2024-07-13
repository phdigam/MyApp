package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapp.databinding.FragmentOrderBinding
import com.google.android.material.snackbar.Snackbar


class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.fab.setOnClickListener {
            Snackbar.make(binding.fab,"Your order has been updated", Snackbar.LENGTH_SHORT)
                .setAction("Undo") {
                    Toast.makeText(activity, "Undone!", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}