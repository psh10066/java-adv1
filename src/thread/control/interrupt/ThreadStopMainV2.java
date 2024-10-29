package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted()); // true
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) { // 인터럽트 체크 안함
                    log("작업중");
                    Thread.sleep(3000); // 여기서만 인터럽트 발생
                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); // false
                log("interrupt message = " + e.getMessage()); // sleep interrupted
                log("state = " + Thread.currentThread().getState()); // RUNNABLE
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}
