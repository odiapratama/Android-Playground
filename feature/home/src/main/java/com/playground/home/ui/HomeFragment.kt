package com.playground.home.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.playground.core.ui.base.adapter.DynamicAdapter
import com.playground.core.ui.base.adapter.DynamicAdapterItem
import com.playground.core.ui.ext.lazyViewBinding
import com.playground.core.ui.ext.observe
import com.playground.feature.home.R
import com.playground.feature.home.databinding.HomeFragmentBinding
import com.playground.home.data.model.Banner
import com.playground.home.data.model.Headline
import com.playground.home.data.model.ResultData
import com.playground.home.data.model.TrendingItem
import com.playground.home.ui.adapter.BannerAdapter
import com.playground.home.ui.adapter.HeadlineAdapter
import com.playground.home.ui.adapter.TrendingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {

    private val binding by lazyViewBinding(HomeFragmentBinding::bind)
    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var trendingAdapter: TrendingAdapter
    private val adapter by lazy {
        DynamicAdapter.Builder()
            .add(BannerAdapter {
                Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
            })
            .add(HeadlineAdapter {
                Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
            })
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
    }

    private fun initView() {
        trendingAdapter = TrendingAdapter()
        with(binding) {
            vm = homeViewModel
            /*rvTrending.adapter = trendingAdapter*/
            val listView = ArrayList<DynamicAdapterItem>()
            for (i in 0 until 15) {
                listView.add(Banner("Title Banner ${i+1}", "Subtitle Banner ${i+1}", "Description", ""))
                listView.add(Headline("Title Headline ${i+1}", "Subtitle Headline ${i+1}"))
            }
            rvTrending.adapter = adapter
            adapter.submitList(listView)
            executePendingBindings()
        }
    }

    private fun initObserver() {
        observe(homeViewModel.trending, ::handleGetTrending)
    }

    private fun handleGetTrending(result: ResultData<List<TrendingItem>>) {
        when (result) {
            is ResultData.Loading -> {
//                mainActivity.showLoading(true)
            }
            is ResultData.Success -> {
//                mainActivity.showLoading(false)
                trendingAdapter.submitList(result.data)
            }
            is ResultData.Error -> {
//                mainActivity.showLoading(false)
                Toast.makeText(requireContext(), result.exception.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}