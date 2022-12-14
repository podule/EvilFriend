package com.galia.evilfriend.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.galia.evilfriend.adapters.PromptRecyclerViewAdapter
import com.galia.evilfriend.databinding.FragmentPromptListBinding
import com.galia.evilfriend.di.PromptFragmentComponent
import com.galia.evilfriend.ui.viewmodels.PromptListViewModel
import com.galia.evilfriend.util.PromptFilterType
import com.google.android.material.tabs.TabLayout
import javax.inject.Inject

class PromptListFragment : Fragment() {

    private var _binding: FragmentPromptListBinding? = null
    private val binding get() = _binding!!
    lateinit var fragmentComponent: PromptFragmentComponent
        private set

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<PromptListViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPromptListBinding.inflate(inflater, container, false)

        fragmentComponent = (activity as MainActivity).activityComponent.promptFragmentComponent()
        fragmentComponent.inject(this)

        viewModel.promptWithLevelListLiveData.observe(viewLifecycleOwner){
            result ->  binding.promptList.adapter = PromptRecyclerViewAdapter(result, viewModel){ i ->
                val action = PromptListFragmentDirections.actionPromptListFragmentToPromptFragment(i.toString())
                this.findNavController().navigate(action)
            }
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.position) {
                        0 -> viewModel.setFilter(PromptFilterType.ACTIVE_PROMPT)
                        1 -> viewModel.setFilter(PromptFilterType.ARCHIVE_PROMPT)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        binding.fab.setOnClickListener {
            val action = PromptListFragmentDirections.actionPromptListFragmentToPromptFragment()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}