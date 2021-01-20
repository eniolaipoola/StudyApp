package com.eniola.studyapp.ui.subjects.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eniola.studyapp.R
import com.eniola.studyapp.ui.data.Lessons
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_lessons.view.*

class LessonsAdapter(private val lessonsClickedListener: LessonClickedListener)
    : RecyclerView.Adapter<LessonsAdapter.LessonViewModel>() {

    private var lessonList = mutableListOf<Lessons>()

    fun setLessonItems(lessonData: List<Lessons>){
        lessonList.clear()
        lessonList.addAll(lessonData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewModel {
        return LessonViewModel(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lessons, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }

    override fun onBindViewHolder(holder: LessonViewModel, position: Int) {
        val item = lessonList[position]
        val lessonName = item.name
        holder.lessonTitle.text = lessonName

        val lessonImageUrl = item.icon
        //load image url into imageView using picasso
        Picasso.get().load(lessonImageUrl).placeholder(
            R.drawable.ic_subject_icon).fit().into(holder.lessonIcon)

        holder.lessonItem.setOnClickListener {
            lessonsClickedListener.onLessonClicked(it, item)
        }
    }

    class LessonViewModel(view: View)
        : RecyclerView.ViewHolder(view) {
        val lessonIcon = view.lesson_icon
        val lessonTitle = view.lesson_title
        val lessonItem = view.lessonItem
    }

    interface LessonClickedListener {
        fun onLessonClicked(view: View, item: Lessons)
    }

}