package com.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;


public class SingletenDB {
   public static DatabaseRoom singleToneDB=null;
   static Migration migration=new Migration(1,2) {
       @Override
       public void migrate(@NonNull SupportSQLiteDatabase database) {

       }
   };
   static DatabaseRoom getDb(Context c)
   {
       if(singleToneDB==null)
       {
           singleToneDB = Room.databaseBuilder(c, DatabaseRoom.class,"TriLeave_db")
.fallbackToDestructiveMigration()
                .allowMainThreadQueries()

                   .build();
           return singleToneDB;
       }
       return singleToneDB;
   }

}
