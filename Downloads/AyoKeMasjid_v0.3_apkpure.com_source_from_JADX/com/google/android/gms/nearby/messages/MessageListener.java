package com.google.android.gms.nearby.messages;

public abstract class MessageListener {
    public abstract void onFound(Message message);

    public void onLost(Message message) {
    }
}
