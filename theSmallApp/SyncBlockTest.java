package theSmallApp;

import java.util.function.Consumer;

/*
 * 동기 블록킹 처리방식
 *  WorkerA는 자신이 해야하는 일과 WorkerB가 해야하는 일을 모두 가지고 있다.
 *  WorkerA는 WorkerB에게 일을 건내면, WorkerB은 전달받은 일을 수행
 *  WorkerA는 WorkerB가 일을 마친 후에 자신의 일을 수행
 */

public class SyncBlockTest {

    static class WorkerA {

        Consumer<String> workForA = (message) -> {
            for(int i = 0; i<5; i++) {
                for(int subIndex = 0; subIndex< Integer.MAX_VALUE; subIndex++) {

                }
                System.out.println("A : doing something.");
            }
            System.out.println("A : " + message);
        };

        Consumer<String> workForB = (message) -> {
            for (int index = 0; index < 5; index++) {
                for (int subIndex = 0; subIndex < Integer.MAX_VALUE; subIndex++) {
                }
                System.out.println("B: doing something.");
            }
            System.out.println("B: " + message);
        };

        void doMyWork() {
            workForA.accept("I'm worker A. And I'm done.");
        }

        Consumer<String> giveWorkToB() {
            return workForB;
        }
    }

    static class WorkerB {

        void takeMyWorkAndDoMyWork(Consumer<String> myWork) {
            myWork.accept("I'm worker B. And I'm done.");
        }
    }

    public static void main(String[] args) {
        WorkerA a = new WorkerA();
        WorkerB b = new WorkerB();
        b.takeMyWorkAndDoMyWork(a.giveWorkToB());
        a.doMyWork();
    }
}





