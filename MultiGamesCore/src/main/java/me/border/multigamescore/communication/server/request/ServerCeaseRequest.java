package me.border.multigamescore.communication.server.request;

import me.border.multigamescore.communication.core.request.Request;
import me.border.multigamescore.communication.core.request.RequestType;

public class ServerCeaseRequest extends Request {

    public ServerCeaseRequest() {
        super(RequestType.SERVER_CEASE, "The server has unexpectedly stopped, requesting cease.");
    }

    public ServerCeaseRequest(String message) {
        super(RequestType.SERVER_CEASE, message);
    }
}
