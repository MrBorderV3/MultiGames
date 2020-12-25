package me.border.multigamesserver.communication;

import me.border.utilities.communication.tcp.server.AbstractTCPClientConnection;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection extends AbstractTCPClientConnection {
    public ClientConnection(Socket client) throws IOException {
        super(client);
    }

    @Override
    public void run() {
        try (ObjectOutputStream oout = new ObjectOutputStream(out); ObjectInputStream oin = new ObjectInputStream(in)) {


        } catch (EOFException ignored){

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

