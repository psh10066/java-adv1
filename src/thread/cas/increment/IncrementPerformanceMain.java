package thread.cas.increment;

public class IncrementPerformanceMain {

    public static final long COUNT = 100_000_000;

    public static void main(String[] args) {
        test(new BasicInteger()); // 가장 빠르다. CPU 캐시를 적극 사용한다. 멀티스레드 상황에는 사용할 수 없다. 단일 스레드 사용 시 효율적이다.
        test(new VolatileInteger()); // 메인 메모리를 사용한다. 멀티스레드 상황에는 사용할 수 없다. 단일 스레드여도 BasicInteger보다 느리다.
        test(new SyncInteger()); // 안전한 임계 영역에 있기 때문에 멀티스레드 상황에 안전하다. MyAtomicInteger보다 성능이 느리다.
        test(new MyAtomicInteger()); // 자바가 제공하는 AtomicInteger를 사용한다. 멀티스레드 상황에 안전하다. 성능도 synchronized보다 빠르다.
    }

    private static void test(IncrementInteger incrementInteger) {
        long startMs = System.currentTimeMillis();

        for (long i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }

        long endMs = System.currentTimeMillis();
        System.out.println(incrementInteger.getClass().getSimpleName() + ": ms=" + (endMs - startMs));
    }
}
