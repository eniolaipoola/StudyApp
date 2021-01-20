package com.eniola.studyapp.ui.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 20-Jan-2021
 */

@Parcelize
data class SubjectResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("subjects")
    val subjects: List<SubjectData>
): Parcelable

@Entity
@Parcelize
data class SubjectData(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("chapters")
    val chapters: List<Chapters>?
): Parcelable

@Entity
@Parcelize
data class Chapters(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("lessons")
    val lessons: List<Lessons>?
): Parcelable

@Entity
@Parcelize
data class Lessons(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("media_url")
    val media_url: String,
    @SerializedName("subject_id")
    val subject_id: Int,
    @SerializedName("chapter_id")
    val chapter_id: Int
): Parcelable