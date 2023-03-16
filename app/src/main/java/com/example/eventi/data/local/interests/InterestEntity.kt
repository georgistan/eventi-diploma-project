package com.example.eventi.data.local.interests

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class InterestEntity(
    @PrimaryKey
    var id: Int = 0,
    @Required
    var content: String = ""
) : RealmObject()