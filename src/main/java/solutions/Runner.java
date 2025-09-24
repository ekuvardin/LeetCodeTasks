package solutions;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException, ParseException {
        DesignSpreadsheet3484 lr = new DesignSpreadsheet3484(2);
        lr.setCell("A1", -5);
        lr.getValue("=A1+2");
    }
}
