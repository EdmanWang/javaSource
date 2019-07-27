package javaSource.collection.set;

import org.junit.Test;

import java.util.EnumSet;
import java.util.Iterator;

//EnumSet 测试demo

/**
 * EnumSet的集合元素也是有序的，EnumSet以枚举值在Enum类内的定义顺序来决定集合元素的顺序。
 * EnumSet在内部以位向量的形式存储，这种存储形式非常紧凑、高效,因此EnumSet对象占用内存很小，而且运行效率很好。尤其是进行批量操作（如调用containsAll()和retainAll()方法）时，如果其参数也是EnumSet集合，则该批量操作的执行速度也非常快。
 * EnumSet集合不允许加入null元素，如果试图插入null元素，EnumSet将抛出NullPointerException异常。
 * EnumSet类没有暴露任何构造器来创建该类的实例，程序应该通过它提供的类方法来创建EnumSet对象。
 * 如果只是想判断EnumSet是否包含null元素或试图删除null元素都不会抛出异常，只是删除操作将返回false，因为没有任何null元素被删除。
 */
public class EnumSetDemo {

    public enum Style{
        READ((Integer) 1),
        BULE((Integer) 2),
        ;

        private Integer type;

        Style(Integer type) {
            this.type = type;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }

    @Test
    public void test() {
        EnumSet enumSet = EnumSet.allOf(Style.class);
        System.out.println(enumSet);
    }
}
