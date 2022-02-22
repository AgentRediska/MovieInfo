package com.agentrediska.movieinfo.presentation.screen.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.agentrediska.movieinfo.App
import com.agentrediska.movieinfo.data.model.Film
import com.agentrediska.movieinfo.databinding.FragmentListFilmsBinding
import com.agentrediska.movieinfo.presentation.common.BaseFragment
import com.agentrediska.movieinfo.presentation.common.ViewModelFactory
import com.agentrediska.movieinfo.presentation.screen.film.list.ListFilmsAdapter

class ListFilmsFragment: BaseFragment<FragmentListFilmsBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentListFilmsBinding = FragmentListFilmsBinding::inflate
    private val viewModel: ListFilmsViewModel by viewModels{ ViewModelFactory() }
    private var listFilms: MutableList<Film> = mutableListOf()
    private var listFilmsAdapter: ListFilmsAdapter = ListFilmsAdapter(listFilms)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObserverToListFilms()
        setObserverToSplashVisible()
        getFilmList()
        initListFilms()
    }

    private fun getFilmList() {
        viewModel.getFilmList((activity?.application as App).filmApi)
    }

    private fun setObserverToListFilms() {
        viewModel.filmListLiveData.observe( viewLifecycleOwner, { list: List<Film>? ->
            list?.let {
                listFilms.clear()
                listFilms.addAll(list)
                listFilmsAdapter?.notifyDataSetChanged()
            }
        })
    }

    private fun setObserverToSplashVisible() {
        viewModel.splashVisibleLiveData.observe(viewLifecycleOwner, {
            if(binding.splashScreenContainer.visibility != View.GONE) {
                binding.splashScreenContainer.visibility = View.GONE
                binding.filmScreenContainer.visibility = View.VISIBLE
            }
        })
    }

    private fun initListFilms() {
        binding.recyclerView.layoutManager = GridLayoutManager( requireContext(), 2)
        binding.recyclerView.adapter = listFilmsAdapter
    }
}