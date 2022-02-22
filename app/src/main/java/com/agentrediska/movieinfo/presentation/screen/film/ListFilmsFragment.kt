package com.agentrediska.movieinfo.presentation.screen.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.agentrediska.movieinfo.databinding.FragmentListFilmsBinding
import com.agentrediska.movieinfo.presentation.common.BaseFragment

class ListFilmsFragment: BaseFragment<FragmentListFilmsBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentListFilmsBinding = FragmentListFilmsBinding::inflate
    private val viewModel: ListFilmViewModel by viewModels()
}