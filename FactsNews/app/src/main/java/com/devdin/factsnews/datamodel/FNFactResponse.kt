package com.devdin.factsnews.datamodel

import com.google.gson.annotations.SerializedName

/* data classes don't require any functions*/
data class FNFactResponse(
    @SerializedName("title")
    var title: String="",
    @SerializedName("rows")
    var rows: List<FNFactResponseRow> = listOf()
)

data class FNFactResponseRow(
    @SerializedName( "title")
    var title: String = "",
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("imageHref")
    var imageHref: String = ""


)