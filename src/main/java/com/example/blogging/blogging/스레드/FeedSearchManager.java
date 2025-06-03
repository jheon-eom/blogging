package com.example.blogging.blogging.스레드;

import org.springframework.stereotype.Component;

@Component
public class FeedSearchManager {

    public void updateIndexes(User uploader, Object keywordIndexes) {
        // 피드의 키워드 인덱스를 업데이트합니다.
        // 예: 업로더 정보, 키워드 인덱스 등
        try {
            System.out.println("Saving feed search indexes");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // 예외 처리 로직
            e.printStackTrace();
        }
    }
}
