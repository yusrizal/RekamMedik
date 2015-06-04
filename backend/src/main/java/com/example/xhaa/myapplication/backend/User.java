package com.example.xhaa.myapplication.backend;

import java.util.Date;


/**
 * Created by xhaa on 6/4/15.
 */
public class User {

    private Long id;
    public String username;
    public String firstName;
    public String lastName;
    public String address;
    public Date birthDay;
    public String birthPlace;

    public Long getId(){
        return id;
    }
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return lastName;}
    public void setLastNgame(String lastName){this.lastName = lastName;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address= address;}

    public Date getBirthDay(){return birthDay;}
    public void setBirthDay(Date birthDay){this.birthDay= birthDay;}

    public String getBirthPlace(){return birthPlace;}
    public void setBirthPlace(String birthPlace){this.birthPlace= birthPlace;}

}
