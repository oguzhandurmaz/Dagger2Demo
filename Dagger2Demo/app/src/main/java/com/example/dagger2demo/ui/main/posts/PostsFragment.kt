package com.example.dagger2demo.ui.main.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2demo.R
import com.example.dagger2demo.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

class PostsFragment: DaggerFragment() {

    private lateinit var viewModel: PostsViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var adapter: PostsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,providerFactory).get(PostsViewModel::class.java)

        recycler_view.layoutManager = LinearLayoutManager(requireActivity())

        recycler_view.adapter = adapter



    }
}