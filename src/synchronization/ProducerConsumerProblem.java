package synchronization;
/*      process 끼리는 데이터 영역을 공유할 수 있다.
        특히 producer-consumer process 에서 Producer는 자원을 생성하고,
        Consumer는 자원을 소비하는 관계를 이룬다.
        여기서 발생하는 문제가 동기화 문제이다 ( 데이터의 일치성을 유지시켜야함-공유 프로세스들이 서로 다른 공유 데이터값을 사용하게되는 걸 방지)
 */
import java.util.Scanner;

public class ProducerConsumerProblem {
    public static void main(String[] args) {

    }


    final static int BUFFER_SIZE = 10; // 저장공간의 크기
    static int counter = 7; // 저장공간의 안의 공유 데이터
    static String[] buffer=new String[BUFFER_SIZE]; // 저장공간
    static int in=7; // producer 프로세스가 지금 찍어내는 데이터 index- 7설정이유 : 현재 데이터가 차지하는 공간이 7이기때문에(index 6)
    static int out=1; // consumer 프로세스가 지금 사용하는 데이터


    // 생상자 프로세스 - 데이터 생성 , buffer(데이터 저장장소) 가 꽉차면 더이상 생산 안됨
    static class Producer {
        public static void produce() {
            Scanner sc=new Scanner(System.in);
            while (true) {
                // 버퍼가 꽉찼을때 - 데이터 더이상 만들어내기 불가능
                while (counter == BUFFER_SIZE) {
                    /* do nothing */
                }
                // 버퍼가 여유공간이있을때
                String next_produced=sc.next();
                buffer[in] = next_produced; // 버퍼저장공간의 마지막 값에 새로운 데이터 next_produced 추가- 데이터가 추가됨 in=7
                in = (in + 1) % BUFFER_SIZE; // 다음 저장될 공간 in=8
                counter++; //현재 데이터가 차있는 공간 8로 변경됨.
            }
        }}

    static class Consumer {
        public static void consume() {
            while (true) {
                // 저장공간에 쓸 데이터가 아무것도 없다면 정지
                while (counter == 0) {
                    /* do nothing */
                }
                String next_consumed = buffer[out]; // 저장공간에서 가져다 쓸 데이터가 1번째라면 next_consumed 에다가 buffer의 1번째 데이터 저장
                out = (out + 1) % BUFFER_SIZE;  // 다음 쓸 데이터 out 은  하나 올린 ,index 2
                counter--; // 데이터를 사용하였기 때문에  현재 데이터 수를 1개 감소
            }

        }
    }



            }

    /* 결론 : 동기화문제: 이 공유 데이터를 동시접근시 ( 프로세스가 동시에 공유 데이터에 같이 접근) buffer 개수가 달라질 수도 있고, 이용하는 데이터
        순서와 내용도 달라질 수 있음
     */



