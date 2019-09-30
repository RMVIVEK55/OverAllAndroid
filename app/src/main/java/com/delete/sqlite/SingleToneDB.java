package com.delete.sqlite;

import android.content.Context;
import android.provider.ContactsContract;

public  class SingleToneDB {
   static private Database sql=null;
    static public Database getInstance(Context c)
    {
        if(sql==null)
            return new Database(c);
        else
            return sql;
    }
}
