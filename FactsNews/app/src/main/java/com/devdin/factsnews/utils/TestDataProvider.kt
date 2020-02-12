package com.devdin.factsnews.utils

import com.devdin.factsnews.datamodel.FNFactResponse
import com.devdin.factsnews.datamodel.FNFactResponseRow

class TestDataProvider {
    companion object Data {
        fun getData(count: Int): List<FNFactResponseRow> {
            var item = FNFactResponseRow()
            item.title = "title1"
            item.description = "description1"
            item.imageHref =
                "http://caroldeckerwildlifeartstudio.net/wp-content/uploads/2011/04/IMG_2418%20majestic%20moose%201%20copy%20(Small)-96x96.jpg"
            var list = arrayListOf<FNFactResponseRow>(item)
            return list;
        }
    }
}