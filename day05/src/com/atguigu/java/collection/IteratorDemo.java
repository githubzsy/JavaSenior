package com.atguigu.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add(2);
        coll.add(3);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj=iterator.next();
            System.out.println(obj);
            if(obj.equals(2)){
                /**
                 * 删除当前元素
                 */
                iterator.remove();
            }
        }

        System.out.println(coll);
    }
}
