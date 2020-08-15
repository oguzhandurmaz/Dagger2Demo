package com.example.dagger2demo.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2demo.R
import com.example.dagger2demo.Result
import com.example.dagger2demo.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ProfileFragment: DaggerFragment(){

    private lateinit var viewModel: ProfileViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Toast.makeText(requireActivity(),"Profile Fragment",Toast.LENGTH_SHORT).show()


        return inflater.inflate(R.layout.fragment_profile,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,providerFactory).get(ProfileViewModel::class.java)
    }

    private fun subscribeObservers(){
        viewModel.getAuthenticatedUser().removeObservers(viewLifecycleOwner)
        viewModel.getAuthenticatedUser().observe(viewLifecycleOwner, Observer {
            it?.let{
                when(it){
                    is Result.Authed -> {
                        //setUserDetail(it.)
                    }
                    is Result.Error -> {

                    }
                }
            }
        })
    }
}