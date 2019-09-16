package com.example.android_level3_assignment2.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//TODO IDE is complaining but it still compiles, this is a know bug with the Parcelize..
@Parcelize
data class Site (
    var title: String,
    var url: String
): Parcelable