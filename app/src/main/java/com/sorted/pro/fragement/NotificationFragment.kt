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
import com.sorted.pro.databinding.FragmentNotificationBinding
import com.sorted.pro.model.NotificationModel


class NotificationFragment : Fragment(), CustomAdapter.ListItemClickListener {
    override fun onItemClickListener(clickedPosition: Int) {

    }

    private var listener: OnFragmentInteractionListener? = null
    private var binding: FragmentNotificationBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        binding!!.notificationList.setLayoutManager(layoutManager)
        var mArticles: ArrayList<Any> = ArrayList()
        for (i in 0 until 5) {
            mArticles.add(NotificationModel( "Math class is shifted to morning at 9Am", "22-jul-2018","123"))
        }
        val adapter = CustomAdapter(mArticles, activity!!, this)
        binding!!.notificationList.adapter = adapter
    }

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

    }
}
