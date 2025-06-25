package solutions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class yandex349 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        JSONObject jsonObject = new JSONObject();
        JSONArray offers = new JSONArray();
        jsonObject.put("offers", offers);

        JSONParser jsonParser = new JSONParser();
        for (int i = 0; i < n && m > 0; i++) {
            JSONObject object = (JSONObject) jsonParser.parse(reader.readLine());
            JSONArray array = (JSONArray) object.get("offers");
            for (int j = 0; j < array.size() && m > 0; j++) {
                offers.add(array.get(j));
                m--;
            }
        }

        writer.write(String.valueOf(jsonObject));

        reader.close();
        writer.close();
    }

}
