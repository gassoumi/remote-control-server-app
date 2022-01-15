package com.example.remoteControlAppV2.model;

public class Command {

    public final static String VLC_MEDIA_PLAYER = "VLC_MEDIA_PLAYER";
    public final static String SMPLAYER_MEDIA_PLAYER = "SMPLAYER_MEDIA_PLAYER";
    public final static String PLAY = "PLAY";
    public final static String PAUSE = "PAUSE";
    public final static String INCREASE_VOLUME = "INCREASE_VOLUME";
    public final static String DECREASE_VOLUME = "DECREASE_VOLUME";
    public final static String INCREASE_SUBTITLE = "INCREASE_SUBTITLE";
    public final static String DECREASE_SUBTITLE = "DECREASE_SUBTITLE";
    public final static String PLAY_NEXT = "PLAY_NEXT";
    public final static String PLAY_PREV = "PLAY_PREV";
    public final static String SET_FULLSCREEN = "SET_FULLSCREEN";
    public final static String EXIT_FULLSCREEN = "EXIT_FULLSCREEN";
    public final static String PLAY_OR_PAUSE = "PLAY_OR_PAUSE";
    public final static String MUTE = "MUTE";
    public final static String FORWARD = "FORWARD";
    public final static String REWIND = "REWIND";
    public final static String CHANGE_SUBTITLE = "CHANGE_SUBTITLE";
    public final static String CHANGE_AUDIO = "CHANGE_AUDIO";

    // can be vlc or smplayer or any other media players
    private final String mediaPlayer;
    private final String command;

    public Command(String mediaPlayer, String command) {
        this.mediaPlayer = mediaPlayer;
        this.command = command;
    }

    public String getMediaPlayer() {
        return mediaPlayer;
    }

    public String getCommand() {
        return command;
    }
}
