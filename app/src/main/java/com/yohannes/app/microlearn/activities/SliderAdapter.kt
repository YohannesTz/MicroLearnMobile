package com.yohannes.app.microlearn.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import com.yohannes.app.microlearn.R
import com.yohannes.app.microlearn.models.SliderItem

class SliderAdapter(var context: Context) : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    var mSliderItems : ArrayList<SliderItem> = ArrayList()

    fun renewItems(sliderItems: List<SliderItem>) {
        this.mSliderItems = sliderItems as ArrayList<SliderItem>
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        this.mSliderItems.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(item: SliderItem) {
        this.mSliderItems.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup) : SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.slider_item_layout, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val currentItem = mSliderItems.get(position)

        viewHolder.courseTitle.text = currentItem.description
        Glide.with(viewHolder.holderView)
            .load(currentItem.imageUrl)
            .fitCenter()
            .into(viewHolder.backdropImageView)
    }

    override fun getCount(): Int {
        return mSliderItems.size
    }

    class SliderAdapterVH (itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        var holderView:View
        var backdropImageView:ImageView
        var courseTitle: TextView

        init {
            this.backdropImageView = itemView.findViewById(R.id.course_backdrop)
            this.courseTitle = itemView.findViewById(R.id.slider_title)
            this.holderView = itemView
        }
    }
}