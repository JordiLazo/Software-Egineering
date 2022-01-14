package Question_4_State_Pattern_and_Junit.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    @Test
    public void testFindMax(){
        assertEquals(4,Calculation.findMax(new int[]{1,3,4,2}));
    }

    @Test
    public void testCube(){
        assertEquals(27,Calculation.cube(3));
    }

    @Test
    public void testReverseWord(){
        assertEquals("nahk si eman ym",Calculation.reverseWord("my name is khan"));
        assertEquals("ozal idroj",Calculation.reverseWord("jordi lazo"));
    }

    @Test
    public void testSecsToMins() {
        int seconds = 0;
        assertThrows(IllegalArgumentException.class, () -> Calculation.secsToMins(seconds));
    }

    @Test
    public void testReturnABoolean() {
        boolean shouldReturnTrue = Calculation.returnABoolean("Save");
        assertTrue(shouldReturnTrue);
    }

    @Test
    public void testSubstract(){
        int a = 200;
        int b = 100;
        int actual = Calculation.subtract(a, b);
        int expected = 100;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class,()-> Calculation.subtract(-10,20));
    }

}