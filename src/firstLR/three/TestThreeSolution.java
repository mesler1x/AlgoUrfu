package firstLR.three;

import org.junit.Assert;
import org.junit.Test;

public class TestThreeSolution {
    private Three three;
    @Test
    public void firstHandTest(){
        String test11 = Three.permutationNumbers("232","-100", "+");
        String test12 = Three.permutationNumbers("-100","199","-");
        Assert.assertEquals("132",test11);
        Assert.assertEquals("-299",test12);
    }

    @Test
    public void edgeCaseTest(){
        String test21 = Three.permutationNumbers("37995", "35466", "+");
        String test22 = Three.permutationNumbers("73461", "37995","-");
        Assert.assertEquals("73461",test21);
        Assert.assertEquals("35466",test22);
    }
}
