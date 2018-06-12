package com.kejeiri.WeatherApp.view;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI(path = "")
public class MainView  extends UI {


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        //Label label = new Label("hello there");
        TextField username = new TextField("Username");
        PasswordField passwordField = new PasswordField("Password");
        Button btnLogin = new Button("Login");
        Label label = new Label("");

        btnLogin.addClickListener(clickEvent -> {
            label.setValue("Usename : " + username.getValue() + " password: " + passwordField.getValue() + " Is logged in!");
            Notification.show("Usename : " + username.getValue() + " password: " + passwordField.getValue() + " Is logged in!");
        });

/*        HorizontalLayout sublayout = new HorizontalLayout();
       *//* sublayout.setSpacing(true);
        sublayout.setMargin(true);*//*
        sublayout.addComponent(username);
        sublayout.addComponent(passwordField);
        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        layout.setResponsive(true);
        layout.addComponent(sublayout);
        layout.addComponent(btnLogin);
        layout.addComponent(label);*/
        VerticalLayout layout = new VerticalLayout();

        layout.setSpacing(true);
        layout.setMargin(true);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        layout.addComponents(username,passwordField,btnLogin,label);
        setContent(layout);
    }
}
