package com.parasjain.notifier.Services;

import java.util.Optional;

import com.parasjain.notifier.PojoClasses.User;
import com.parasjain.notifier.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String fetchId(String username, String password) {
        return userRepository.fetchId(username, password);
    }

    @Override
    public boolean fetchEnabled(String id) {
        return userRepository.fetchEnabled(id);
    }

    @Override
    public void updateEnable(boolean enable,String userId) {
        userRepository.updateEnable(enable,userId);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }
    
    
}
