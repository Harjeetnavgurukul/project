package com.sorted.pro.fragement

import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import assure.mw.com.interfaces.OnFragmentInteractionListener

import com.sorted.pro.R
import com.sorted.pro.activity.ChoiceActivity
import com.sorted.pro.adapter.CustomAdapter
import com.sorted.pro.databinding.FragmentRateBinding
import com.sorted.pro.databinding.FragmentRateOnParameterBinding
import com.sorted.pro.model.RatingModel

class RateOnParameter : Fragment(), CustomAdapter.ListItemClickListener {


    // TODO: Rename and change types of parameters

    private var listener: OnFragmentInteractionListener? = null
    private var binding: FragmentRateOnParameterBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onItemClickListener(clickedPosition: Int) {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rate_on_parameter, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        binding!!.rateOnParamRV.setLayoutManager(layoutManager)

        val adapter = CustomAdapter((activity as ChoiceActivity).mRatingModelAct!!.ratingParameters as ArrayList<Any>, activity!!, this)
        binding!!.rateOnParamRV!!.adapter = adapter
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
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

}
