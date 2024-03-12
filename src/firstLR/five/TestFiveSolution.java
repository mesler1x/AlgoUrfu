package firstLR.five;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestFiveSolution {
    Five five;
    @Test
    public void firstHandTest(){
        List<String> lines = new ArrayList<>();
        lines.add("program test;");
        lines.add("(*just for testing *)");
        lines.add("var");
        lines.add("(* variables");
        lines.add("note that");
        lines.add("// here is not comment");
        lines.add("and (* here is");
        lines.add("not a begin of");
        lines.add("another comment");
        lines.add("*)");
        lines.add("x: integer; (* *)");
        lines.add("begin");
        lines.add("write(‘(*is not comment//‘);");
        lines.add("write(‘ and (*here*) ‘");
        lines.add(",x // y);");
        lines.add("End. // It is comment");
    }
}
