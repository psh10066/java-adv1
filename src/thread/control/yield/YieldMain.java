package thread.control.yield;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 1. empty : 상대적으로 하나의 스레드가 연달아 출력됨 (운영체제 스케줄링 정책과 환경에 따라 다르지만 대략 10ms정도 하나의 스레드가 실행됨)
                // sleep(1); // 2. sleep : 스레드가 엄청 섞여서 출력됨 (스레드의 상태를 RUNNABLE -> TIMED_WAITING으로 변경하여 스레드가 CPU 자원을 사용하지 않고 실행 스케줄링에서 제외하므로 다른 스레드가 없어도 내 스레드도 실행되지 않음)
                // Thread.yield(); // 3. yield : 섞이지만 sleep보다는 자주 스레드 단위로 출력됨 (RUNNABLE 상태 내에서 잠깐 실행 대기 상태로 변경되며 바로 스케줄링 큐에 진입. 운영체제의 스케줄러에게 단지 힌트를 제공할 뿐, 강제적인 실행 순서를 지정하지는 않음)
            }
        }
    }
}
