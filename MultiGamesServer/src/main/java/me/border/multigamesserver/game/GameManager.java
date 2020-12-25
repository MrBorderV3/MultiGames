package me.border.multigamesserver.game;

import me.border.utilities.communication.tcp.core.base.TCPClientConnection;

public class GameManager {

    private static int id = 0;

    private final String name;
    private final TCPClientConnection black;
    private final TCPClientConnection white;

    public GameManager(TCPClientConnection black, TCPClientConnection white){
        this.name = "GameManager-" + id;
        id++;

        this.black = black;
        this.white = white;
    }


    private void start(){
    }
}
