package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class RandomUtil {
    public static int getRandomIntInRange(int min, int max) {
        return new Random().nextInt(Math.abs(max - min)) + min;
    }

    public static int[] getRandomIntRangeList(int min, int max, int length) {
        return new Random().ints(min, max).distinct().limit(length).toArray();
    }

    public static String getRandomString(int length) {
        String digits = "0123456789";
        String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + digits;
        Random rnd = new Random();
        List<String> result = new ArrayList<>();
        Consumer<String> appendChar = s ->
                result.add("" + s.charAt(rnd.nextInt(s.length())));
        appendChar.accept(digits);
        while (result.size() < length)
            appendChar.accept(all);
        Collections.shuffle(result, rnd);
        return String.join("", result);
    }
}
