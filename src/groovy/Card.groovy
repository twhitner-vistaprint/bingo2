
class Card {
    private columnCount = Columns.values().count { true }
    private rows = 5
    private spaceArray = new Space[rows][columnCount]
    private HashMap<Integer, NumberSpace> spaceMap = new HashMap<Integer, NumberSpace>();
    Card(int[][] numbers)
    {
        if (numbers.length != columnCount) {
            String errorMessage = sprintf("Incorrect number of columns. " +
                    "%d provided, %d required", numbers.length, columnCount)
            throw new IllegalArgumentException(errorMessage)
        }

        Columns.values().each { column ->
            if (numbers[column.order].length != column.spaceCount) {
                String errorMessage = sprintf("Incorrect number of spaces in column %s. " +
                        "%d provided, %d required", column, numbers[column.order].length, column.spaceCount)
                throw new IllegalArgumentException(errorMessage)
            }
            for (int row = 0; row < rows; row++) {

                Space newSpace

                if (isFreeSpace(column.order, row)) {
                    newSpace = new FreeSpace()
                } else {
                    int freeSpaceAdjustedRow = row
                    if (isAfterFreeSpace(column.order, row)) {
                        freeSpaceAdjustedRow--
                    }
                    int number = numbers[column.order][freeSpaceAdjustedRow]

                    if (!column.isValid(number)) {
                        String errorMessage = sprintf("Number is not in correct range for column %s. " +
                                "%d provided, between %d and %d inclusive required", column,
                                number, column.min, column.max)
                        throw new IllegalArgumentException(errorMessage)
                    }

                    newSpace = new NumberSpace(column: column.order,
                            row: row, number: number)
                    spaceMap.put(number, newSpace)
                }
                spaceArray[column.order][row] = newSpace
            }
        }
    }

    private boolean isFreeSpace(int column, int row)
    {
        (column == Columns.N.order) && (row == 2)
    }
    private boolean isAfterFreeSpace(int column, int row)
    {
        (column == Columns.N.order) && (row > 2)
    }

    String toString() {
        String card = " B  I  N  G  O" + System.lineSeparator()
        for (int r = 0; r<5; r++) {
            for (int c = 0; c<5; c++) {
                card = card + spaceArray[c][r].toString() + " "
            }
            card = card + System.lineSeparator()
        }
        card = card + System.lineSeparator()
        card
    }
}