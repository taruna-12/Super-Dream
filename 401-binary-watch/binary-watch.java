
import java.util.*;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                if (Integer.bitCount(hour) +
                    Integer.bitCount(minute) == turnedOn) {

                    String time = hour + ":";

                    if (minute < 10) {
                        time += "0";
                    }

                    time += minute;
                    result.add(time);
                }
            }
        }

        return result;
    }
}
