package com.adityawasnik.androidcoroutinemvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adityawasnik.androidcoroutinemvvm.adapter.RecyclerViewAdapter
import com.adityawasnik.androidcoroutinemvvm.model.RecycleList
import com.adityawasnik.androidcoroutinemvvm.viewmodel.MainActivityViewModel


class RecyclerListFragment : Fragment() {

    private lateinit var recyclerViewAdapter : RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recycler_list, container, false)
        initViewModel(view)
        initViewModel()
    return view
    }

    private fun initViewModel(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decortion = DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decortion)

        recyclerViewAdapter = RecyclerViewAdapter()

        recyclerView.adapter = recyclerViewAdapter
    }
    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner,Observer<RecycleList>{
            if(it != null){
                recyclerViewAdapter.setUpdateData(it.items)
            } else {
                Toast.makeText(activity,"Error in getting data",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiApiCall()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RecyclerListFragment().apply {

            }
    }
}