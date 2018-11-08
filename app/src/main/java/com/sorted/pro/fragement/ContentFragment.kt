package com.sorted.pro.fragement

import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import assure.mw.com.interfaces.OnFragmentInteractionListener

import com.sorted.pro.R
import com.sorted.pro.databinding.FragmentContentBinding
import com.sorted.pro.databinding.FragmentRateBinding
import android.widget.ArrayAdapter
import com.sorted.pro.adapter.CustomAdapter
import com.sorted.pro.model.RatingModel
import android.R.attr.country
import android.widget.AdapterView


class ContentFragment : Fragment(), CustomAdapter.ListItemClickListener, AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onItemClickListener(clickedPosition: Int) {

    }

    private var listener: OnFragmentInteractionListener? = null
    private var binding: FragmentContentBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_content, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewVariable()
    }

    fun initializeViewVariable() {
        val categories = ArrayList<String>()
        categories.add("Automobile")
        categories.add("Business Services")
        categories.add("Computers")
        categories.add("Education")
        categories.add("Personal")
        categories.add("Travel")

        binding!!.main1SP.setOnItemSelectedListener(this)

        //Creating the ArrayAdapter instance having the country list
        val aa = ArrayAdapter(activity, android.R.layout.simple_spinner_item, categories)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //Setting the ArrayAdapter data on the Spinner
        binding!!.main1SP.setAdapter(aa)
        binding!!.main2SP.setAdapter(aa)
        binding!!.main3SP.setAdapter(aa)
        binding!!.submitBT.setOnClickListener(View.OnClickListener {
            val someFragment = QuestionFragment()
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.content_frame, someFragment) // give your fragment container id in first parameter
            transaction.addToBackStack(null)  // if written, this transaction will be added to backstack
            transaction.commit()
        })
    }

    fun initializeVariable() {

    }

    fun initializeView() {

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    companion object {

    }
}
