package solutions;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/*
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:

    NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
    int next() Returns the next integer in the nested list.
    boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.

Your code will be tested with the following pseudocode:

initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res

If res matches the expected flattened list, then your code will be judged as correct.



Example 1:

Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:

Input: nestedList = [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].



Constraints:

    1 <= nestedList.length <= 500
    The values of the integers in the nested list is in the range [-106, 106].

yandex

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
 */
public class FlattenNestedListIterator341 implements Iterator<Integer> {

    private final Stack<ListIterator<NestedInteger>> lists;
    private NestedInteger value;

    public FlattenNestedListIterator341(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        if (value != null) {
            NestedInteger val = value;
            value = null;
            return val.getInteger();
        }

        while (!lists.empty()) {
            ListIterator<NestedInteger> iterator = lists.peek();
            if (iterator.hasNext()) {
                NestedInteger integer = iterator.next();
                if (integer.isInteger()) {
                    return integer.getInteger();
                } else {
                    lists.push(integer.getList().listIterator());
                }
            }
        }

        return null;
    }

    @Override
    public boolean hasNext() {
        while (!lists.empty()) {
            ListIterator<NestedInteger> iterator = lists.peek();
            if (iterator.hasNext()) {
                NestedInteger integer = iterator.next();
                if (integer.isInteger()) {
                    value = integer;
                    return true;
                } else {
                    lists.add(integer.getList().listIterator());
                }
            } else {
                lists.pop();
            }
        }

        return false;
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public static class IntegerNested implements NestedInteger {

        Integer val;

        public IntegerNested(Integer val) {
            this.val = val;
        }

        @Override
        public boolean isInteger() {
            return true;
        }

        @Override
        public Integer getInteger() {
            return val;
        }

        @Override
        public List<NestedInteger> getList() {
            return List.of();
        }
    }

    public static class NestedArray implements NestedInteger {

        private List<NestedInteger> value;

        public NestedArray(List<NestedInteger> value) {
            this.value = value;
        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<NestedInteger> getList() {
            return value;
        }
    }
}

