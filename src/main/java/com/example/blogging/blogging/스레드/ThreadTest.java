package com.example.blogging.blogging.스레드;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    private static final int THREAD_POOL_SIZE = 1000;
    private static final int TASK_COUNT = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("스레드 테스트 시작" );

        // 일반 스레드 실행
//        basicThreadStart();
        // 가상 스레드 실행
        virtualThreadStart();

        long endTime = System.currentTimeMillis();
        System.out.println("모든 스레드가 완료되었습니다. 소요 시간 = " + (endTime - startTime) + "ms");
    }

    private static void basicThreadStart() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        // 일반 스레드 생성 및 시작
        for (int i = 0; i < TASK_COUNT; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 스레드 풀 종료
        executor.shutdown();
        // 모든 작업이 완료될 때까지 대기
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    private static void virtualThreadStart() throws InterruptedException {
        Thread[] virtualThreads = new Thread[TASK_COUNT];
        // 가상 스레드 생성 및 시작
        for (int i = 0; i < TASK_COUNT; i++) {
            virtualThreads[i] = Thread.ofVirtual().start(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.join();
        }
    }
}
