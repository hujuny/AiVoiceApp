package com.yhj.lib_base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/11
 *    @desc   :
 */
open class CommonAdapter<T> : RecyclerView.Adapter<CommonViewHolder> {

    private var mList: List<T>
    private var onBindDataListener: OnBindDataListener<T>? = null
    private var onMoreBindDataListener: OnMoreBindDataListener<T>? = null

    constructor(mList: List<T>, onBindDataListener: OnBindDataListener<T>) {
        this.mList = mList
        this.onBindDataListener = onBindDataListener
    }

    constructor(mList: List<T>, onMoreBindDataListener: OnMoreBindDataListener<T>) {
        this.mList = mList
        this.onBindDataListener = onMoreBindDataListener
        this.onMoreBindDataListener = onMoreBindDataListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        val layoutId = onBindDataListener?.getLayoutId(viewType)
        return CommonViewHolder.getViewHolder(parent, layoutId!!)
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        onBindDataListener?.onBindViewHolder(
            mList[position],
            holder,
            getItemViewType(position),
            position
        )
    }

    override fun getItemViewType(position: Int): Int {
        if (onMoreBindDataListener != null) {
            return onMoreBindDataListener!!.getItemType(position)
        }
        return 0
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    interface OnBindDataListener<T> {

        fun onBindViewHolder(model: T, viewHolder: CommonViewHolder, type: Int, position: Int)
        fun getLayoutId(type: Int): Int
    }

    interface OnMoreBindDataListener<T> : OnBindDataListener<T> {

        fun getItemType(position: Int): Int
    }
}