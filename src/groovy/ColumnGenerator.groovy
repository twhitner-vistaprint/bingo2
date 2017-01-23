import java.util.concurrent.ThreadLocalRandom

class ColumnGenerator {

    int[] getNumbers(int count, int min, int max) {
        int range = max - min + 1
        if (range < count) {
            throw new IllegalArgumentException("Range is too small for count.")
        }
        int[] numbers = new int[count]
        for (int i = 0; i < count; i++) {
            int randomNumber = getRandomInt(min, max)
            while (numbers.contains(randomNumber)) {
                randomNumber = getRandomInt(min, max)
            }
            numbers[i] = randomNumber
        }
        return numbers
    }

    private getRandomInt(int min, int max) {
        ThreadLocalRandom.current().nextInt(min, max + 1)
    }

}
