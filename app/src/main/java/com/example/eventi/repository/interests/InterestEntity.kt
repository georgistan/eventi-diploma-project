package com.example.eventi.repository.interests

import io.realm.RealmObject

open class InterestEntity(
    var content: String = ""
) : RealmObject()
