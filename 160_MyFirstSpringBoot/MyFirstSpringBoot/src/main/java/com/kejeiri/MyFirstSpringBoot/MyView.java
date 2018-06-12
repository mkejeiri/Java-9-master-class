package com.kejeiri.MyFirstSpringBoot;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "")
public class MyView extends UI {

    //tells spring to inject this service
    @Autowired
    private Service service;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();

        TextField username = new TextField(service.showName("Username"));
        PasswordField password = new PasswordField(service.showName("Password"));
        Button logIn = new Button("Log in");
        Label label = new Label();
        logIn.addClickListener(clickEvent -> {
            Notification.show("User " + username.getValue() + " is logged in");
            label.setValue(service.showName("User " + username.getValue() + " is logged in"));
        });
        layout.addComponents(username,password,logIn,label);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }
}
