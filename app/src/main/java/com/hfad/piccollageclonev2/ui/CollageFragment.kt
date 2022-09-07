package com.hfad.piccollageclonev2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hfad.piccollageclonev2.R
import com.hfad.piccollageclonev2.databinding.FragmentCollageBinding

class CollageFragment : Fragment() {


    private var _binding: FragmentCollageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCollageBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment

        binding.topBar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_collageFragment_to_homeFragment)
        }

        return view
    }

}