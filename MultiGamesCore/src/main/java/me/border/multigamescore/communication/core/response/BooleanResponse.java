package me.border.multigamescore.communication.core.response;

public abstract class BooleanResponse extends Response {

    public BooleanResponse(ResponseType type, boolean response) {
        super(type);
    }

    public BooleanResponse(ResponseType type, boolean response, String message) {
        super(type, message);
    }

}
