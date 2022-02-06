package com.chanpreet.todoister.util;

import android.widget.ProgressBar;

import androidx.room.TypeConverter;

import com.chanpreet.todoister.model.Priority;

import java.util.Date;


public class Converter {
    @TypeConverter()
    public Date timestampToDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter()
    public Long DateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter()
    public Priority toPriority(String priority) {
        return priority == null ? null : Priority.valueOf(priority);
    }

    @TypeConverter()
    public String fromPriority(Priority priority) {
        return priority == null ? null : priority.name();
    }
}
