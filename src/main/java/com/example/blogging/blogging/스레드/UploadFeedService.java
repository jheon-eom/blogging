package com.example.blogging.blogging.스레드;

import org.springframework.stereotype.Service;

@Service
public class UploadFeedService {

    public UploadFeedService(
            FeedMetaDataManager feedMetaDataManager,
            FeedContentManager feedContentManager,
            PushNotificationSender pushNotificationSender,
            FeedSearchManager feedSearchManager
    ) {
        this.feedMetaDataManager = feedMetaDataManager;
        this.feedContentManager = feedContentManager;
        this.pushNotificationSender = pushNotificationSender;
        this.feedSearchManager = feedSearchManager;
    }

    private final FeedMetaDataManager feedMetaDataManager;
    private final FeedContentManager feedContentManager;
    private final PushNotificationSender pushNotificationSender;
    private final FeedSearchManager feedSearchManager;

    /**
     * 피드 업로드 프로세스를 처리합니다.
     */
    public void uploadProcess(User uploader, UploadFeedRequest request) {
        // 피드 메타데이터 저장
        Thread t1 = new Thread(() -> {
            feedMetaDataManager.save(uploader, request.getMetaData());
        });
        t1.start();

        // 피드 컨텐츠 파일 저장
        Thread t2 = new Thread(() -> {
            feedContentManager.save(uploader, request.getContent());
        });
        t2.start();

        // 업로더 구독자에게 알림 전송
        Thread t3 = new Thread(() -> {
            pushNotificationSender.send(uploader.getSubscribers());
        });
        t3.start();

        // 피드 검색 인덱스 업데이트
        Thread t4 = new Thread(() -> {
            feedSearchManager.updateIndexes(uploader, request.getKeywordIndexes());
        });
        t4.start();

        // 모든 스레드가 완료될 때까지 대기 후 종료
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadProcessOfVirtual(User uploader, UploadFeedRequest request) {
        // 피드 메타데이터 저장
        Thread t1 = Thread.ofVirtual().start(() -> feedMetaDataManager.save(uploader, request.getMetaData()));

        // 피드 컨텐츠 파일 저장
        Thread t2 = Thread.ofVirtual().start(() -> feedContentManager.save(uploader, request.getContent()));

        // 업로더 구독자에게 알림 전송
        Thread t3 = Thread.ofVirtual().start(() -> pushNotificationSender.send(uploader.getSubscribers()));

        // 피드 검색 인덱스 업데이트
        Thread t4 = Thread.ofVirtual().start(() -> feedSearchManager.updateIndexes(uploader, request.getKeywordIndexes()));

        // 모든 스레드가 완료될 때까지 대기 후 종료
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


