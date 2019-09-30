package com.room;

import androidx.room.ColumnInfo;
import androidx.room.Fts3;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "triLeave")
public class Entity {
    @PrimaryKey(autoGenerate =false)
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "marks")
    public int values;
    @ColumnInfo(name = "name")
    public String StrName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

    public String getStrName() {
        return StrName;
    }

    public void setStrName(String strName) {
        StrName = strName;
    }
}
