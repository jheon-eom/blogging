package com.example.blogging.blogging.스레드;

import org.springframework.stereotype.Component;

@Component
public class PushNotificationSender {

    public void send(Object subscribers) {
        // 구독자들에게 푸시 알림을 전송합니다.
        // 예: 구독자 목록, 알림 내용 등
        try {
            System.out.println("Saving feed notification");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // 예외 처리 로직
            e.printStackTrace();
        }
    }
}
