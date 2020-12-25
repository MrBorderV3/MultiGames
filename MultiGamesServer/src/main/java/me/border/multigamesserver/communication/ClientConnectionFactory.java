package me.border.multigamesserver.communication;

import me.border.utilities.communication.base.ConnectionRunnable;
import me.border.utilities.communication.base.build.ConnectionFactory;
import me.border.utilities.communication.base.exception.FactoryException;
import me.border.utilities.communication.tcp.core.base.TCPClientConnection;

import java.io.IOException;
import java.net.Socket;

public class ClientConnectionFactory implements ConnectionFactory<TCPClientConnection> {

    private static final ClientConnectionFactory instance = new ClientConnectionFactory();

    private ClientConnectionFactory(){
    }

    @Override
    public TCPClientConnection constructConn(Socket socket) throws FactoryException {
        try {
            return new ClientConnection(socket);
        } catch (IOException ex){
            throw new FactoryException(ex);
        }
    }

    @Override
    public TCPClientConnection constructConn(Socket socket, ConnectionRunnable connectionRunnable) {
        throw new UnsupportedOperationException();
    }

    public static ClientConnectionFactory getInstance() {
        return instance;
    }
}
