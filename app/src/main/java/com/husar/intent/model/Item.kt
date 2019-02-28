package com.husar.intent.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(var title: String, var description: String) : Parcelable