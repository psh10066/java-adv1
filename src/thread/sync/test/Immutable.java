package thread.sync.test;

class Immutable {
    private final int value; // 여러 스레드가 접근 가능한 공유 자원이라도 그 값을 아무도 변경할 수 없다면 문제되지 않는다. (모든 스레드가 항상 같은 값을 읽기 때문)

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
