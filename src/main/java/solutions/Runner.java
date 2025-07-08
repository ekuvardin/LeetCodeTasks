package solutions;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException, ParseException {
        BasicCalculator2 l = new BasicCalculator2();
       // l.calculate(new String("1*2-3/4-26"));
       l.calculate1(new String("282-1*2*13-30"));
    }

}
