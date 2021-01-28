package com.parasjain.notifier.PojoClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id
    private String id;

    @Column(nullable = false)
    private String username;

    private String mobileNo;

    private String email;

    @Column(nullable = false)
    private String password;
    
	private boolean enabled;

    public User(){
    }

    public void setId(String id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setMobileNo(String mobileNo){
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    public String getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getMobileNo(){
        return this.mobileNo;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean getEnabled(){
        return this.enabled;
    }

}
