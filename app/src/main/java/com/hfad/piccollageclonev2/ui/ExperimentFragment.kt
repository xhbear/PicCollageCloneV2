package com.hfad.piccollageclonev2.ui

import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.hfad.piccollageclonev2.R
import com.hfad.piccollageclonev2.databinding.FragmentExperimentBinding

class ExperimentFragment : Fragment() {

    private var _binding: FragmentExperimentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentExperimentBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment

        // load images
        val image1 = binding.image1
        LoadImage(requireContext(), R.drawable.stock_photo_anya, image1)
        val image2 = binding.image2
        LoadImage(requireContext(), R.drawable.stock_photo_kanji, image2)

        image1.setOnLongClickListener {
            val clipData = image1.clipBounds


            true
        }

        return view
    }

    private fun LoadImage(context: Context, resourceId: Int, target: ImageView){
        Glide.with(context)
            .load(resourceId)
            .into(target)
    }

}