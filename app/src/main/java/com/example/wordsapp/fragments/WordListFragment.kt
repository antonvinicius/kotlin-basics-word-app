package com.example.wordsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.R
import com.example.wordsapp.WordAdapter
import com.example.wordsapp.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {
    private lateinit var binding: FragmentWordListBinding

    private val args by navArgs<WordListFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWordListBinding.inflate(layoutInflater)
        val (letter) = args

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WordAdapter(letter, requireContext())

        recyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )

        requireActivity().title = "${getString(R.string.detail_prefix)} $letter"

        return binding.root
    }

    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
}