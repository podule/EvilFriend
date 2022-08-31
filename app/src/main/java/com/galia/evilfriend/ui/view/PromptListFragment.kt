package com.galia.evilfriend.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.galia.evilfriend.adapters.PromptRecyclerViewAdapter
import com.galia.evilfriend.databinding.FragmentPromptListBinding
import com.galia.evilfriend.di.PromptFragmentComponent
import com.galia.evilfriend.ui.viewmodels.PromptViewModel
import javax.inject.Inject

class PromptListFragment : Fragment() {

    lateinit var fragmentComponent: PromptFragmentComponent
        private set

    @Inject
    lateinit var viewModel: PromptViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = FragmentPromptListBinding.inflate(inflater, container, false)

        fragmentComponent = (activity as MainActivity).activityComponent.promptFragmentComponent()
        fragmentComponent.inject(this)

        viewModel.promptWithLevelListLiveData.observe(viewLifecycleOwner){
            result ->  view.promptList.adapter = PromptRecyclerViewAdapter(result, viewModel){ i ->
                val action = PromptListFragmentDirections.actionPromptListFragmentToPromptFragment(i.toString())
                this.findNavController().navigate(action)
            }
        }

        return view.root
    }
}