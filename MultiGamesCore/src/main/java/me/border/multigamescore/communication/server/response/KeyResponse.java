package me.border.multigamescore.communication.server.response;

import me.border.multigamescore.communication.core.response.Response;
import me.border.multigamescore.communication.core.response.ResponseType;

import java.security.PublicKey;

public class KeyResponse extends Response {

    private final PublicKey key;

    public KeyResponse(PublicKey key) {
        super(ResponseType.SERVER_KEY);
        this.key = key;
    }

    public PublicKey getKey() {
        return key;
    }
}
