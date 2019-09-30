package com.delete.fulleventbus;

import org.greenrobot.eventbus.EventBus;

public class SingletenEventBus {
   public static EventBus bus;
   public static EventBus getInstance()
   {
       if(bus==null)
       {
           bus=EventBus.getDefault();
       }
       return bus;
   }

}
