package synchronization;
// test_and_set()
public class HardwareInstruction1 {
    public static void main(String[] args) {
        boolean lock1 = false; //lock 이 걸려있지 않은 상태로 출발
        do {
            while (test_and_set(lock1)) {
                System.out.print("lock이 걸려있는 상태 대기 하도록한다");
            }
            /* critical section */

            lock1 = false;  // 다른 프로세스가 진입하도록 허용
        } while (true);
    }

    public static boolean test_and_set(boolean target){
        boolean rv = target;
        target=true;    // 다르른 프로세스가 들어오지않도록 lock 설정함

        return rv;
    }
}
