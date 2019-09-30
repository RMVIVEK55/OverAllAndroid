package com.room;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@androidx.room.Dao
public interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   long InsertRec(Entity entity);

@Query("SELECT * FROM triLeave")
List<Entity> selAll();

    @Query("DELETE FROM triLeave WHERE id = :e")
    int delREc(int e);

    @Query("UPDATE triLeave SET  name = :name WHERE id = :alive")
     int setIsAliveByName(String name, int alive);
}
