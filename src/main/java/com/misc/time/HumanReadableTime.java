package com.misc.time;

public class HumanReadableTime {

    public static String makeReadable(final int seconds) {

        int s = 0;
        int m = 0;
        int h = 0;

        for (int i = 0; i < seconds; ++i) {
            ++s;
            if (s == 60) {
                s = 0;
                ++m;
                if (m == 60) {
                    m = 0;
                    ++h;
                }
            }
        }

        String ss = String.valueOf(s);
        if (ss.length() == 1) {
            ss = "0" + ss;
        }

        String mm = String.valueOf(m);
        if (mm.length() == 1) {
            mm = "0" + mm;
        }

        String hh = String.valueOf(h);
        if (hh.length() == 1) {
            hh = "0" + hh;
        }

        return hh + ":" + mm + ":" + ss;
    }
}