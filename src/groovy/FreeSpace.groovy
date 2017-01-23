/**
 * Created by Tom on 1/22/2017.
 */
class FreeSpace implements Space {
    int getRow() {
        2
    }
    int getColumn() {
        Columns.N.order
    }
    int getNumber() {
        0
    }
    boolean isCovered() {
        true
    }
    String toString() {
        "FS"
    }
}
