package com.sriTel.notification_service.controller;

import com.sriTel.notification_service.model.Notification;
import com.sriTel.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody Notification notification) {
        notificationService.sendEmail(notification);
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }

    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody Notification notification) {
        notificationService.sendSms(notification);
        return new ResponseEntity<>("SMS sent successfully", HttpStatus.OK);
    }

    @PostMapping("/send-notification")
    public ResponseEntity<String> sendPushNotification(@RequestBody Notification notification) {
        notificationService.sendPushNotification(notification);
        return new ResponseEntity<>("Push notification sent successfully", HttpStatus.OK);
    }
}

