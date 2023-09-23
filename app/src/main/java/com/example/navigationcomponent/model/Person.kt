package com.example.navigationcomponent.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(val name: String, val age: Int, val street: String, val number: Int): Parcelable