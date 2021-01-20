package com.eniola.studyapp.ui.subjects.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eniola.studyapp.R
import com.eniola.studyapp.ui.data.SubjectData
import com.squareup.picasso.Picasso
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

        val iconImageUrl = item.icon
        //load image url into imageView using picasso
        Picasso.get().load(iconImageUrl).placeholder(
            R.drawable.ic_subject_icon).fit().into(holder.subjectIcon)

        holder.subjectItem.setOnClickListener {
            subjectClicked.onSubjectClicked(it, item)
        }

        val mColors = arrayOf(
            "#EA7052", "#7B7FDA", "#F9AD6D", "#68BC98", "#7B7FDA"
        )
        holder.subjectItem.setBackgroundColor(Color.parseColor(mColors[position]))

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