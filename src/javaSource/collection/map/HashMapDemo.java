package javaSource.collection.map;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

// HashMap 测试 demo

/**
 * map：初始化最小的容量是16【1 << 4】，最大是1073741824【1 << 30】
 * map: 初始化的加载因子 默认是0.75
 * map：底层是一个数组，只不过数组中放的是 这个 Node<K,V> 类型
 */

/**
 * Node类型 中 存有
 * final int hash; hash 是通过key的hashCode 方法 和 哈希值的异或运算符
 * final K key;
 * V value;
 * Node<K,V> next;
 * 以上几个属性
 */
public class HashMapDemo {

    @Test
    public void testPut() {
        /**
         *  put 操作是向一个数组中放入数据
         *  1：当放入的key不重复的时候，不会有数据返回
         *  2：当放入的key重复的时候，会有数据返回,返回的数据是老的数据
         */
        Map<String, String> hashMap = new HashMap();
        hashMap.put("wgx", "001");
        hashMap.put("wgx01", "002");
        hashMap.put("wgx02", "003");
    }

    @Test
    public void testKeySet() {
        /**
         * 1:调用keySet 函数的时候，会返回一个set的引用，即使没有向map中放入数据，还是会有一个set的引用返回，表示，map会自己维护一个ketSet
         * 2:在使用 strings.iterator() 会调用底层自己实现的迭代器函数。
         * 3:在调用hashMap.keySet() 为什么会显示元素个数，因为会调用toString函数
         */
        Map<String, String> hashMap = new HashMap();
        Set<String> strings = hashMap.keySet();
    }

    @Test
    public void testClear() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "001");
        map.put("wgx01", "002");
        map.clear(); // 将数组中的每一个元素置null
    }

    @Test
    public void testSize() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "001");
        map.put("wgx01", "002");
        map.size(); // 实际上是在在entrySet 中的size
    }

    @Test
    public void testEntrySet() { // 以后遍历map就直接使用一下的两种方式中的一个，最好选用第二种
        /**
         * 此方法实现的思路还是和前面的keySet是一样的，只是在自定义实现的迭代器中取得值是存放数据的 Node<K,V> 类型，即使把key,value 都取出来了
         */
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "001");
        map.put("wgx01", "002");

        // 第一种遍历方式
        map.entrySet().iterator().forEachRemaining(new Consumer<Map.Entry<String, String>>() {
            @Override
            public void accept(Map.Entry<String, String> stringStringEntry) {
                System.out.println(stringStringEntry.getKey() + stringStringEntry.getValue());
            }
        });

        // 第二种遍历方式
        map.entrySet().iterator().forEachRemaining((Map.Entry<String, String> stringStringEntry) -> {
            String key = stringStringEntry.getKey();
            String value = stringStringEntry.getValue();
            System.out.println("key = " + key + " " + "value = " + value);
        });
    }

    @Test
    public void testContainsValue() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "001");
        map.put("wgx01", "002");
        boolean b = map.containsValue("002");
        System.out.println(b);
    }

    @Test
    public void testValues() {
        /**
         * 此方法实现的思路还是和前面的keySet是一样的，只是在自定义实现的迭代器中取得值是存放数据的 Node<K,V> 类型，现在只是取出Node中额value
         */
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "001");
        map.put("wgx01", "002");
        Collection<String> values = map.values();
    }

    @Test
    public void testForEach() { // 直接按照forEach 方式遍历map
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "001");
        map.put("wgx01", "002");
        // biConsumer 是接收连个参数的函数式接口
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + s2);
            }
        });
        map.forEach((str01, str02) -> {
            System.out.println(str01 + str02);
        });
    }

    @Test
    public void testHashCode() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "001");
        map.put("wgx01", "002");
        int hashCode = map.hashCode();
        System.out.println(hashCode);
    }

    @Test
    public void testIsEmpty() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "001");
        map.put("wgx01", "002");
        boolean empty = map.isEmpty();
        System.out.println(empty);
    }

    @Test
    public void testCompute() {
        /**
         * compute 函数,首先对key进行判断，是否存在
         * 1：如果存在则是执行BiFunction 中的apply（）函数
         * 2：其中s1和s2表示的是key和value
         * 3:返回的值指的是value
         */
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "001");
        map.put("wgx01", "002");
        map.compute("wgx002", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1 + s2;
            }
        });

        map.compute("qaz", (str01, str02) -> {
            return str01 + str02;
        });

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + "---" + s2);
            }
        });
    }

    @Test
    public void testComputeIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "plm");
        map.put("qaz", "002");
        map.computeIfAbsent("wgxqaz", new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });

        /**
         * 函数式接口中具体的实现是看具体的函数中接收的参数，一个或者是多个
         */
        map.computeIfAbsent("wsx", (str01) -> {
            return str01.toUpperCase();
        });

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + "---" + s2);
            }
        });
    }

    @Test
    public void testComputeIfPresent() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "PLM");
        map.put("qaz", "002");
        map.computeIfPresent("wgx", (str01, str02) -> {
            return str01.toUpperCase() + str02.toLowerCase();
        });

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + "---" + s2);
            }
        });
    }

    @Test
    public void testMerge() {
        /**
         * 如果不存在这个key的话，就直接添加的到map中去
         * 如果存在对应的key，则是执行BiFunction 中的apply函数,返回对应的value
         */
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "PLM");
        map.put("qaz", "002");
        map.merge("wgx", "456", (str01, str02) -> {
            return str01.toUpperCase() + str02;
        });

        map.forEach((key, value) -> {
            System.out.println(key + "---" + value);
        });
    }

    @Test
    public void testGetOrDefault() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "PLM");
        map.put("qaz", "002");
        /**
         * 如果输入的key有对应的值，则返回对应的value
         * 如果没有的话们就返回默认值
         */
        String orDefault = map.getOrDefault("123", "456");
        System.out.println(orDefault);
    }

    @Test
    public void testToString() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "PLM");
        map.put("qaz", "002");
        String string = map.toString();
        System.out.println(string);
    }

    @Test
    public void testPutIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "PLM");
        map.put("qaz", "002");
//        map.putIfAbsent() 底层还是调用putVal函数实现将数据放入map
    }

    @Test
    public void testReplaceAll() {
        Map<String, String> map = new HashMap<>();
        map.put("wgx", "PLM");
        map.put("qaz", "002");
        map.replaceAll(new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        });

        map.forEach((key, value) -> {
            System.out.println(key + "---" + value);
        });
    }
}
