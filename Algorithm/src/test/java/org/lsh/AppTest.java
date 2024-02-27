package org.lsh;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.remove(list.size() - 1);
        System.out.println(list);
        System.out.println(list.get(list.size() - 1));
    }
}
