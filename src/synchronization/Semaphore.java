package synchronization;
// Semaphore(수신호) 에는 대기큐와 integer타입의 변수가 들어있는 동기화 도구이다.
public class Semaphore {
    public static void main(String[] args) {

    }

    /* 리스트 S 의 value 값을 감소시켜주면서 value 값이 음수이면 waiting queue에 있는 것을 하나 더 늘려주고 잠재운다.

    wait(semaphore *S){
        S<- value--;
        if(S->value<0){
            add this process to S->List
            sleep();
     */

    /* 리스트 S 의 value 값을 증가시켜주면서 value 값이 음수거나 0 이라면 waiting queue에 있는 것을 하나 제거하고 깨워준다.
    signal(semaphore *S) {
         S->value++;
         if(S->value<=0){
         remove a process P from S-> list;
         wakeup(P);
     */

}
