package com.example.remoteControlAppV2.controller;

import com.example.remoteControlAppV2.mediaPlayer.MediaPlayer;
import com.example.remoteControlAppV2.mediaPlayer.SMPlayer;
import com.example.remoteControlAppV2.mediaPlayer.VLCPlayer;
import com.example.remoteControlAppV2.model.Command;
import com.example.remoteControlAppV2.model.ErrorResponse;
import com.example.remoteControlAppV2.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

//https://www.baeldung.com/spring-request-response-body
//https://www.baeldung.com/spring-response-entity
//https://www.baeldung.com/spring-mvc-controller-custom-http-status-code
@RestController
public class RemoteController {
    @PostMapping("/command")
    public ResponseEntity greeting(@RequestBody Command command) {
        System.out.println(command);
        try {
            MediaPlayer mediaControl;
            String selectedMediaPlayer = command.getMediaPlayer();
            switch (selectedMediaPlayer) {
                case Command.SMPLAYER_MEDIA_PLAYER:
                    mediaControl = new SMPlayer();
                    makeAction(command, mediaControl);
                    return getOkResponseEntity();
                case Command.VLC_MEDIA_PLAYER:
                    mediaControl = new VLCPlayer();
                    makeAction(command, mediaControl);
                    return getOkResponseEntity();
                default:
                    return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            final ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setException(e.getClass().getSimpleName());
            errorResponse.setMessage(e.getMessage());
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    private ResponseEntity getOkResponseEntity() {
        final Response response = new Response();
        response.setMessage("Done");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    private void makeAction(Command command, MediaPlayer player) throws Exception {
        String action = command.getCommand();
        switch (action) {
            case Command.PLAY:
                player.play();
                break;
            case Command.PAUSE:
                player.pause();
                break;
            case Command.PLAY_OR_PAUSE:
                player.playOrPause();
                break;
            case Command.INCREASE_VOLUME:
                player.increaseVolume();
                break;
            case Command.DECREASE_VOLUME:
                player.decreaseVolume();
                break;
            case Command.INCREASE_SUBTITLE:
                player.increaseSubtitle();
                break;
            case Command.DECREASE_SUBTITLE:
                player.decreaseSubtitle();
                break;
            case Command.PLAY_NEXT:
                player.playNext();
                break;
            case Command.PLAY_PREV:
                player.playPrev();
                break;
            case Command.SET_FULLSCREEN:
                player.setFullscreen();
                break;
            case Command.EXIT_FULLSCREEN:
                player.exitFullscreen();
                break;
            case Command.MUTE:
                player.mute();
                break;
            case Command.FORWARD:
                player.forward();
                break;
            case Command.REWIND:
                player.rewind();
                break;
            case Command.CHANGE_SUBTITLE:
                player.changeSubtitle();
                break;
            case Command.CHANGE_AUDIO:
                player.changeAudio();
                break;
            default:
                System.out.println("Unknown command " + action);
        }
    }
}
