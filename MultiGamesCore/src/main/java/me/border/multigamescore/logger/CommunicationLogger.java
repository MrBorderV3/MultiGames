package me.border.multigamescore.logger;

import me.border.multigamescore.communication.core.request.Request;
import me.border.multigamescore.communication.core.response.Response;
import me.border.utilities.communication.base.Connection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CommunicationLogger {

    private final StringBuilder sb = new StringBuilder();

    private final File zippedLogFile;

    public CommunicationLogger(File path){
        String now = LocalDateTime.now().toString().replaceAll(":", ".");
        this.zippedLogFile = new File(path, now+".log.zip");
    }

    public void logReceived(Request request, Connection connection, Level level){
        String log = format("Request of type " + request.getType() + " received from " + connection.getSocket().toString() + " with", level);
        if (request.hasMessage()){
            log = log + " the message " + request.getMessage();
            System.out.println(log);
        } else {
            log = log + "out a message";
        }

        sb.append(log).append("\n");
    }

    public void logReceived(Response response, Connection connection, Level level){
        String log = format("Response of type " + response.getType() + " received from " + connection.getSocket().toString() + " with", level);
        if (response.hasMessage()){
            log = log + " the message " + response.getMessage();
            System.out.println(log);
        } else {
            log = log + "out a message";
        }

        sb.append(log).append("\n");
    }

    public void logReceived(Request request, Connection connection) {
        logReceived(request, connection, Level.INFO);
    }

    public void logReceived(Response response, Connection connection) {
        logReceived(response, connection, Level.INFO);
    }

    public void logSend(Request request, Connection connection, Level level) {
        String log = format("Request of type " + request.getType() + " sent at " + connection.getSocket().toString() + " with", level);
        if (request.hasMessage()){
            log = log + " the message " + request.getMessage();
            System.out.println(log);
        } else {
            log = log + "out a message";
        }

        sb.append(log).append("\n");
    }

    public void logSend(Response response, Connection connection, Level level) {
        String log = format("Response of type " + response.getType() + " sent at " + connection.getSocket().toString() + " with", level);
        if (response.hasMessage()){
            log = log + " the message " + response.getMessage();
            System.out.println(log);
        } else {
            log = log + "out a message";
        }

        sb.append(log).append("\n");;
    }

    public void logSend(Request request, Connection connection) {
        logSend(request, connection, Level.INFO);
    }

    public void logSend(Response response, Connection connection) {
        logSend(response, connection, Level.INFO);
    }

    public void save() throws IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zippedLogFile));
        ZipEntry e = new ZipEntry(zippedLogFile.getName().replace(".zip", ""));

        zos.putNextEntry(e);
        zos.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        zos.flush();

        zos.closeEntry();
        zos.close();
    }

    private String format(String log, Level level){
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.getMonthValue() + "/" + now.getDayOfMonth() + " " + now.getHour() + ":" + now.getMinute() + ":" +  now.getSecond();
        return "[" + currentTime + "]" + " [" + Thread.currentThread().getName() + "/" + level + "]: " + log;
    }

    public enum Level {
        INFO;
    }
}
