package com.sorted.pro.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sorted.pro.R
import com.sorted.pro.databinding.*
import com.sorted.pro.model.NotificationModel
import com.sorted.pro.model.RatingModel
import com.sorted.pro.model.RatingParameters
import com.sorted.pro.model.ResultModel
import com.sorted.pro.mvvmodel.NotifiViewModel
import com.sorted.pro.mvvmodel.RateOnParamViewModel
import com.sorted.pro.mvvmodel.RatingViewModel
import com.sorted.pro.mvvmodel.ResultViewModel

class CustomAdapter constructor(val mArticles: ArrayList<Any>, val mContext: Context, val listener: ListItemClickListener) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_NOTIFICATIONMODEL = 0
    private val TYPE_RATING_MODEL = 1
    private val TYPE_RATE_PARA_MODEL = 2
    private val TYPE_RESULT_MODEL = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == TYPE_NOTIFICATIONMODEL) {
            val binding: ContentNotifiactionLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.content_notifiaction_layout, parent, false)
            return NotificationHolder(binding, viewType)
        } else if (viewType == TYPE_RATING_MODEL) {
            val binding: ContentRatingRvBinding = DataBindingUtil.inflate(inflater, R.layout.content_rating_rv, parent, false)
            return RatingHolder(binding, viewType)
        } else if (viewType == TYPE_RESULT_MODEL) {
            val binding: ContentResultRvBinding = DataBindingUtil.inflate(inflater, R.layout.content_result_rv, parent, false)
            return ResultParamHolder(binding, viewType)
        } else {
//            Not necessary need to change
            val binding: ContentRateOnParamRvBinding = DataBindingUtil.inflate(inflater, R.layout.content_rate_on_param_rv, parent, false)
            return RatingParamHolder(binding, viewType)
        }
    }

    override fun getItemCount(): Int {
        return mArticles.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mArticles.get(position) is NotificationModel) {
            holder as NotificationHolder
            holder.binding.setNvm(NotifiViewModel(mArticles.get(position) as NotificationModel, mContext))
            holder.bind()
        } else if (mArticles.get(position) is RatingModel) {
            holder as RatingHolder
            holder.binding.setRatevm(RatingViewModel(mArticles.get(position) as RatingModel, mContext))
            holder.bind()
        } else if (mArticles.get(position) is RatingParameters) {
            holder as RatingParamHolder
            holder.binding.setRatepvm(RateOnParamViewModel(mArticles.get(position) as RatingParameters, mContext))
            holder.bind()
        } else if (mArticles.get(position) is ResultModel) {
            holder as ResultParamHolder
            holder.binding.setResvm(ResultViewModel(mArticles.get(position) as ResultModel, mContext))
        }
    }

    val listener1: ListItemClickListener = this.listener;
    val context: Context = this.mContext
    override fun getItemViewType(position: Int): Int {
        if (mArticles.get(position) is NotificationModel) {
            return TYPE_NOTIFICATIONMODEL
        } else if (mArticles.get(position) is RatingModel) {
            return TYPE_RATING_MODEL
        } else if (mArticles.get(position) is ResultModel) {
            return TYPE_RESULT_MODEL
        }
        return TYPE_RATE_PARA_MODEL
    }

    interface ListItemClickListener {
        fun onItemClickListener(clickedPosition: Int)
    }

    inner class NotificationHolder(val view: ContentNotifiactionLayoutBinding, val type: Int) : RecyclerView.ViewHolder(view.root) {
        var binding: ContentNotifiactionLayoutBinding = this.view


        fun bind() {
            binding.root.setOnClickListener(View.OnClickListener {
                listener1.onItemClickListener(adapterPosition)
            })

        }

    }

    inner class RatingHolder(val view: ContentRatingRvBinding, val type: Int) : RecyclerView.ViewHolder(view.root) {
        var binding: ContentRatingRvBinding = this.view


        fun bind() {
            binding.root.setOnClickListener(View.OnClickListener {
                listener1.onItemClickListener(adapterPosition)
            })

        }
    }

    inner class RatingParamHolder(val view: ContentRateOnParamRvBinding, val type: Int) : RecyclerView.ViewHolder(view.root) {
        var binding: ContentRateOnParamRvBinding = this.view


        fun bind() {
            binding.root.setOnClickListener(View.OnClickListener {
                listener1.onItemClickListener(adapterPosition)
            })

        }
    }

    inner class ResultParamHolder(val view: ContentResultRvBinding, val type: Int) : RecyclerView.ViewHolder(view.root) {
        var binding: ContentResultRvBinding = this.view


        fun bind() {
            binding.root.setOnClickListener(View.OnClickListener {
                listener1.onItemClickListener(adapterPosition)
            })

        }
    }

}