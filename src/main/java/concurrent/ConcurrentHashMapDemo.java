package concurrent;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhuwei on 2015/1/19.
 *  研究concurrentHashMap iterator 执行原理
 *  concurrentHashMap在遍历时是不加锁的，是根据整个concurrentHashMap 的数据结构一个个找的，
 *  找出所有不为空的entry
 *
 *
 *  关于 concurrentHashMap.size 的原理
 *  由于可以很快找出每个segment 中有多少个entry,(seg.count),所以，concurrentHashMap.size
 *  的结果就是每个segment.count 的和，但这里有一个小技巧，实现中是先进行不加锁的统计，在一定次数内
 *  如果前后统计的次数相同，那么即表示这期间没有线程进行map的修改，即是最后结果，如果
 *  在这几次中都没有统计出相同的结果，则要锁住所有的segment进行统计
 *
 *
 *
 *
 *
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap();

        map.put(1, "aa");
        map.put(2, "bb");

        Iterator<Map.Entry<Integer, String>> it =
                map.entrySet()
                .iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }
    }
}
