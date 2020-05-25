package com.kampaeny.euler.utils;

public class TimeTaken {
    /**
     * Return total time taken in milliseconds
     *
     * @param start time
     * @param end   time
     * @return duration
     */
    public static long timeTaken(long start, long end) {
        return end - start;
    }
}
