package com.agustinvon.jibberjabberfollowers.exceptions;

public class AlreadyFollowedException extends RuntimeException{
    public AlreadyFollowedException(String message) {
        super(message);
    }
}
