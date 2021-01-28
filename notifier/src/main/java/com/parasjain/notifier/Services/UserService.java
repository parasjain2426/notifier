package com.parasjain.notifier.Services;

import java.util.Optional;

import com.parasjain.notifier.PojoClasses.User;

public interface UserService {
    String fetchId(String username,String password);
    boolean fetchEnabled(String id);
    void updateEnable(boolean enable,String userId);
	void save(User user);
	Optional<User> findById(String id);
}
