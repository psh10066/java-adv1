package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        // Java 기본 스레드 : main
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        helloThread.start(); // 스레드 간 실행 순서는 보장되지 않는다. (실행 지시 후 main 스레드는 자기 일 계속 진행)
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
