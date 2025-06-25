package solutions;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/*
yandex
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

