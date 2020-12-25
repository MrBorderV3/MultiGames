package me.border.multigamesserver.communication;

import me.border.utilities.communication.tcp.server.AbstractTCPServer;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server extends AbstractTCPServer {

    public Server() {
        super(9090,  new ThreadPoolExecutor(0, Integer.MAX_VALUE, 300L, TimeUnit.SECONDS, new SynchronousQueue<>()));
    }

    @Override
    public void start() {
        start(ClientConnectionFactory.getInstance());
    }

}
