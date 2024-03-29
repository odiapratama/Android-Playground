package com.problemsolver.androidplayground.ui.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.data.model.Banner
import com.problemsolver.androidplayground.data.model.Headline
import com.problemsolver.androidplayground.data.model.ResultData
import com.problemsolver.androidplayground.data.model.TrendingItem
import com.problemsolver.androidplayground.databinding.HomeFragmentBinding
import com.problemsolver.androidplayground.ui.adapter.BannerAdapter
import com.problemsolver.androidplayground.ui.adapter.HeadlineAdapter
import com.problemsolver.androidplayground.ui.adapter.TrendingAdapter
import com.problemsolver.androidplayground.ui.adapter.dynamic.DynamicAdapter
import com.problemsolver.androidplayground.ui.adapter.dynamic.DynamicAdapterItem
import com.problemsolver.androidplayground.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>() {

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

    override fun setLayout() = R.layout.home_fragment

    override fun viewOnReady() {
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

    override fun observeData() {
        observe(homeViewModel.trending, ::handleGetTrending)
    }

    private fun handleGetTrending(result: ResultData<List<TrendingItem>>) {
        when (result) {
            is ResultData.Loading -> mainActivity.showLoading(true)
            is ResultData.Success -> {
                mainActivity.showLoading(false)
                trendingAdapter.submitList(result.data)
            }
            is ResultData.Error -> {
                mainActivity.showLoading(false)
                Toast.makeText(requireContext(), result.exception.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}