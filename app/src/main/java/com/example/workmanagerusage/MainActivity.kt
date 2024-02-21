package com.example.workmanagerusage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.workmanagerusage.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDo.setOnClickListener {
            /* val workCondition = Constraints.Builder()
                 .setRequiredNetworkType(NetworkType.CONNECTED)
                 .build()

             val request = OneTimeWorkRequestBuilder<MyWorker>()
                 .setInitialDelay(10,TimeUnit.SECONDS)
                 .setConstraints(workCondition)
                 .build()



             WorkManager.getInstance(this).enqueue(request)
             WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this){
                 val state = it.state.name
                 Log.e("Background Process State",state)
             }

              */

            val request = PeriodicWorkRequestBuilder<MyWorkerNotification>(15,TimeUnit.MINUTES)
                .setInitialDelay(10,TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(this).enqueue(request)
        }
    }
}