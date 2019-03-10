package org.home.greed.l435;


import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1.end != o2.end)
                return o1.end - o2.end;
            return o1.start - o2.start;
        });
        int size = 1;
        int pre = 0;
        for (int i = 1; i <intervals.length ; i++) {
            if (intervals[i].start >= intervals[pre].end){
                size++;
                pre = i;
            }
        }
        return intervals.length - size;
    }
}


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}