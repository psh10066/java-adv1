package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted()); // true
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                log("작업중");
            }
            // 예외가 터지지 않으면 interrupt 상태를 다시 false로 바꾸지 않는다.
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); // true

            try {
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) { // 인터럽트 상태여서 인터럽트가 발생하는 sleep과 같은 코드를 만나는 순간 인터럽트 예외 발생
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted()); // false
            }
            log("작업 종료");
        }
    }
}
