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
import com.sorted.pro.adapter.CustomAdapter
import com.sorted.pro.databinding.FragmentResultBinding
import com.sorted.pro.model.ResultModel

class ResultFragment : Fragment(), CustomAdapter.ListItemClickListener {


    private var listener: OnFragmentInteractionListener? = null
    private var binding: FragmentResultBinding? = null
    private var mArrayResult: ArrayList<Any>? = null
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mArrayResult = ArrayList()
        mArrayResult!!.add(ResultModel("Maths", "30-06-2018", 370.0, 500.0, "OCE16", "Pass"))
        mArrayResult!!.add(ResultModel("Physics", "31-06-2018", 360.0, 500.0, "OCE16", "Pass"))
        mArrayResult!!.add(ResultModel("Chemistry", "3-06-2018", 320.0, 500.0, "OCE16", "Pass"))
        mArrayResult!!.add(ResultModel("Biology", "28-06-2018", 310.0, 500.0, "OCE16", "Pass"))
        mArrayResult!!.add(ResultModel("English", "29-06-2018", 420.0, 500.0, "OCE16", "Pass"))
        val layoutManager = LinearLayoutManager(activity)
        binding!!.contentResult!!.resultRV.setLayoutManager(layoutManager)
        val adapter = CustomAdapter(mArrayResult!!, activity!!, this)
        binding!!.contentResult!!.resultRV.adapter = adapter
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
