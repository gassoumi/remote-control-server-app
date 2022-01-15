package com.example.remoteControlAppV2.mediaPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SMPlayer implements MediaPlayer {

    private final String SMPlayerPath = "C:\\Program Files\\SMPlayer\\smplayer.exe";
    private final String SEND_ACTION_CMD = "-send-action";

    @Override
    public void play() throws IOException, InterruptedException {
        String action = "play";
        sendAction(action);
    }


    @Override
    public void pause() throws IOException, InterruptedException {
        String action = "pause";
        sendAction(action);
    }

    @Override
    public void increaseVolume() throws IOException, InterruptedException {
        String action = "increase_volume";
        sendAction(action);
    }

    @Override
    public void decreaseVolume() throws IOException, InterruptedException {
        String action = "decrease_volume";
        sendAction(action);
    }

    @Override
    public void increaseSubtitle() throws IOException, InterruptedException {
        String action = "inc_sub_scale";
        sendAction(action);
    }

    @Override
    public void decreaseSubtitle() throws IOException, InterruptedException {
        String action = "dec_sub_scale";
        sendAction(action);
    }

    @Override
    public void playNext() throws IOException, InterruptedException {
        String action = "play_next";
        sendAction(action);
    }

    @Override
    public void playPrev() throws IOException, InterruptedException {
        String action = "play_prev";
        sendAction(action);
    }

    @Override
    public void setFullscreen() throws IOException, InterruptedException {
        String action = "fullscreen";
        sendAction(action);
    }

    @Override
    public void exitFullscreen() throws IOException, InterruptedException {
        String action = "exit_fullscreen";
        sendAction(action);
    }

    @Override
    public void playOrPause() throws IOException, InterruptedException {
        String action = "play_or_pause";
        sendAction(action);
    }

    @Override
    public void mute() throws IOException, InterruptedException {
        String action = "mute";
        sendAction(action);
    }

    @Override
    public void forward() throws IOException, InterruptedException {
        String action = "forward1";
        sendAction(action);
    }

    @Override
    public void rewind() throws IOException, InterruptedException {
        String action = "rewind1";
        sendAction(action);
    }

    @Override
    public void changeSubtitle() throws IOException, InterruptedException {
        String action = "next_subtitle";
        sendAction(action);
    }

    @Override
    public void changeAudio() throws IOException, InterruptedException {
        String action = "next_audio";
        sendAction(action);
    }

    private void sendAction(String action) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();

        // -- Linux --

        // Run a shell command
        // processBuilder.command("bash", "-c", "ls /home/mkyong/");

        // Run a shell script
        //processBuilder.command("path/to/hello.sh");

        // -- Windows --

        // Run a command
        //processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");

        // Run a bat file
        processBuilder.command(SMPlayerPath, SEND_ACTION_CMD, action);

        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        int exitVal = process.waitFor();
        if (exitVal == 0) {
            System.out.println("Success!");
            System.out.println(output);
        } else {
            System.out.println("Error!");
        }
    }
}
