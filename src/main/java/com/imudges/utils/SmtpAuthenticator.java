package com.imudges.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by cyy on 2016/12/12.
 */
public class SmtpAuthenticator extends Authenticator {
    String username = null;
    String password = null;

    // SMTP身份验证
    public SmtpAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.username, this.password);
    }

}

