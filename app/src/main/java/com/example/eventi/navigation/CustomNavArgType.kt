package com.example.eventi.navigation

import android.os.Bundle
import androidx.navigation.NavType
import com.example.eventi.components.home_screen.Event
import com.google.gson.Gson

abstract class JsonNavType<T> : NavType<T>(isNullableAllowed = false) {
    abstract fun fromJsonParse(value: String): T
    abstract fun T.getJsonParse(): String

    override fun get(bundle: Bundle, key: String): T? =
        bundle.getString(key)?.let { parseValue(it) }

    override fun parseValue(value: String): T = fromJsonParse(value)

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putString(key, value.getJsonParse())
    }
}

class EventArgType : JsonNavType<Event>() {
    override fun fromJsonParse(value: String): Event = Gson().fromJson(value, Event::class.java)

    override fun Event.getJsonParse(): String = Gson().toJson(this)
}