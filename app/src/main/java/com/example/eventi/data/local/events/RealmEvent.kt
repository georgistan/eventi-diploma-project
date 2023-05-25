package com.example.eventi.data.local.events

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class RealmEvent(
        @PrimaryKey
        var id: String = "",
        var title: String = "",
        var description: String = "",
        var category: String = "",
        var startsAt: String = "",
        var predictedEnd: String = "",
        var rank: Int = 0,
        var address: String = "",
        var isAttended: Boolean = false
) : RealmObject()