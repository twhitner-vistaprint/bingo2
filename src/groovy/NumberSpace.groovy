/**
 * Created by Tom on 1/22/2017.
 */
class NumberSpace implements Space {
    int row
    int column
    int number
    boolean covered
    String toString() {
        if (covered) {
            "XX"
        } else {
            number.toString().padLeft(2)
        }
    }}
