package com.galia.evilfriend.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.galia.evilfriend.databinding.FragmentPromptBinding
import com.galia.evilfriend.di.PromptFragmentComponent
import com.galia.evilfriend.ui.viewmodels.PromptViewModel
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import javax.inject.Inject

class PromptFragment : Fragment() {

    val args: PromptFragmentArgs by navArgs()
    private var _binding: FragmentPromptBinding? = null
    private val binding get() = _binding!!

    lateinit var fragmentComponent: PromptFragmentComponent
        private set

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<PromptViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPromptBinding.inflate(inflater, container, false)

        fragmentComponent = (activity as MainActivity).activityComponent.promptFragmentComponent()
        fragmentComponent.inject(this)

        viewModel.init(args.promptId?.toInt())

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.promptTime.setOnClickListener {
            val picker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(viewModel.hour.value ?: 0)
                .setMinute(viewModel.minute.value ?: 0)
                .setTitleText("Выберете время для ежедневного напоминания")
                .build()
            picker.show(childFragmentManager, "tag")
            picker.addOnPositiveButtonClickListener {
                viewModel.hour.value = picker.hour
                viewModel.minute.value =  picker.minute
            }
        }

        viewModel.promptSaved.observe(viewLifecycleOwner) {
            val action = PromptFragmentDirections.actionPromptFragmentToPromptListFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}