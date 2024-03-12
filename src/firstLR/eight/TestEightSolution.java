package firstLR.eight;

import org.junit.Assert;
import org.junit.Test;

public class TestEightSolution {
    Eight eight;
    @Test
    public void firstHandTest(){
        int n = 5;
        int m = 3;
        Assert.assertEquals(4, Eight.placeTrees(n, m));
    }
    @Test
    public void nullTest(){ // нуль деревьев это как максимум одна расстановка нуля деревьев
        int n = 30;
        int m = 0;
        Assert.assertEquals(1, Eight.placeTrees(n, m));
    }

    @Test
    public void oneMTest(){// если у нас одно дерево то мы можем его расставить n - способами на каждую позицию
        int n = 30;
        int m = 1;
        Assert.assertEquals(30, Eight.placeTrees(n, m));
    }

    @Test
    public void moreMTest(){// если нам изначально нужно расставить деревьев больше чем грядка то 0
        int n = 30;
        int m = 31;
        Assert.assertEquals(0, Eight.placeTrees(n, m));
    }

    @Test
    public void edgeTest(){
        int n = 30;
        int m = 29;
        Assert.assertEquals(2,Eight.placeTrees(n, m));
    }
}
