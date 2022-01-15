package com.example.remoteControlAppV2.mediaPlayer;

public interface MediaPlayer {

    void play() throws Exception;

    void pause() throws Exception;

    void increaseVolume() throws Exception;

    void decreaseVolume() throws Exception;

    void increaseSubtitle() throws Exception;

    void decreaseSubtitle() throws Exception;

    void playNext() throws Exception;

    void playPrev() throws Exception;

    void setFullscreen() throws Exception;

    void exitFullscreen() throws Exception;

    void playOrPause() throws Exception;

    void mute() throws Exception;

    void forward() throws Exception;

    void rewind() throws Exception;

    void changeSubtitle() throws Exception;

    void changeAudio() throws Exception;
}
