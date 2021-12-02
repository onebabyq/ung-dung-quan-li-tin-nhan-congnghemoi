package com.example.androidprojectsmb.stomp.provider;


import android.util.Log;


import com.example.androidprojectsmb.stomp.dto.LifecycleEvent;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by forresthopkinsa on 8/8/2017.
 * <p>
 * Created because there was a lot of shared code between JWS and OkHttp connection providers.
 */

public abstract class AbstractConnectionProvider implements ConnectionProvider {

    private static final String TAG = AbstractConnectionProvider.class.getSimpleName();

    @NonNull
    private final PublishSubject<LifecycleEvent> lifecycleStream;
    @NonNull
   // private final PublishSubject<String> messagesStream;
    private final PublishSubject<String> messagesStream;

    public AbstractConnectionProvider() {
        lifecycleStream = PublishSubject.create();
        messagesStream = PublishSubject.create();
    }

    @NonNull
    @Override
    public Observable<String> messages() {
        return messagesStream.startWith(initSocket().toObservable());
    }
//    public Observable<ChatMessage> messages() {
//        return messagesStream;
//    }

    /**
     * Simply close socket.
     * <p>
     * For example:
     * <pre>
     * webSocket.close();
     * </pre>
     */
    protected abstract void rawDisconnect();

    @Override
    public Completable disconnect() {
        return Completable
                .fromAction(this::rawDisconnect);
    }

    private Completable initSocket() {
        return Completable
                .fromAction(this::createWebSocketConnection);
    }

    /**
     * Most important method: connects to websocket and notifies program of messages.
     * <p>
     * See implementations in OkHttpConnectionProvider and WebSocketsConnectionProvider.
     */
    protected abstract void createWebSocketConnection();

    @NonNull
    @Override
    public Completable send(String stompMessage) {
        return Completable.fromCallable(() -> {
            if (getSocket() == null) {
                throw new IllegalStateException("Not connected");
            } else {
                Log.d(TAG, "Send STOMP message: " + stompMessage);
                rawSend(stompMessage);
                return null;
            }
        });
    }

    /**
     * Just a simple message send.
     * <p>
     * For example:
     * <pre>
     * webSocket.send(stompMessage);
     * </pre>
     *
     * @param stompMessage message to send
     */
    protected abstract void rawSend(String stompMessage);

    /**
     * Get socket object.
     * Used for null checking; this object is expected to be null when the connection is not yet established.
     * <p>
     * For example:
     * <pre>
     * return webSocket;
     * </pre>
     */
    @Nullable
    protected abstract Object getSocket();

    protected void emitLifecycleEvent(@NonNull LifecycleEvent lifecycleEvent) {
        Log.d(TAG, "Emit lifecycle event: " + lifecycleEvent.getType().name());
        lifecycleStream.onNext(lifecycleEvent);
    }

    protected void emitMessage(String stompMessage) {
        Log.d(TAG, "Receive STOMP message: " + stompMessage);

        messagesStream.onNext(stompMessage);
    }

    @NonNull
    @Override
    public Observable<LifecycleEvent> lifecycle() {
        return lifecycleStream;
    }

}
