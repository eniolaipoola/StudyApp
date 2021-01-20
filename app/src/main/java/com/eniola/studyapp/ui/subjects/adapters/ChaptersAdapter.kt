package com.eniola.studyapp.ui.subjects.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eniola.studyapp.R
import com.eniola.studyapp.ui.data.Chapters
import com.eniola.studyapp.ui.data.Lessons
import kotlinx.android.synthetic.main.item_all_chapters.view.*

class ChaptersAdapter(val listener: LessonsAdapter.LessonClickedListener)
    : RecyclerView.Adapter<ChaptersAdapter.ChaptersViewModel>(),
    LessonsAdapter.LessonClickedListener {

    private var chapterList = mutableListOf<Chapters>()

    fun setListItems(subjectData: List<Chapters>){
        chapterList.clear()
        chapterList.addAll(subjectData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChaptersViewModel {
        return ChaptersViewModel(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_all_chapters, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return chapterList.size
    }

    override fun onBindViewHolder(holder: ChaptersViewModel, position: Int) {
        val item = chapterList[position]
        holder.chapterTitle.text = item.name
        val allLessonsInChapter = item.lessons

        //populate lesson recyclerview
        val lessonLayoutManager = LinearLayoutManager(
            holder.lessonRecyclerView.context, LinearLayoutManager.HORIZONTAL, false)

        val lessonsAdapter by lazy { LessonsAdapter(this) }
        allLessonsInChapter?.let { lessonsAdapter.setLessonItems(allLessonsInChapter) }
        holder.lessonRecyclerView.layoutManager = lessonLayoutManager
        holder.lessonRecyclerView.adapter = lessonsAdapter


    }

    class ChaptersViewModel(view: View)
        : RecyclerView.ViewHolder(view) {
        val chapterTitle = view.chapter_title
        val lessonRecyclerView = view.chapter_lessons_recyclerview
    }

    override fun onLessonClicked(view: View, item: Lessons) {
        //navigate to play video page

        val mediaUrl = item.media_url
        Log.d("tag", "lesson clicked is " + item.name)
        Log.d("tag", "media url is " + item.media_url)

        //pass media url to play video page

    }
}