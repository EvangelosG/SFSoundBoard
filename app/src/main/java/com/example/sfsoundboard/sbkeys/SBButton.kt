package com.example.sfsoundboard.sbkeys

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SBButton (
    val icon : Int?,
    val name : String?,
    val sounds : MutableList<Int?>?
) : Parcelable