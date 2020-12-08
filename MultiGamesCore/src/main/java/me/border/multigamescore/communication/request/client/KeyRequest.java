package me.border.multigamescore.communication.request.client;

import me.border.multigamescore.communication.request.Request;
import me.border.multigamescore.communication.request.RequestType;

public class KeyRequest extends Request {

    protected KeyRequest() {
        super(RequestType.CLIENT_KEY);
    }
}
