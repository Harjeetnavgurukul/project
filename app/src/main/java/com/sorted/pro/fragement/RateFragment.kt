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
import android.widget.Toast
import assure.mw.com.interfaces.OnFragmentInteractionListener

import com.sorted.pro.R
import com.sorted.pro.activity.ChoiceActivity
import com.sorted.pro.adapter.CustomAdapter
import com.sorted.pro.databinding.FragmentRateBinding
import com.sorted.pro.model.NotificationModel
import com.sorted.pro.model.RatingModel
import com.sorted.pro.model.RatingParameters


class RateFragment : Fragment(), CustomAdapter.ListItemClickListener {
    var mArticles: ArrayList<Any> = ArrayList()
    var mRatingModel: RatingModel? = null
    var mArrayRatingParameter: ArrayList<RatingParameters>? = null
    private var listener: OnFragmentInteractionListener? = null
    private var binding: FragmentRateBinding? = null
    override fun onItemClickListener(clickedPosition: Int) {
        Toast.makeText(activity, "Clicked Position " + clickedPosition, Toast.LENGTH_SHORT).show()
        (activity as ChoiceActivity).mRatingModelAct = mArticles.get(clickedPosition) as RatingModel
        val someFragment = RateOnParameter()
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.content_frame, someFragment) // give your fragment container id in first parameter
        transaction.addToBackStack(null)  // if written, this transaction will be added to backstack
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rate, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        binding!!.contentRating!!.ratingRV.setLayoutManager(layoutManager)
        mArrayRatingParameter = ArrayList()
//       Rearranging the parameter models
//        for (i in 0 until 3) {
        mArrayRatingParameter!!.add(RatingParameters("Knowledge ", 5))
        mArrayRatingParameter!!.add(RatingParameters("Teaching Style", 5))
        mArrayRatingParameter!!.add(RatingParameters("Behaviour ", 4))
        mArrayRatingParameter!!.add(RatingParameters("Problem Solving ", 4))
        mArrayRatingParameter!!.add(RatingParameters("Attention ", 4))

//        }
        for (i in 0 until 5) {
            mArticles.add(RatingModel("Shyam Singh ", "Done phd from IIT ", 3, "physics", mArrayRatingParameter!!))
        }
        val adapter = CustomAdapter(mArticles, activity!!, this)
        binding!!.contentRating!!.ratingRV.adapter = adapter
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


    companion object {
//
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//                RateFragment().apply {
//                    arguments = Bundle().apply {
//
//                    }
//                }
    }
}
