package me.border.multigamescore.communication.server.response;

import me.border.multigamescore.communication.core.response.BooleanResponse;
import me.border.multigamescore.communication.core.response.ResponseType;

public class LoginResponse extends BooleanResponse {

    public LoginResponse(boolean response) {
        super(ResponseType.SERVER_LOGIN, response);
    }
}
