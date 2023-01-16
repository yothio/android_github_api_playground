package com.example.github_api

import android.os.Bundle
import android.util.Log
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.github_api.adapter.GithubRecycleViewAdapter
import com.example.github_api.network.Api
import com.example.github_api.network.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

val TAG = "yothio"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataset: MutableList<Repository> = mutableListOf()
        val recycler: RecyclerView = findViewById(R.id.item_recycler)

        findViewById<Switch>(R.id.switch1).setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                CoroutineScope(Dispatchers.IO).launch {
                    val result = Api.main().getRepositories()

                    if(result.isSuccessful){
                        Log.d(TAG, "onCreate sucess: ${result.body().toString()}")
                        result.body()?.onEach {
                            dataset.add(it)
                        }
                        withContext(Dispatchers.Main) {
                            recycler.adapter?.notifyDataSetChanged()
                        }
                    }else{
                        Log.d(TAG, "onCreate error: ${result.errorBody().toString()}")
                    }
                }
            }else{
                dataset.clear()
                recycler.adapter?.notifyDataSetChanged()
            }
        }

        recycler.adapter = GithubRecycleViewAdapter(dataset)
        recycler.layoutManager = LinearLayoutManager(this)
    }
}