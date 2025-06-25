package solutions;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException, ParseException {
        List<List<Integer>> v = new ArrayList<>();
        v.add(List.of(1,4,7));
        v.add(List.of(2,5));
        v.add(List.of(3,6,8,9));
        ZigzagIterator zigzagIterator = new ZigzagIterator(v);
        while(zigzagIterator.hasNext()) {
            System.out.println(zigzagIterator.next());
        }
    }

}
