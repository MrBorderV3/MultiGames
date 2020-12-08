package me.border.multigamescore.communication.request;

public abstract class Request {

    private final RequestType type;
    private String message;
    private boolean hasMessage = false;

    /**
     * Construct a new request with the given type
     *
     * @param type The type
     */
    protected Request(RequestType type){
        this.type = type;
    }

    /**
     * Construct a new request with the given type and message
     *
     * @param type The type
     * @param message The message
     */
    protected Request(RequestType type, String message){
        this(type);
        this.message = message;
        hasMessage = true;
    }

    /**
     * Get the message of the request
     * This should be used after {@link #hasMessage()} to check for the existence of a message
     *
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get the type of the request
     *
     * @return The type
     */
    public RequestType getType() {
        return type;
    }

    /**
     * Set the message of the request
     *
     * @param message The type
     */
    public void setMessage(String message) {
        this.message = message;
        hasMessage = true;
    }

    /**
     * Check if the request has a message
     *
     * @return Whether the request has a message
     */
    public boolean hasMessage(){
        return hasMessage;
    }
}
