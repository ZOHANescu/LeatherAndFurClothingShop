package org.loose.fis.lfcs.exceptions;

public class UserInvalidCredentials extends Exception{
    public UserInvalidCredentials(){
        super("Invalid Username or Password.");
    }
}
