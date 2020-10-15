package com.fmohammadi.newsappmvvm.db

import androidx.room.TypeConverter
import com.fmohammadi.newsappmvvm.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toString(name: String): Source {
        return Source(name, name)
    }
}