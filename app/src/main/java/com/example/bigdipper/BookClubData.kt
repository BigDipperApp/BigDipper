package com.example.bigdipper

import java.io.Serializable

data class BookClubData(val clubImg: String, val creatorName: String,  val clubName:String, val tags: ArrayList<String>, val clubDetails: String, val memberNum: String): Serializable {
}