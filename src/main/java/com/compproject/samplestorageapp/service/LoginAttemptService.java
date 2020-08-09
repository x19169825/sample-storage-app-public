package com.compproject.samplestorageapp.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class LoginAttemptService {

    private final LoadingCache<String, Integer>  loginAttemptCache;

    protected LoginAttemptService() {
        super();
        loginAttemptCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
            public Integer load(String key){
                return 0;
            }
        });
    }

    public void loginSuccess( final String key) {
        loginAttemptCache.invalidate(key);
    }

    public void loginFailed(final String key) {
        int attempts;
        try {
            attempts = loginAttemptCache.get(key);
        } catch (ExecutionException e) {
            attempts = 0;
        }
        attempts++;
        loginAttemptCache.put(key, attempts);
    }

    public boolean accountLocked(final String key) throws ExecutionException {
        try {
            final int MAX_ATTEMPT = 3;
            return loginAttemptCache.get(key) >= MAX_ATTEMPT;
        } catch (ExecutionException e) {
            throw new ExecutionException(e);
        }
    }
}