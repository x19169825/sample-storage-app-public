package com.compproject.samplestorageapp.service;

import com.compproject.samplestorageapp.model.users.EndUser;
import com.compproject.samplestorageapp.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Primary
@Service
public class MyUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;
    private final LoginAttemptService loginAttemptService;


    public MyUserDetailsService(UserRepository userRepository, LoginAttemptService loginAttemptService){
        this.userRepository = userRepository;
        this.loginAttemptService = loginAttemptService;
    }

    @SneakyThrows
    @Override
    public EndUserService loadUserByUsername(String username) throws UsernameNotFoundException{
       EndUser endUser = userRepository.findByUsername(username);
       String endUserString = endUser.getUsername();


       if(loginAttemptService.accountLocked(endUserString)) {
           throw new RuntimeException("account is locked");
       }

       try{
           return new EndUserService(endUser);

       }catch(UsernameNotFoundException e){
           throw new RuntimeException(e);
       }
    }
}
