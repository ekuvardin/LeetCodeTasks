package solutions;

import java.util.ArrayList;
import java.util.List;

/*
yandex

 List<List<Integer>> v = new ArrayList<>();
        v.add(List.of(1,4,7));
        v.add(List.of(2,5));
        v.add(List.of(3,6,8,9));
        ZigzagIterator zigzagIterator = new ZigzagIterator(v);
        while(zigzagIterator.hasNext()) {
            System.out.println(zigzagIterator.next());
        }

 */
public class ZigzagIterator {

    int pointer = 0;
    List<List<Integer>> vectors;
    private List<Integer> indices = new ArrayList<>();

    public ZigzagIterator(List<List<Integer>> v) {
        this.vectors = v;
        for (int i = 0; i < v.size(); i++) {
            indices.add(0);
        }
    }

    public int next() {
        List<Integer> vector = vectors.get(pointer);
        int vectorPosition = indices.get(pointer);
        int res = vector.get(vectorPosition);
        indices.set(pointer, vectorPosition + 1);
        pointer = (pointer + 1) % indices.size();
        return res;
    }

    public boolean hasNext() {
        int start = pointer;
        while (vectors.get(pointer).size() == indices.get(pointer)) {
            pointer = (pointer + 1) % indices.size();

            if (start == pointer) {
                return false;
            }
        }

        return true;

    }
}
