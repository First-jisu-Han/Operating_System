package synchronization;
// compare_and_swap()
public class HardwareInstruction2 {
    public static void main(String[] args) {
        int lock2=0;   // lock이 걸려있지 않은 상태로 출발
        while(true){
            while(compare_and_swap(lock2,0,1) !=0){
                System.out.println("lock 이 걸린 상태 0이면 lock이 해제되니 그때 critical section에 진입하도록");
            }
            /* critical section */
            lock2=0;    // compare_and_swap 메서드안에서 lock2가 1인상태로 잠궈놓고 critical section에 들어가기 때문에 풀어줘야 프로세스가 진입함.
        }
    }
    public static int compare_and_swap(int value , int expected , int new_value){
        int temp = value;      // 처음에는 value가 0 - 즉 lock 걸리지 않은 상태로 출발할 것
        if(value==expected){
            value=new_value;    // lock을 걸어줌
        }
        return temp;
    }

}
