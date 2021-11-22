package com.example.androidprojectsmb.stomp.pathmatcher;


import com.example.androidprojectsmb.stomp.dto.StompMessage;

public interface PathMatcher {

    boolean matches(String path, StompMessage msg);
}
