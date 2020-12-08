package me.border.multigamescore.communication.request.client;

import me.border.multigamescore.communication.request.Request;
import me.border.multigamescore.communication.request.RequestType;

public class LoginRequest extends Request {

    private final String username;
    private final String password;

    protected LoginRequest(String username, String password) {
        super(RequestType.CLIENT_LOGIN);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
