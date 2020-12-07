package me.border.multigamescore.communication.request.client;

import me.border.multigamescore.communication.request.Request;
import me.border.multigamescore.communication.request.RequestType;

public class LoginRequest extends Request {
    public LoginRequest() {
        super(RequestType.CLIENT_LOGIN);
    }

    public LoginRequest(String message) {
        super(RequestType.CLIENT_LOGIN, message);
    }
}
