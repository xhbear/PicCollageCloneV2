package com.hfad.piccollageclonev2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hfad.piccollageclonev2.R
import com.hfad.piccollageclonev2.databinding.HomeMenuDialogBinding

class MenuFragment : Fragment() {
    private var _binding: HomeMenuDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        _binding = HomeMenuDialogBinding.inflate(inflater, container, false)
        val view = binding.root

        val menuToolbar = binding.topBar
        menuToolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_homeFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}