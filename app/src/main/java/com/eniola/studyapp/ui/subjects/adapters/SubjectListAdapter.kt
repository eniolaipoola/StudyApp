package com.eniola.studyapp.ui.subjects.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eniola.studyapp.R
import com.eniola.studyapp.ui.data.SubjectData
import kotlinx.android.synthetic.main.item_all_subjects.view.*

class SubjectListAdapter(private val subjectClicked: SubjectClickedListener)
    : RecyclerView.Adapter<SubjectListAdapter.TransactionViewHolder>() {

    private var subjectList = mutableListOf<SubjectData>()

    fun setListItems(subjectData: List<SubjectData>){
        subjectList.clear()
        subjectList.addAll(subjectData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_all_subjects, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = subjectList[position]
        holder.subjectTitle.text = item.name
/*
        if(images.size != 0){
            //load image url into imageView using picasso
            val bookImageUrl = item.images[1].url
            Picasso.get().load(bookImageUrl).placeholder(
                R.drawable.ic_tj_image_placeholder).fit().into(holder.bookImage)
        }
*/

        holder.subjectItem.setOnClickListener {
            subjectClicked.onSubjectClicked(it, item)
        }
    }

    class TransactionViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {
        val subjectTitle: TextView = view.subject_title
        val subjectIcon = view.subject_icon
        val subjectItem = view.subjectItem
    }

    interface SubjectClickedListener {
        fun onSubjectClicked(view: View, item: SubjectData)
    }

}