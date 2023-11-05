package com.sriTel.notification_service.service;

import com.sriTel.notification_service.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;

import java.io.IOException;
import java.io.InputStream;


@Service
public class NotificationService {

    private final JavaMailSender javaMailSender;

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "your_account_sid";
    public static final String AUTH_TOKEN = "your_auth_token";

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Notification notification) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(notification.getRecipient());
        mailMessage.setSubject("Notification");
        mailMessage.setText(notification.getContent());
        javaMailSender.send(mailMessage);
    }

//    public void sendSms(Notification notification) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//        Message message = Message.creator(
//                        new PhoneNumber(notification.getRecipient()), // to
//                        new PhoneNumber("your_twilio_phone_number"), // from
//                        notification.getContent())
//                .create();
//
//        System.out.println(message.getSid());
    }

//    public void sendPushNotification(Notification notification) throws FirebaseMessagingException {
//        Message message = Message.builder()
//                .putData("content", notification.getContent())
//                .setToken(notification.getRecipient())
//                .build();
//        String response = firebaseMessaging.send(message);
//        System.out.println("Sent message: " + response);
//    }
}
