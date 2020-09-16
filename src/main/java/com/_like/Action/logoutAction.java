package com._like.Action;

import com.opensymphony.xwork2.ActionSupport;

public class logoutAction extends ActionSupport {

    public String execute() throws Exception {
        return "login";
    }
}
