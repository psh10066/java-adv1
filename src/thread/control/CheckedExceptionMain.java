package thread.control;

import static util.ThreadUtils.sleep;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {

        @Override
        public void run() /*throws Exception*/ {
            // interface에서 정의되지 않은 예외를 던질 수 없다.
//            throw new Exception();

            sleep(3000);
        }
    }
}
