package _3LR._12;

import org.junit.Assert;
import org.junit.Test;

public class TestTheTask {
    @Test
    public void testing() {
        Tree tree = new Tree(5);
        tree.addEdge(1,3);
        tree.addEdge(1,2);
        tree.addEdge(2,4);
        tree.addEdge(2,5);
        int actualResult = tree.findNode(2,2);
        int expectedResult = 3;
        Assert.assertEquals(expectedResult, actualResult);
    }
}
