package com.haretskiy.pavel.bsuirschedule

import android.app.Activity
import com.haretskiy.pavel.bsuirschedule.di.AppComponent

val Activity.daggerComponent: AppComponent
    get() {
        return (applicationContext as App).daggerComponent
    }