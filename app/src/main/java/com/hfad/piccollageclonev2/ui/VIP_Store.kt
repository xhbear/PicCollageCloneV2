package com.hfad.piccollageclonev2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hfad.piccollageclonev2.R
import com.hfad.piccollageclonev2.databinding.FragmentVIPStoreBinding

class VIP_Store : Fragment() {

    private var _binding: FragmentVIPStoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentVIPStoreBinding.inflate(inflater, container, false)
        val view = binding.root

        val toolbar = binding.vipToolbar.root

        binding.vipToolbar.pageTitle.text = "VIP"
        toolbar.setNavigationIcon(R.drawable.ic_baseline_cancel_24)
        toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_VIP_Store_to_homeFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}