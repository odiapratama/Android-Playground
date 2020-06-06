package com.problemsolver.androidplayground.di

import com.problemsolver.androidplayground.activities.explore.ExploreViewModel
import com.problemsolver.androidplayground.activities.home.HomeViewModel
import com.problemsolver.androidplayground.activities.more.MoreViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { ExploreViewModel() }
    viewModel { MoreViewModel() }
}