/**
 * Created by Tom on 1/22/2017.
 */
class ColumnGeneratorTest extends GroovyTestCase {
    void testColumnGenerationRanges() {
        Columns.values().each { column ->
            ColumnGenerator generator = new ColumnGenerator()
            int[] numbers = generator.getNumbers(column.spaceCount, column.min, column.max)

            assertEquals(column.spaceCount, numbers.length)
            numbers.each { number ->
                assertTrue(number.intValue() >= column.min)
                assertTrue(number.intValue() <= column.max)
            }
        }
    }
}
