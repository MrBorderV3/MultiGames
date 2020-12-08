package me.border.multigamescore.communication.response;

public abstract class BooleanResponse extends Response {

    protected BooleanResponse(ResponseType type, boolean response) {
        super(type);
    }

    protected BooleanResponse(ResponseType type, boolean response, String message) {
        super(type, message);
    }

}
