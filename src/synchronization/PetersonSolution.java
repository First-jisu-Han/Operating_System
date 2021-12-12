package synchronization;
/* critical section 진입 방식을 소프트웨어적인 방법으로 해결하는 방법인
Peterson's Solution을 이론 기반으로 코드로 혼자 구현해봄
 */

public class PetersonSolution {
    public static void main(String[] args) {
    }
    static int process_cnt=999999;
    static boolean[] flag =new boolean[process_cnt];  // 프로세스각각이 가 critical section에 들어갈 수 있는지 여부
    static int turn; // critical section에 들어갈 차례 - 프로세스 번호로 설정

    public void process1(){
        flag[1]=true;
        int process2=2;  //프로세스2를 2로 표현
        turn=2;   // 다음 2번 프로세스 실행
        while(flag[2]==true && turn==process2){
            // 프로세스 p2의 차례이고, flag가 준비가 되었어도, p1이 먼저 실행되어야 하기때문에 여기서 대기
        }
        System.out.println("여기는 critical section, 프로세스가 필요한 데이터를 처리하도록.");
        flag[1]=false; // 다음 프로세스가 사용하도록
    }
// flag와 turn을 다르게 설정함으로써 , 각 프로세스의 코드들이 실행되면서 어떤 코드가 우선순위이던, 하나만 critical section에 진입하게 된다.
    public void process2(){
        flag[2]=true;
        int process1=1; // 프로세스 1을 1로 표햔
        turn=1;
        while(flag[1]==true && turn==process1) {
            // 프로세스 p1의 차례이고, flag가 준비가 되었어도, p2가 먼저 실행되어야 하기때문에 여기서 대기
        }
        System.out.println("여기는 critical section, 프로세스가 필요한 데이터를 처리하도록.");
        flag[2]=false; // 다음 프로세스가 사용하도록
    }

    }
