
class ColumnsTest extends GroovyTestCase {

    void testOrder() {
        assertEquals(0, Columns.B.order)
        assertEquals(1, Columns.I.order)
        assertEquals(2, Columns.N.order)
        assertEquals(3, Columns.G.order)
        assertEquals(4, Columns.O.order)
    }

    void testMin() {
        assertEquals(1, Columns.B.min)
        assertEquals(16, Columns.I.min)
        assertEquals(31, Columns.N.min)
        assertEquals(46, Columns.G.min)
        assertEquals(61, Columns.O.min)
    }

    void testMax() {
        assertEquals(15, Columns.B.max)
        assertEquals(30, Columns.I.max)
        assertEquals(45, Columns.N.max)
        assertEquals(60, Columns.G.max)
        assertEquals(75, Columns.O.max)
    }

    void testSpaceCount() {
        assertEquals(5, Columns.B.spaceCount)
        assertEquals(5, Columns.I.spaceCount)
        assertEquals(4, Columns.N.spaceCount)
        assertEquals(5, Columns.G.spaceCount)
        assertEquals(5, Columns.O.spaceCount)
    }
}