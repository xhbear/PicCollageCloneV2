package com.hfad.piccollageclonev2.ui

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.hfad.piccollageclonev2.R
import com.hfad.piccollageclonev2.databinding.FragmentHomeBinding
import com.hfad.piccollageclonev2.model.SharedViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var pickMultipleMediaLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.homeToolbar.pageTitle.text = "PicCollage Clone"

        binding.homeToolbar.pageTitle.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_menuFragment)
        }

        val toolbar = binding.homeToolbar.root
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24)
        toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_menuFragment)
        }
        toolbar.inflateMenu(R.menu.toolbar_home_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.VIP ->
                    findNavController().navigate(R.id.action_homeFragment_to_VIP_Store)
            }
            false
        }
        pickMultipleMediaLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                val uris = it.data?.clipData ?: return@registerForActivityResult
                var uriPaths = ""
                for (index in 0 until uris.itemCount) {
                    uriPaths += uris.getItemAt(index).uri.path
                    uriPaths += "\n"
                }
            }

        binding.selectImageButton.setOnClickListener {
            pickMultipleMediaLauncher.launch(
                Intent(MediaStore.ACTION_PICK_IMAGES)
                    .apply {
                        putExtra(MediaStore.EXTRA_PICK_IMAGES_MAX, 5)
                    }
            )
        }

        binding.buttonToCollage.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_collageFragment)
        }

        binding.imageButton.setOnClickListener {
            pickMultipleMediaLauncher.launch(
                Intent(MediaStore.ACTION_PICK_IMAGES)
                    .apply {
                        putExtra(MediaStore.EXTRA_PICK_IMAGES_MAX, 5)
                    }
            )
        }

        binding.buttonToStore.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_storeFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}