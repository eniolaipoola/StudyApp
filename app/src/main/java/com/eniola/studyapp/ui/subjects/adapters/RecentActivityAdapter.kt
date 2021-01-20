package com.eniola.studyapp.ui.subjects.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eniola.studyapp.R
import com.eniola.studyapp.ui.data.RecentActivity
import kotlinx.android.synthetic.main.item_lessons.view.lesson_title
import kotlinx.android.synthetic.main.item_recent_activity.view.*


class RecentActivityAdapter
    : RecyclerView.Adapter<RecentActivityAdapter.RecentActivityViewModel>() {

    private var recentActivityList = mutableListOf<RecentActivity>()

    fun setRecentActivityItem(data: List<RecentActivity>){
        recentActivityList.clear()
        recentActivityList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentActivityViewModel {
        return RecentActivityViewModel(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recent_activity, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return recentActivityList.size
    }

    override fun onBindViewHolder(holder: RecentActivityViewModel, position: Int) {
        val item = recentActivityList[position]
        val lessonName = item.lessonTitle
        holder.lessonTitle.text = lessonName
        holder.subjectTitle.text = item.subjectName

        Glide.with(holder.imagePlaceHolder.context).load("empty")
            .thumbnail(Glide.with(holder.imagePlaceHolder.context).load(item.mediaUrl))
            .into(holder.imagePlaceHolder);

    }

    class RecentActivityViewModel(view: View)
        : RecyclerView.ViewHolder(view) {
        val lessonTitle = view.lesson_title
        val subjectTitle = view.subject_title
        val imagePlaceHolder = view.playerView
    }
}