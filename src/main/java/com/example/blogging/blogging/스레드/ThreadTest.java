package com.example.blogging.blogging.스레드;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("스레드 테스트 시작" );

        int threadCount = 10;

        // 일반 스레드 실행
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        // 모든 스레드가 완료될 때까지 대기
        for (Thread thread : threads) {
            thread.join();
        }

        // 가상 스레드 실행 (Java 19 이상에서 사용 가능)
//        Thread[] virtualThreads = new Thread[threadCount];
//        for (int i = 0; i < threadCount; i++) {
//            virtualThreads[i] = Thread.ofVirtual().start(() -> {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        for (Thread virtualThread : virtualThreads) {
//            virtualThread.join();
//        }

        long endTime = System.currentTimeMillis();
        System.out.println("모든 스레드가 완료되었습니다. 소요 시간 = " + (endTime - startTime) + "ms");
    }
}
