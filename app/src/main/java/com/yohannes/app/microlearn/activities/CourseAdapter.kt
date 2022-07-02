package com.yohannes.app.microlearn.activities

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yohannes.app.microlearn.R
import com.yohannes.app.microlearn.models.Course

class CourseAdapter(var context: Context, private val items: List<Course>)
    : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.course_horizontal_list_item, null)
        return CourseViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val currentCourse = items[position]
        holder.title.text = currentCourse.title
        val currentDescription = "${currentCourse.instructor.name} • ${currentCourse.uploadedDate} • ${currentCourse.estimatedHours}"
        holder.description.text = currentDescription
        holder.ratingBar.rating = currentCourse.averageRating
        Glide.with(context).load(currentCourse.backDropPictureUrl).into(holder.backdropView)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CourseDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CourseViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var holderView: View
        var backdropView: ImageView
        var title: TextView
        var description: TextView
        var ratingBar: RatingBar

        init {
            this.title = itemView.findViewById(R.id.course_title_horizontal)
            this.backdropView = itemView.findViewById(R.id.course_background_horizontal)
            this.description = itemView.findViewById(R.id.course_description_horizontal)
            this.ratingBar = itemView.findViewById(R.id.course_ratingBar)
            this.holderView = itemView
        }
    }
}