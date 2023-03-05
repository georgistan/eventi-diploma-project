package com.example.eventi.data.local.interests

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class InterestEntity(
    @PrimaryKey
    var id: Int = 0,

    var content: String = ""
) : RealmObject()