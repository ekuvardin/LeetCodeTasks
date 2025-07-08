package solutions;

import org.json.simple.parser.ParseException;
import rewritesolution.LongestRepeatingCharacterReplacement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException, ParseException {
        BasicCalculator2 l = new BasicCalculator2();
       // l.calculate(new String("1*2-3/4-26"));
       l.calculate(new String("1*2+3*4-5*6+7*8-9*10"));
    }

}
