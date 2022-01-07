package com.sinthoras.randograf;

import java.util.List;

public class Random {
    private static java.util.Random random = new java.util.Random();

    public static int getRandomFromTo(int from, int to) {
        return from + random.nextInt() % (to - from + 1);
    }

    public static <T> T drawRandomFromList(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }
}
