package com.example.androidprojectsmb.stomp.provider;


import com.example.androidprojectsmb.stomp.dto.LifecycleEvent;

import io.reactivex.Completable;
import io.reactivex.Observable;


/**
 * Created by naik on 05.05.16.
 */
public interface ConnectionProvider {

    /**
     * Subscribe this for receive stomp messages
     * @return
     */
    //Observable<String> messages();
    Observable<String> messages();
    /**
     * Sending stomp messages via you ConnectionProvider.
     * onError if not connected or error detected will be called, or onCompleted id sending started
     * TODO: send messages with ACK
     */
    Completable send(String stompMessage);

    /**
     * Subscribe this for receive #LifecycleEvent events
     */
    Observable<LifecycleEvent> lifecycle();

    /**
     * Disconnects from server. This is basically a Callable.
     * Automatically emits Lifecycle.CLOSE
     */
    Completable disconnect();
}
