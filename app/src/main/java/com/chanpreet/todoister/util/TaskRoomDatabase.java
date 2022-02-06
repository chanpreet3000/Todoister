package com.chanpreet.todoister.util;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.chanpreet.todoister.model.Task;
import com.chanpreet.todoister.data.TaskDao;

@Database(entities = {Task.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class TaskRoomDatabase extends RoomDatabase {
    private static TaskRoomDatabase Instance;

    public static synchronized TaskRoomDatabase getInstance(Context context) {
        if (Instance == null) {
            Instance = Room.databaseBuilder(context, TaskRoomDatabase.class, Param.TASK_DATABASE_NAME).build();
        }
        return Instance;
    }

    public abstract TaskDao taskDao();
}
