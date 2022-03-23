package com.example.challange3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Salmon (
    val length : Double?,
    val weight : Double?,
    val quality : Double?,
    val type : Boolean?
    ) : Parcelable