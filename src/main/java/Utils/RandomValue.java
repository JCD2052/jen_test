package Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomValue {

    public static int getRandomIntInRange(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    public static String getRandomPassword(int length){
        char[] possibleCharacters = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789").toCharArray();
        return RandomStringUtils.random(
                length, 1, possibleCharacters.length-1,
                false, false, possibleCharacters, new SecureRandom() );
    }
}
