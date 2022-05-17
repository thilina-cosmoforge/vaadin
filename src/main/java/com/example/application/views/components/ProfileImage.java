package com.example.application.views.components;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Div;

public class ProfileImage extends Div {

    public ProfileImage() {
        Avatar user = new Avatar("User");
        user.setImage("https://dcstatic.com/images/brandcrowd/logos/brandcrowd-logo-5d59400c52.svg");

        add(user);
    }
}
