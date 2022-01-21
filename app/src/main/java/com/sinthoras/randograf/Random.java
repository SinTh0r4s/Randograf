package com.sinthoras.randograf;

import java.util.Collection;

public class Random {
    private static java.util.Random random = new java.util.Random();

    public static int getRandomFromTo(int from, int to) {
        return from + random.nextInt(to - from + 1);
    }

    public static <T> T drawRandomFromCollection(Collection<T> collection) {
        return collection.stream().skip(random.nextInt(collection.size())).findFirst().orElse(null);
    }

    public static int getRandom(int limit) {
        return random.nextInt(limit);
    }

}
