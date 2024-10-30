package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMainV1 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        t.start();

        sleep(1000);

        task.flag = false;
        log("flag = " + task.flag + ", count = " + task.count + " in main");
    }

    static class MyTask implements Runnable {

        boolean flag = true;
        long count;

        @Override
        public void run() {
            while (flag) {
                count++;
                // 1억번에 한번씩 출력
                if (count % 100_000_000 == 0) {
                    log("flag = " + flag + ", count = " + count + " in while()");
                }
            }
            // 정확히 1억의 배수에서 출력되는 이유 : 위에서 출력하면서 컨텍스트 스위칭이 일어나며 캐시 메모리가 갱신되기 때문
            // (주로 그렇다는 것이지 정확히 그렇다는 것은 아니다.)
            log("flag = " + flag + ", count = " + count + " 종료");
        }
    }
}
