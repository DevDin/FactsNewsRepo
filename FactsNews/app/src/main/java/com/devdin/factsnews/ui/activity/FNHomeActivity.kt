package com.devdin.factsnews.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdin.factsnews.R
import com.devdin.factsnews.datamodel.FNFactResponse
import com.devdin.factsnews.network.FNRestCallback
import com.devdin.factsnews.network.FNRestClient
import com.devdin.factsnews.ui.adapter.FNRecyclerAdapter
import com.devdin.factsnews.utils.Constants
import com.devdin.factsnews.utils.TestDataProvider
import kotlinx.android.synthetic.main.activity_home.*


class FNHomeActivity : FNBaseActivity(), FNRestCallback<FNFactResponse> {
    private lateinit var response: FNFactResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.title = getString(R.string.app_name)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //cal getData() when user pulls the swipe refresh view
        pullToRefresh.setOnRefreshListener {
            pullToRefresh.isRefreshing = true
            getData()
        }
        getData()
    }

    override fun onSuccess(response: FNFactResponse?) {
        pullToRefresh.isRefreshing = false
        refreshList()

    }

    override fun onFailure() {
        pullToRefresh.isRefreshing = false
        Toast.makeText(this, "API call failed", Toast.LENGTH_LONG).show()
    }

    private fun getData() {
        if (Constants.MOCK_API) {
            response = TestDataProvider.getData(this)
            pullToRefresh.isRefreshing = false
            refreshList()
        } else {
            FNRestClient.getFacts(this)
        }
    }

    private fun refreshList() {
        if (response != null && response.rows != null) {
            supportActionBar!!.title = response.title
            recyclerView.adapter = FNRecyclerAdapter(response.rows, this)
        }
    }
}
