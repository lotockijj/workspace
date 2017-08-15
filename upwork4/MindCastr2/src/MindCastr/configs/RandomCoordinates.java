package MindCastr.configs;

import java.util.Random;

public class RandomCoordinates {

    public static int genNumWidth(int Width) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(Width);
        return randomInt;
    }
    
    public static int genNumHeight(int Height) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(Height);
        return randomInt;
    }
}
