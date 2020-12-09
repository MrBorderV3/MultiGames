package me.border.multigamescore.communication.client.request;

import me.border.multigamescore.communication.core.request.Request;
import me.border.multigamescore.communication.core.request.RequestType;

public class KeyRequest extends Request {

    public KeyRequest() {
        super(RequestType.CLIENT_KEY);
    }
}
