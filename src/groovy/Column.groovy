enum Columns {
    B(0, 5), I(1, 5), N(2, 4), G(3, 5), O(4, 5)

    Columns(int order, int spaceCount) {
        this.order = order
        this.spaceCount = spaceCount
    }

    int numbersPerColumn = 15
    int order
    int spaceCount

    int getMin() {
        order * numbersPerColumn + 1
    }

    int getMax() {
        (order + 1) * numbersPerColumn
    }

    boolean isValid(int number) {
        (number >= min) && (number <= max)
    }
}
