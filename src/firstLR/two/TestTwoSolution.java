package firstLR.two;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTwoSolution {
    private Two two;

    @Test
    public void firstHandTest(){
        int test11 = Two.countSameElements(new int[]{1,1,2,2,3}, new int[]{0,1,3,3,4});
        int test12 = Two.countSameElements(new int[]{1,2,3,4}, new int[]{0,1,2,3,3});
        Assert.assertEquals(2, test11);
        Assert.assertEquals(3,test12);
    }

    @Test
    public void edgeCaseTest(){
        int test2 = Two.countSameElements(new int[]{1,1,1,1,1,2}, new int[]{1,1,1,1,1,3});
        int test22 = Two.countSameElements(new int[]{0,1,1,1,1,1}, new int[]{2,3,3,3,3,3});
        Assert.assertEquals(5,test2);
        Assert.assertEquals(0, test22);
    }

    @Test
    public void nullTest(){
        int test31 = Two.countSameElements(new int[]{}, new int[]{1,1,1,1,1,3});
        int test32 = Two.countSameElements(new int[]{1,1,1,1,1,3}, new int[]{});
        Assert.assertEquals(0, test31);
        Assert.assertEquals(0, test32);
    }
}
