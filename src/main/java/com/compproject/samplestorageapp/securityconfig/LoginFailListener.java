package com.compproject.samplestorageapp.securityconfig;

import com.compproject.samplestorageapp.service.LoginAttemptService;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
class LoginFailListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private final LoginAttemptService loginAttemptService;

    public LoginFailListener(LoginAttemptService loginAttemptService){
        this.loginAttemptService = loginAttemptService;
    }

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        String user = event.getAuthentication().getPrincipal().toString();

        loginAttemptService.loginFailed(user);
    }
}
