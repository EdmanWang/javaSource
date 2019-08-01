package javaSource.collection.map;

import javaSource.collection.util.Person;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;

// TreeMap 测试 demo
public class TreeMapDemo {

    @Test
    public void test() {
        TreeMap treeMap = new TreeMap(new Comparator<Person>() {
            @Override
            public int compare(Person personOne, Person personTwo) {
                return 0;
            }
        });

        /**
         * TreeMap X需要自定义一个比较器，方法和abstractMap 一样
         */
    }
}
