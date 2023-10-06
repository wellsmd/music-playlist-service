package com.amazon.ata.music.playlist.service.converters;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.models.SongModel;

import java.util.ArrayList;

public class ModelConverter {
    /**
     * Converts a provided {@link Playlist} into a {@link PlaylistModel} representation.
     * @param playlist the playlist to convert
     * @return the converted playlist
     */
    public PlaylistModel toPlaylistModel(Playlist playlist) {
        return PlaylistModel.builder()
            .withId(playlist.getId())
            .withName(playlist.getName())
            .withCustomerId(playlist.getCustomerId())
            .withSongCount(playlist.getSongCount())
            .withTags(new ArrayList<>(playlist.getTags()))
            .build();
    }

    /**
     *
     * @param albumTrack the album track to convert
     * @return the converted song
     */
    public SongModel toSongModel(AlbumTrack albumTrack) {
        return SongModel.builder()
                .withAsin(albumTrack.getAsin())
                .withTrackNumber(albumTrack.getTrackNumber())
                .withAlbum(albumTrack.getAlbumName())
                .withTitle(albumTrack.getSongTitle())
                .build();
    }

}
