package com.devdin.factsnews.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdin.factsnews.R
import com.devdin.factsnews.datamodel.FNFactResponse
import com.devdin.factsnews.ui.adapter.FNRecyclerAdapter
import com.devdin.factsnews.utils.TestDataProvider
import kotlinx.android.synthetic.main.activity_home.*

class FNHomeActivity : FNBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var response: FNFactResponse = TestDataProvider.getData(this)

        recyclerView.adapter = FNRecyclerAdapter(response.rows, this)
    }
}
