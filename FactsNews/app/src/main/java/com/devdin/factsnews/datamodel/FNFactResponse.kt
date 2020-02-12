package com.devdin.factsnews.datamodel

/* data classes don't require any functions*/
data class FNFactResponse(var title: String?, var rows: List<FNFactResponseRow>)

data class FNFactResponseRow(
    var title: String? = null, var description: String? = null, var imageHref: String? = null


)