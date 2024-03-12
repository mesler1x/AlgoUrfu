package firstLR.four;

import org.junit.Assert;
import org.junit.Test;

public class TestFourSolution {
    private Four four;

    @Test
    public void firstHandTest() {
        int polinomPower = 2;
        int[] arguments = new int[]{0, 1, 2, 3, 4};
        int mod = 10;
        int[] coefficients = new int[]{1, 5, 4};// polinom power + 1
        String res = Four.resultOfPolinomWithArgs(coefficients, arguments, mod, polinomPower);
        Assert.assertEquals("4 0 8 8 0", res);
    }

    @Test
    public void secondHandTest() {
        int polinomPower = 5;
        int[] arguments = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int mod = 10;
        int[] coefficients = new int[]{1, 0, 0, 0, 0, 0};
        String res = Four.resultOfPolinomWithArgs(coefficients, arguments, mod, polinomPower);
        Assert.assertEquals("1 2 3 4 5 6 7 8 9", res);
    }
    @Test
    public void edgeTest() { // для одного аргумента - одно значение
        int polinomPower = 2;
        int[] arguments = new int[]{1};
        int mod = 10;
        int[] coefficients = new int[]{1, 0, 0};
        String res = Four.resultOfPolinomWithArgs(coefficients, arguments, mod, polinomPower);
        Assert.assertEquals("1", res);
    }

    @Test
    public void edgeTest2() { // если каждое число умножится на 1 (потому что степень x - 0) будет 0 из-за коэффициента
        int polinomPower = 0;
        int[] arguments = new int[]{1, 2, 3, 4, 5, 6};
        int mod = 10;
        int[] coefficients = new int[]{0};
        String res = Four.resultOfPolinomWithArgs(coefficients, arguments, mod, polinomPower);
        Assert.assertEquals("0 0 0 0 0 0", res);
    }

    @Test
    public void edgeTest3() { // если степень 0 аргументы не изменятся и если коэф - 1
        int polinomPower = 1;
        int[] arguments = new int[]{1, 2, 3, 4, 5, 6};
        int mod = 10;
        int[] coefficients = new int[]{1};
        String res = Four.resultOfPolinomWithArgs(coefficients, arguments, mod, polinomPower);
        Assert.assertEquals("1 2 3 4 5 6", res);
    }
}
