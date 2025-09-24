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
        DesignSpreadsheet3484 lr = new DesignSpreadsheet3484(2);
        lr.setCell("A1", -5);
        lr.getValue("=A1+2");
    }
}
