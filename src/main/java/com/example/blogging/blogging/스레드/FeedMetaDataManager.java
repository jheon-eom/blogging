package com.example.blogging.blogging.스레드;

import org.springframework.stereotype.Component;

@Component
public class FeedMetaDataManager {

    public void save(User uploader, Object metaData) {
        // 피드의 메타데이터를 저장합니다.
        // 예: 업로더 정보, 업로드 시간, 피드 ID 등
        try {
            System.out.println("Saving feed metadata");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // 예외 처리 로직
            e.printStackTrace();
        }
    }
}
