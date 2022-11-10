package com.cevdetyilmaz.invitefriendcase.feature.invite

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cevdetyilmaz.invitefriendcase.R
import com.cevdetyilmaz.invitefriendcase.base.BaseFragment
import com.cevdetyilmaz.invitefriendcase.common.viewBinding
import com.cevdetyilmaz.invitefriendcase.databinding.FragmentInviteListBinding
import com.cevdetyilmaz.invitefriendcase.domain.model.InviteScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */
@AndroidEntryPoint
class InviteListFragment : BaseFragment<InviteListViewModel>(R.layout.fragment_invite_list) {
    override val binding by viewBinding(FragmentInviteListBinding::bind)
    override val viewModel: InviteListViewModel by viewModels()

    private var rvAdapter: AdapterInviteList? = null

    override fun observeViewModel(viewModel: InviteListViewModel) {
        super.observeViewModel(viewModel)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.launchResult.collectLatest {
                binding.pbLoading.isVisible = it is InviteListEvent.Loading
                when (it) {
                    is InviteListEvent.DataLoaded -> {
                        binding.pbLoading.visibility = View.GONE
                        setupUI(it.data)
                    }
                    is InviteListEvent.Error -> {
                        binding.pbLoading.visibility = View.GONE
                        Toast.makeText(context, it.error, Toast.LENGTH_LONG).show()
                    }
                    InviteListEvent.Loading -> binding.pbLoading.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setupUI(data: InviteScreen) {
        with(binding) {
            txtTotalEarnDesc.text = data.totalEarningText
            txtPotentialEarnDesc.text = data.potentialEarningText
            txtMaximumEarns.text = data.maxEarningText
            rvAdapter?.updateItemList(data.userList?.toMutableList())
        }
    }

    override fun initUI() {
        viewModel.getInviteList()
        rvAdapter = AdapterInviteList()
        with(binding) {
            rvInvitedList.apply {
                adapter = rvAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

    }
}