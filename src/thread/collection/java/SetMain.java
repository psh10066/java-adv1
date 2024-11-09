package thread.collection.java;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> copySet = new CopyOnWriteArraySet<>(); // HashSet의 대안.
        copySet.add(1);
        copySet.add(2);
        copySet.add(3);
        System.out.println("copySet = " + copySet);

        Set<Object> skipSet = new ConcurrentSkipListSet<>(); // TreeSet의 대안. Comparator 사용 가능
        skipSet.add(3);
        skipSet.add(1);
        skipSet.add(2);
        System.out.println("skipSet = " + skipSet);
    }
}
