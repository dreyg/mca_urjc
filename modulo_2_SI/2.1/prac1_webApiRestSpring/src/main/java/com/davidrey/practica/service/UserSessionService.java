package com.davidrey.practica.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSessionService {

    private String user;
    private int numPosts;

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public int getNumPosts() {
        return this.numPosts;
    }

    public void incNumPosts() {
        this.numPosts++;
    }

}
