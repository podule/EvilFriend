package com.galia.evilfriend.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.galia.evilfriend.databinding.FragmentPromptBinding


class PromptFragment : Fragment() {

    val args: PromptFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPromptBinding.inflate(inflater, container, false)
        binding.text.text = args.promptId ?: "none"

        return binding.root
    }

}