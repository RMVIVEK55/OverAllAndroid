package com.room;

import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Entity.class},version = 13)
public abstract class DatabaseRoom extends RoomDatabase {
abstract Dao dao();
}
