package com.compproject.samplestorageapp.securityconfig;
import com.compproject.samplestorageapp.service.LoginAttemptService;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessListener implements ApplicationListener<AuthenticationSuccessEvent>  {

    private final LoginAttemptService loginAttemptService;

    public LoginSuccessListener(LoginAttemptService loginAttemptService){
        this.loginAttemptService = loginAttemptService;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String user = event.getAuthentication().getPrincipal().toString();

        loginAttemptService.loginSuccess(user);
    }
}


