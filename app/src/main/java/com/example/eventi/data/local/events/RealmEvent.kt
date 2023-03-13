package com.example.eventi.data.local.events

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class RealmEvent(
        @PrimaryKey
        var id: String = "",
        var category: String = "",
        var isAttended: Boolean = false
) : RealmObject()