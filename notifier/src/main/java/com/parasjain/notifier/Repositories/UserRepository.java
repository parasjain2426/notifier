package com.parasjain.notifier.Repositories;

import com.parasjain.notifier.PojoClasses.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User,String>{
    
    
    @Query("Select id from User where username=:username and password=:password")
    String fetchId(@Param("username")String username,@Param("password")String password);

    @Query("Select enabled from User where id=:id")
    boolean fetchEnabled(@Param("id")String id);

    @Transactional
    @Modifying
    @Query("Update User Set enabled=:enable where id=:userId")
    void updateEnable(@Param("enable")boolean enable,@Param("userId")String userId);

}
