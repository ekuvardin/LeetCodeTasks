package solutions;

import org.json.simple.parser.ParseException;
import rewritesolution.LongestRepeatingCharacterReplacement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) throws IOException, ParseException {
    //    productQueries(806335498, new int[][]{{1,8}});
      //  productQueries(1, new int[][]{{0,0}});
        LRUCache1 lr = new LRUCache1(2);
        lr.put("1");
        lr.put("2");
        lr.put("1");
        lr.put("3");
        lr.get("2");

    }
}
