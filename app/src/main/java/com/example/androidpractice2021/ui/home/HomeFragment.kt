package com.example.androidpractice2021.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.androidpractice2021.R
import com.example.androidpractice2021.application.CharacterApplication
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.domain.FindAllCharacterUseCase
import com.example.androidpractice2021.domain.FindCharacterByIdUseCase
import com.example.androidpractice2021.domain.FindCharacterByNameUseCase
import com.example.androidpractice2021.ui.home.recyclerview.CharacterAdapter
import kotlinx.android.synthetic.main.character_item.*
import kotlinx.android.synthetic.main.fragment_characters.*
import kotlinx.coroutines.Dispatchers

class HomeFragment : Fragment() {

    private var characterList: ArrayList<Character> = arrayListOf()
    private lateinit var application: CharacterApplication
    private lateinit var adapter: CharacterAdapter


    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        application = activity?.application as (CharacterApplication)
        homeViewModel =
                ViewModelProvider(this, initFactory()).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_characters, container, false)
        return root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    @SuppressLint("ResourceType")
    private fun initList() {
        val list = character_list
        val bundle = Bundle()
        (view?.parent as? ViewGroup)?.doOnPreDraw {
            startPostponedEnterTransition()
        }
        if (characterList.size != 0) {
            adapter =
                    CharacterAdapter(
                            characterList
                    ) {
                        bundle.putInt("id", it)
                        val extras = FragmentNavigatorExtras(
                                image_character to "example2_transition"
                        )
                        findNavController().navigate(
                                R.id.action_navigation_home_to_navigation_detail_character,
                                bundle,
                                null,
                                extras
                        )
                    }

            list.adapter = adapter
            adapter.submitList(characterList)
            adapter.notifyDataSetChanged()
        }
    }

    private fun initFactory() = ViewModelFactory(
            findAllCharacterUseCase = FindAllCharacterUseCase(
                    application.repository, Dispatchers.IO
            ),
            findCharacterByIdUseCase = FindCharacterByIdUseCase(
                    application.repository, Dispatchers.IO
            ),
            findCharacterByNameUseCase = FindCharacterByNameUseCase(
                    application.repository, Dispatchers.IO
            )
    )

    private fun initSubscribes() {
        with(homeViewModel) {
            progress().observe(viewLifecycleOwner, Observer {
                characterList = it as ArrayList<Character>
                initList()
            })
        }
    }

    private fun initListeners() {
        homeViewModel.onClick()
        initSubscribes()
    }
}