package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.converters.ModelConverter;
import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.exceptions.InvalidAttributeChangeException;
import com.amazon.ata.music.playlist.service.exceptions.InvalidAttributeValueException;
import com.amazon.ata.music.playlist.service.exceptions.PlaylistNotFoundException;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.models.requests.UpdatePlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.CreatePlaylistResult;
import com.amazon.ata.music.playlist.service.models.results.UpdatePlaylistResult;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;

import com.amazon.ata.music.playlist.service.util.MusicPlaylistServiceUtils;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementation of the UpdatePlaylistActivity for the MusicPlaylistService's UpdatePlaylist API.
 *
 * This API allows the customer to update their saved playlist's information.
 */
public class UpdatePlaylistActivity implements RequestHandler<UpdatePlaylistRequest, UpdatePlaylistResult> {
    private final Logger log = LogManager.getLogger();
    private final PlaylistDao playlistDao;

    /**
     * Instantiates a new UpdatePlaylistActivity object.
     *
     * @param playlistDao PlaylistDao to access the playlist table.
     */
    public UpdatePlaylistActivity(PlaylistDao playlistDao) {
        this.playlistDao = playlistDao;
    }

    /**
     * This method handles the incoming request by retrieving the playlist, updating it, and persisting the playlist.
     * <p>
     * It then returns the updated playlist.
     * <p>
     * If the playlist does not exist, this should throw a PlaylistNotFoundException.
     * <p>
     * If the provided playlist name or customer ID has invalid characters, throws an InvalidAttributeValueException.
     * <p>
     * If the request tries to update the customer ID, this should throw an InvalidAttributeChangeException.
     *
     * @param updatePlaylistRequest request object containing the playlist ID, playlist name, and associated customer ID.
     * @return updatePlaylistResult result object containing the API defined {@link PlaylistModel}.
     */
    @Override
    public UpdatePlaylistResult handleRequest (final UpdatePlaylistRequest updatePlaylistRequest, Context context) {
        log.info("Received UpdatePlaylistRequest {}", updatePlaylistRequest);

        String playlistName = updatePlaylistRequest.getName();

        if (updatePlaylistRequest == null) {
            throw new PlaylistNotFoundException("Playlist not found.");
        }

        try {
            MusicPlaylistServiceUtils.isValidString(updatePlaylistRequest.getName());
        } catch (InvalidAttributeValueException e) {
            System.out.println(updatePlaylistRequest.getName() + "is in the wrong format.");
            return null;
        }

        try {
            MusicPlaylistServiceUtils.isValidString(updatePlaylistRequest.getCustomerId());
        } catch (InvalidAttributeValueException e) {
            System.out.println(updatePlaylistRequest.getCustomerId() + "is in the wrong format.");
            return null;
        }



        return UpdatePlaylistResult.builder()
                .withPlaylist(new PlaylistModel())
                .build();
    }

    // Retrieve the playlist.
    // Update the playlist. (Check for attempted update to customerId.)
    // Save playlist to DB.
    // Return the updated playlist.

}
