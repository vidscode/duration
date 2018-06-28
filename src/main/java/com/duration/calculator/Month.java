package com.duration.calculator;

import java.util.HashMap;
import java.util.Map;

public enum Month {
    January(31,1),
    February(28,2),
   // February_Leap(29,3),
    March(30,3),
    April(31,4),
    May(30,5),
    June(31,6),
    July(30,7),
    August(31,8),
    September(30,9),
    October(31,10),
    November(30,11),
    December(31,12);

    private final int value;
    private final int index;

    private static Map map = new HashMap<>();

    private Month(int value,int index){
        this.value = value;
        this.index = index;
    }

    static {
        for (Month month : Month.values()) {
            map.put(month.index, month);
        }
    }

    public int getValue() {
        return value;
    }

    public int getIndex(){
        return index;
    }

    public static Month valueOf(int month) {
        return (Month) map.get(month);
    }
}
