package com.codingshuttle.linkedin.notification_service.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendConnectionRequestEvent {
//    setup producer in connections service
    private Long senderId;
    private Long receiverId;
}
