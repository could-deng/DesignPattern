package com.sdk.dyq.designpattern.common;

/**
 * 迭代器模式
 * 迭代器模式就是顺序的访问聚集中的对象
 * 运用：集合类
 */

public class PatternIterator {
    interface Iterator{
        String previous();
        String next();
        boolean hasNext();
        String first();
    }
    interface Collection{
        Iterator iterator();
        String get(int pos);
        int size();
    }
    class MyIterator implements Iterator{
        Collection collection;
        int pos;
        @Override
        public String previous() {
            return collection.get(pos-1);
        }

        @Override
        public String next() {

            return collection.get(pos+1);
        }

        @Override
        public boolean hasNext() {
            if(pos<collection.size()-1){
                return true;
            }
            return false;
        }

        @Override
        public String first() {
            return collection.get(0);
        }
    }
    class MyCollecotion implements Collection{
        String arrays[] = new String[]{"1","2","3","4","5"};
        @Override
        public Iterator iterator() {
            return new MyIterator();
        }

        @Override
        public String get(int pos) {
            return arrays[pos];
        }

        @Override
        public int size() {
            return arrays.length;
        }
    }

    void test(){
        Collection col = new MyCollecotion();
        Iterator it= col.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }

}
