package me.border.multigamescore.communication.response.server;

import me.border.multigamescore.communication.response.Response;
import me.border.multigamescore.communication.response.ResponseType;

import java.security.PublicKey;

public class KeyResponse extends Response {

    private final PublicKey key;

    protected KeyResponse(PublicKey key) {
        super(ResponseType.SERVER_KEY);
        this.key = key;
    }

    public PublicKey getKey() {
        return key;
    }
}
