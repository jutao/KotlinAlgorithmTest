package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/28
 * description：341. 扁平化嵌套列表迭代器
 * 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的项或者为一个整数，或者是另一个列表。
 * ****************************************
 */
public class NestedIterator implements Iterator<Integer>{
    public static void main(String[] args) {
        List<NestedInteger> nestedList =new ArrayList<>();
        List<NestedInteger> nestedList1 =new ArrayList<>();
        nestedList1.add(new NestedIntegerImpl(1));
        nestedList1.add(new NestedIntegerImpl(1));
        NestedIntegerImpl n1=new NestedIntegerImpl(nestedList1);
        nestedList.add(n1);
        nestedList.add(new NestedIntegerImpl(2));
        List<NestedInteger> nestedList2 =new ArrayList<>();
        nestedList2.add(new NestedIntegerImpl(1));
        nestedList2.add(new NestedIntegerImpl(3));
        NestedIntegerImpl n2=new NestedIntegerImpl(nestedList2);
        nestedList.add(n2);
        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }

    List<Integer> list;
    Iterator<Integer> iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        list=new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            unfold(nestedInteger);
        }
        iterator=list.iterator();
    }

    private void unfold(NestedInteger nested){
        if(nested.isInteger()){
            list.add(nested.getInteger());
        }else {
            for (NestedInteger nestedInteger : nested.getList()) {
                unfold(nestedInteger);
            }
        }
    }
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    static class NestedIntegerImpl implements NestedInteger{
        Integer value;
        List<NestedInteger> list;

        public NestedIntegerImpl(Integer value) {
            this.value = value;
        }

        public NestedIntegerImpl(List<NestedInteger> list) {
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return value!=null;
        }

        @Override
        public Integer getInteger() {
            if(isInteger()){
                return value;
            }
            return null;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }

    public interface NestedInteger {

        /**
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        boolean isInteger();

        /**
         *@return the single integer that this NestedInteger holds, if it holds a single integer
         *Return null if this NestedInteger holds a nested list
         */
        Integer getInteger();

        /**
         * @return the nested list that this NestedInteger holds, if it holds a nested list
         * Return null if this NestedInteger holds a single integer
         */
        List<NestedInteger> getList();
}

}
