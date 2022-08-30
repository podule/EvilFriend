package com.galia.evilfriend.data.converter

import androidx.room.TypeConverter
import java.util.*

class DateTypeConverter {
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(mls: Long?): Date? {
        return mls?.let {
            Date(it)
        }
    }

}