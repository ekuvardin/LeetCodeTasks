package solutions;

import org.json.simple.parser.ParseException;
import rewritesolution.LongestRepeatingCharacterReplacement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException, ParseException {
        SubarraySumsDivisiblebyK974 l = new SubarraySumsDivisiblebyK974();
        l.subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5);
    }

}
