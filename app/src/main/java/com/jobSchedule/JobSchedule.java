package com.jobSchedule;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.background.JobIntSErvice;
import com.background.Service;
import com.delete.fulleventbus.R;

public class JobSchedule extends AppCompatActivity {
JobScheduler jobScheduler;
JobInfo jobInfo;
ComponentName componentName;
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_schedule);
        jobScheduler= (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        componentName=new ComponentName(this, JobIntSErvice.class);
        jobInfo=new JobInfo
                .Builder(1,componentName)
               .setPeriodic(5000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(true)
          //      .setRequiresBatteryNotLow(true)
                .setBackoffCriteria(500,JobInfo.BACKOFF_POLICY_LINEAR)
              //  .setMinimumLatency(500)
            //  .setOverrideDeadline(300)
                .build();

        jobScheduler.schedule(jobInfo);



    }
}
