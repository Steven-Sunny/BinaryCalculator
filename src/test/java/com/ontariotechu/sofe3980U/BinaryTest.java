package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
        Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
        Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
        Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
        Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
        Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
        Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
        Binary binary1=new Binary("1000");
        Binary binary2=new Binary("1111");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
    /**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
        Binary binary1=new Binary("1010");
        Binary binary2=new Binary("11");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
    /**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
        Binary binary1=new Binary("11");
        Binary binary2=new Binary("1010");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
    /**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4()
    {
        Binary binary1=new Binary("0");
        Binary binary2=new Binary("1010");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
    /**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
        Binary binary1=new Binary("0");
        Binary binary2=new Binary("0");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }

     /**
     * Test The OR functions with two binary values
     */
    @Test
    public void or1() {
        // 1010 | 1100 = 1110
        Binary b1 = new Binary("1010");
        Binary b2 = new Binary("1100");
        Binary result = Binary.or(b1, b2);
        assertTrue(result.getValue().equals("1110"));
    }

    /**
     * Test The OR functions with two binary values, the first one is shorter than the second
     */
    @Test
    public void or2() {
        // 1 | 1010 = 1011
        Binary b1 = new Binary("1");
        Binary b2 = new Binary("1010");
        Binary result = Binary.or(b1, b2);
        assertTrue(result.getValue().equals("1011"));
    }

    /**
     * Test The OR functions with two 0 binary values of different lengths
     */
    @Test
    public void or3() {
        // 000 | 0 = 0
        Binary b1 = new Binary("000");
        Binary b2 = new Binary("0");
        Binary result = Binary.or(b1, b2);
        assertTrue(result.getValue().equals("0"));
    }

    /**
     * Test The AND functions with two binary values
     */
    @Test
    public void and1() {
        // 1011 & 1101 = 1001
        Binary b1 = new Binary("1011");
        Binary b2 = new Binary("1101");
        Binary result = Binary.and(b1, b2);

        assertTrue(result.getValue().equals("1001"));
    }

    /**
     * Test The AND functions with two binary values, the first one is longer than the second
     */
    @Test
    public void and2() {
        // 111 & 1 = 1
        Binary b1 = new Binary("111");
        Binary b2 = new Binary("1");
        Binary result = Binary.and(b1, b2);

        assertTrue(result.getValue().equals("1"));
    }

    /**
     * Test The AND functions with two binary bitwise inverted values, should be 0
     */
    @Test
    public void and3() {
        // 1010 & 0101 = 0
        Binary b1 = new Binary("1010");
        Binary b2 = new Binary("0101");
        Binary result = Binary.and(b1, b2);

        assertTrue(result.getValue().equals("0"));
    }

    /**
     * Test The multiply functions by multiplying a binary value by 0
     */
    @Test
    public void multiply1() {
        // 1011 (11) * 0 (0) = 0
        Binary b1 = new Binary("1011");
        Binary b2 = new Binary("0");
        Binary result = Binary.multiply(b1, b2);

        assertTrue(result.getValue().equals("0"));
    }

    /**
     * Test The multiply functions by multiplying a binary value by 1
     */
    @Test
    public void multiply2() {
        // 1101 (13) * 1 (1) = 1101 (13)
        Binary b1 = new Binary("1101");
        Binary b2 = new Binary("1");
        Binary result = Binary.multiply(b1, b2);

        assertTrue(result.getValue().equals("1101"));
    }

    /**
     * Test The multiply functions by multiplying two binary values
     */
    @Test
    public void multiply3() {
        // 11 (3) * 10 (2) = 110 (6)
        Binary b1 = new Binary("11");
        Binary b2 = new Binary("10");
        Binary result = Binary.multiply(b1, b2);

        assertTrue(result.getValue().equals("110"));
    }
}
