package com.example.application.services;

import com.example.application.entity.ImageUser;
import com.example.application.repository.UserRepository;
import com.vaadin.flow.server.StreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Service
public class ImageUserService {
    @Autowired
    UserRepository userRepository;

    public Image generateImage(ImageUser imageUser) {
        Long id = Long.valueOf(imageUser.getUserId());
        StreamResource sr = new StreamResource("user", () -> {
            ImageUser attached = userRepository.findWithPropertyPictureAttachedById(id);
            return new ByteArrayInputStream(attached.getProfilePicture());
        });
//        sr.setContentType("image/png");
//        Image image = new Image(sr,"pro") {
//            @Override
//            public int getWidth(ImageObserver observer) {
//                return 0;
//            }
//
//            @Override
//            public int getHeight(ImageObserver observer) {
//                return 0;
//            }
//
//            @Override
//            public ImageProducer getSource() {
//                return null;
//            }
//
//            @Override
//            public Graphics getGraphics() {
//                return null;
//            }
//
//            @Override
//            public Object getProperty(String name, ImageObserver observer) {
//                return null;
//            }
//        };
//        return image;
        return null;
    }
}
