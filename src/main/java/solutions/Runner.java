package solutions;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException, ParseException {
        MaximalRectangle85 n = new MaximalRectangle85();
        n.maximalRectangle( new char[][] { {'1'}});
        n.maximalRectangle( new char[][] { {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});

    }

}
