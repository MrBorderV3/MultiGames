package me.border.multigamescore.communication.response;

public abstract class Response {

    private final ResponseType type;
    private String message;
    private boolean hasMessage = false;

    /**
     * Construct a new response with the given type
     *
     * @param type The type
     */
    public Response(ResponseType type){
        this.type = type;
    }

    /**
     * Construct a new response with the given type and message
     *
     * @param type The type
     * @param message The message
     */
    public Response(ResponseType type, String message){
        this(type);
        this.message = message;
        hasMessage = true;
    }

    /**
     * Get the message of the response
     * This should be used after {@link #hasMessage()} to check for the existence of a message
     *
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get the type of the response
     *
     * @return The type
     */
    public ResponseType getType() {
        return type;
    }

    /**
     * Set the message of the response
     *
     * @param message The type
     */
    public void setMessage(String message) {
        this.message = message;
        hasMessage = true;
    }

    /**
     * Check if the response has a message
     *
     * @return Whether the response has a message
     */
    public boolean hasMessage(){
        return hasMessage;
    }
}
