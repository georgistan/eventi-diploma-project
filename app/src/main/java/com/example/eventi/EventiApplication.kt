package com.example.eventi

import android.app.Application
//import com.example.eventi.datasource.object_box.ObjectBox
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm

@HiltAndroidApp
class EventiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}