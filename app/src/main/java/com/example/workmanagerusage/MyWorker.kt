package com.example.workmanagerusage

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context, workerParameters: WorkerParameters):Worker(appContext,workerParameters) {
    override fun doWork(): Result {
        val total = 10+20
        Log.e("Background process result",total.toString())
        return Result.success()
    }
}