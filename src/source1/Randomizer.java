package source1;

import java.util.Random;

public class Randomizer {
        public int intBetween(int start, int end) {
                Random rand = new Random();
                return rand.nextInt((end - start) + 1) + start;
        }
}
