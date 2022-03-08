package com.agentrediska.movieinfo.presentation.screen.film

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.agentrediska.movieinfo.databinding.FragmentListFilmsBinding
import com.agentrediska.movieinfo.presentation.common.BaseFragment
import com.agentrediska.movieinfo.presentation.common.ViewModelFactory
import com.agentrediska.movieinfo.presentation.screen.film.list.ListFilmsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.coroutines.suspendCoroutine

class ListFilmsFragment: BaseFragment<FragmentListFilmsBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentListFilmsBinding = FragmentListFilmsBinding::inflate
    private val viewModel: ListFilmsViewModel by viewModels{ ViewModelFactory() }
    private val hideSplashScreen = {
        if(binding.splashScreenContainer.visibility != View.GONE) {
            binding.splashScreenContainer.visibility = View.GONE
            binding.filmScreenContainer.visibility = View.VISIBLE
        }
    }
    private var listFilmsAdapter: ListFilmsAdapter = ListFilmsAdapter(hideSplashScreen)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListFilms()
    }

    private fun initListFilms() {
        binding.recyclerView.layoutManager = GridLayoutManager( requireContext(), 2)
        binding.recyclerView.adapter = listFilmsAdapter
        lifecycleScope.launch {
            viewModel.filmList.collectLatest(listFilmsAdapter::submitData)
        }
    }
}