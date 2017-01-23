class CardTest extends GroovyTestCase {

    private correctColumnCount = Columns.values().count { true }
    void testLowSpaceCount() {
        boolean thrown = false

        int[][] x = new int[correctColumnCount - 1][5]

        try {
            new Card(x)
        } catch (IllegalArgumentException ex) {
            println ex.message
            thrown = true
        }
        assertTrue("Expected IllegalArgumentException was not thrown.", thrown)
    }

    void testHighSpaceCount() {
        boolean thrown = false

        int[][] x = new int[correctColumnCount + 1][5]

        try {
            new Card(x)
        } catch (IllegalArgumentException ex) {
            println ex.message
            thrown = true
        }

        assertTrue("Expected IllegalArgumentException was not thrown.", thrown)
    }

    void testSpaceCount() {
        boolean thrown = false

        int[][] x = [[1,2,3,4,5],
                [1,2,3,4,5],
                [1,2,3,4,5],  // too many spaces for column N
                [1,2,3,4,5],
                [1,2,3,4,5]]

        try {
            new Card(x)
        } catch (IllegalArgumentException ex) {
            println ex.message
            thrown = true
        }

        assertTrue("Expected IllegalArgumentException was not thrown.", thrown)
    }

    void testInvalidNumber() {

        Columns.values().each { column ->

            int[][] x = [[1, 2, 3, 4, 5],
                         [30, 16, 17, 18, 19],
                         [31, 32, 33, 34],
                         [51, 52, 53, 54, 55],
                         [71, 72, 73, 74, 75]]

            boolean thrown = false

            try {
                x[column.order][column.order] = column.max + 1
                new Card(x)
            } catch (IllegalArgumentException ex) {
                println ex.message
                thrown = true
            }

            assertTrue("Expected IllegalArgumentException was not thrown.", thrown)
        }
    }

    void testValid() {
        int[][] x = [[1, 2, 3, 4, 5],
                     [30, 16, 17, 18, 19],
                     [31, 32, 33, 34],
                     [51, 52, 53, 54, 55],
                     [71, 72, 73, 74, 75]]
        Card card = new Card(x)
        println card
        assertNotNull(card)
    }
}
