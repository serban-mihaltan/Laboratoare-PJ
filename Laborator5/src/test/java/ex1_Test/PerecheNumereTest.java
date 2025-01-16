package ex1_Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import ex1.PerecheNumere;
/**
 * Unit test class for the PerecheNumere class.
 * Tests various methods provided by the PerecheNumere class to validate their correctness.
 */
public class PerecheNumereTest {
    @Test
    void test1_fibonacii(){
        PerecheNumere p = new PerecheNumere(1,1);
        assertEquals(true,p.fibonaci());
    }
    @Test
    void test2_fibonacii(){
        PerecheNumere p = new PerecheNumere(5,8);
        assertEquals(true,p.fibonaci());
    }
    @Test
    void test3_fibonacii(){
        PerecheNumere p = new PerecheNumere(8,7);
        assertEquals(false,p.fibonaci());
    }
    @Test
    void test1_cmmc()
    {
        PerecheNumere p = new PerecheNumere(10,5);
        assertEquals(10,p.cmmmc());
    }
    @Test
    void test2_cmmc()
    {
        PerecheNumere p = new PerecheNumere(9,8);
        assertEquals(72,p.cmmmc());
    }

    @Test
    void test3_cmmc()
    {
        PerecheNumere p = new PerecheNumere(12,8);
        assertEquals(24,p.cmmmc());
    }
    @Test
    void test1_sum_cif()
    {
        PerecheNumere p = new PerecheNumere(13,22);
        assertEquals(true,p.sum_cif());
    }
    @Test
    void test2_sum_cif()
    {
        PerecheNumere p = new PerecheNumere(101,11);
        assertEquals(true,p.sum_cif());
    }
    @Test
    void test3_sum_cif()
    {
        PerecheNumere p = new PerecheNumere(11,111);
        assertEquals(false,p.sum_cif());
    }
    @Test
    void test1_num_cif()
    {
        PerecheNumere p = new PerecheNumere(13,22);
        assertEquals(false,p.nr_cif());
    }
    @Test
    void test2_num_cif()
    {
        PerecheNumere p = new PerecheNumere(465,22);
        assertEquals(true,p.nr_cif());
    }
    @Test
    void test3_num_cif()
    {
        PerecheNumere p = new PerecheNumere(1789,4);
        assertEquals(true,p.nr_cif());
    }

}