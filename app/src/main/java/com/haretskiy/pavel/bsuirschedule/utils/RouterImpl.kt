package com.haretskiy.pavel.bsuirschedule.utils

import android.content.Intent
import com.haretskiy.pavel.bsuirschedule.BUNDLE_KEY_NUMBER_GROUP
import com.haretskiy.pavel.bsuirschedule.ui.activities.BaseActivity
import com.haretskiy.pavel.bsuirschedule.ui.activities.GroupsActivity
import com.haretskiy.pavel.bsuirschedule.ui.activities.ScheduleActivity
import javax.inject.Inject

class RouterImpl @Inject constructor(private val activity: BaseActivity) : Router {

    override fun startScheduleActivity(numberOfGroup: String) {
        val intent = Intent(activity, ScheduleActivity::class.java)
        intent.putExtra(BUNDLE_KEY_NUMBER_GROUP, numberOfGroup)
        activity.startActivity(intent)
    }

    override fun startGroupsActivity() {
        val intent = Intent(activity, GroupsActivity::class.java)
        activity.startActivity(intent)
    }
}