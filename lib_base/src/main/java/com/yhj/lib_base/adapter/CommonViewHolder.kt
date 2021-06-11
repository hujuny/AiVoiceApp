package com.yhj.lib_base.adapter

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/11
 *    @desc   :
 */
class CommonViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew) {


    private var mViews: SparseArray<View?> = SparseArray()

    companion object {

        fun getViewHolder(parent: ViewGroup, layoutId: Int): CommonViewHolder {

//          val binding:T=  DataBindingUtil.inflate(LayoutInflater.from(parent.context),layoutId,parent,false)
            val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
            return CommonViewHolder(itemView)
        }
    }

    private fun getView(viewId: Int): View {
        var view = mViews[viewId]
        if (view == null) {
            view = itemView.findViewById(viewId)
            mViews.put(viewId, view)
        }

        return view!!
    }

    fun setText(viewId: Int, text: String) {
        (getView(viewId) as TextView).text = text
    }

    fun setImageResource(viewId: Int, resId: Int) {
        (getView(viewId) as ImageView).setImageResource(resId)
    }

}