package solutions;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException, ParseException {
        List<FlattenNestedListIterator341.NestedInteger> w = new ArrayList<>();

        //[[1,1],2,[1,1]]
        List<FlattenNestedListIterator341.NestedInteger> v1 = new ArrayList<>(2);
        v1.add(new FlattenNestedListIterator341.IntegerNested(1));
        v1.add(new FlattenNestedListIterator341.IntegerNested(2));

        w.add(new FlattenNestedListIterator341.NestedArray(v1));
        w.add(new FlattenNestedListIterator341.IntegerNested(3));

        List<FlattenNestedListIterator341.NestedInteger> v2 = new ArrayList<>(2);
        v2.add(new FlattenNestedListIterator341.IntegerNested(4));
        v2.add(new FlattenNestedListIterator341.IntegerNested(5));
        w.add(new FlattenNestedListIterator341.NestedArray(v2));

        FlattenNestedListIterator341 l1 = new FlattenNestedListIterator341(w);
        while (l1.hasNext()) {
            l1.next();
        }

        List<FlattenNestedListIterator341.NestedInteger> v11 = new ArrayList<>(2);
        v11.add(new FlattenNestedListIterator341.NestedArray(List.of()));


        FlattenNestedListIterator341 l = new FlattenNestedListIterator341(v11);
        while (l.hasNext()) {
            l.next();
        }
    }

}
