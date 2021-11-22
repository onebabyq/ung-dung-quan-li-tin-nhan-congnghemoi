package com.example.androidprojectsmb.stomp.pathmatcher;


import com.example.androidprojectsmb.stomp.dto.StompHeader;
import com.example.androidprojectsmb.stomp.dto.StompMessage;

public class SimplePathMatcher implements PathMatcher {

    @Override
    public boolean matches(String path, StompMessage msg) {
        String dest = msg.findHeader(StompHeader.DESTINATION);
        if (dest == null) return false;
        else return path.equals(dest);
    }
}
