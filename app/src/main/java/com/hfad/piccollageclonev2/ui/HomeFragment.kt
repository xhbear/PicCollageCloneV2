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

        // topBar setup
        val topBar = binding.topBar
        topBar.title = "PicCollage Clone"
        topBar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_menuFragment)
        }
        topBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.VIP ->
                    findNavController().navigate(R.id.action_homeFragment_to_VIP_Store)
            }
            false
        }

        // bottomBar setup
        val bottomBar = binding.bottomAppbar
        bottomBar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_collageFragment)
        }
        bottomBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.openStore ->
                    findNavController().navigate(R.id.action_homeFragment_to_storeFragment)
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

        // fab setup
        val fab = binding.homeFab
        fab.setOnClickListener {
            pickMultipleMediaLauncher.launch(
                Intent(MediaStore.ACTION_PICK_IMAGES)
                    .apply {
                        putExtra(MediaStore.EXTRA_PICK_IMAGES_MAX, 5)
                    })
        }

        // same function with the fab
        binding.selectImageButton.setOnClickListener {
            pickMultipleMediaLauncher.launch(
                Intent(MediaStore.ACTION_PICK_IMAGES)
                    .apply {
                        putExtra(MediaStore.EXTRA_PICK_IMAGES_MAX, 5)
                    })
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