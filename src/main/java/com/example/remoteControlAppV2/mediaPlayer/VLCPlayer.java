package com.example.remoteControlAppV2.mediaPlayer;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class VLCPlayer implements MediaPlayer {
    @Override
    public void play() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=pl_play";
        sendCommand(command);
    }

    private void sendCommand(String command) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("", "react".toCharArray());
                    }
                })
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(command))
                .timeout(Duration.ofMinutes(1))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }

    @Override
    public void pause() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=pl_pause";
        sendCommand(command);
    }

    @Override
    public void increaseVolume() throws IOException, InterruptedException {
        //Volume +4 approximately
        String command = "http://127.0.0.1:8080/requests/status.xml?command=volume&val=%2B20";
        sendCommand(command);
    }

    @Override
    public void decreaseVolume() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=volume&val=-20";
        sendCommand(command);
    }

    @Override
    public void increaseSubtitle() {

    }

    @Override
    public void decreaseSubtitle() {

    }

    @Override
    public void playNext() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=pl_next";
        sendCommand(command);
    }

    @Override
    public void playPrev() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=pl_previous";
        sendCommand(command);
    }

    @Override
    public void setFullscreen() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=fullscreen";
        sendCommand(command);
    }

    @Override
    public void exitFullscreen() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=fullscreen";
        sendCommand(command);
    }

    @Override
    public void playOrPause() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=pl_pause";
        sendCommand(command);
    }

    @Override
    public void mute() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=volume&val=0";
        sendCommand(command);
    }

    @Override
    public void forward() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=seek&val=%2B10";
        sendCommand(command);
    }

    @Override
    public void rewind() throws IOException, InterruptedException {
        String command = "http://127.0.0.1:8080/requests/status.xml?command=seek&val=-10";
        sendCommand(command);
    }

    @Override
    public void changeSubtitle() {

    }

    @Override
    public void changeAudio() {

    }
}
