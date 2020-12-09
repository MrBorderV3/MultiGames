package me.border.multigamescore.communication.client.request;

import me.border.multigamescore.communication.core.request.Request;
import me.border.multigamescore.communication.core.request.RequestType;

public class ClientCeaseRequest extends Request {

    public ClientCeaseRequest() {
        super(RequestType.CLIENT_CEASE, "The client has unexpectedly stopped, requesting cease.");
    }

    public ClientCeaseRequest(String message) {
        super(RequestType.CLIENT_CEASE, message);
    }
}
