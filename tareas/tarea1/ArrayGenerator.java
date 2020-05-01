import.java.utils.Random;

public class ArrayGenerator() {
    Random random = new Random();
    int[] array = random.ints(100000, 10,100000).toArray();
}