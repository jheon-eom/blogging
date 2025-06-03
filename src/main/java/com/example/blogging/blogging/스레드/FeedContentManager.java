package com.example.blogging.blogging.스레드;

import org.springframework.stereotype.Component;

@Component
public class FeedContentManager {

    public void save(User uploader, Object requestContent) {
        // 피드의 콘텐츠를 저장합니다.
        // 예: 업로더 정보, 콘텐츠 데이터 등
        try {
            System.out.println("Saving feed content");
            Thread.sleep(500); // 콘텐츠 저장 시뮬레이션
        } catch (InterruptedException e) {
            // 예외 처리 로직
            e.printStackTrace();
        }
    }
}
