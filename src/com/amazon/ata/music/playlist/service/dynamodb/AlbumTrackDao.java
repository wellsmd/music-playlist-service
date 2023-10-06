package com.amazon.ata.music.playlist.service.dynamodb;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.exceptions.AlbumTrackNotFoundException;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import javax.inject.Inject;

/**
 * Accesses data for an album using {@link AlbumTrack} to represent the model in DynamoDB.
 */
public class AlbumTrackDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates an AlbumTrackDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the album_track table
     */
    @Inject
    public AlbumTrackDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     *
     * @param asin ASIN
     * @param trackNumber Track number
     * @return The specified album track, or null if none is found
     */
    public AlbumTrack getAlbumTrack(String asin, Integer trackNumber) throws AlbumTrackNotFoundException {
        AlbumTrack albumTrack = this.dynamoDbMapper.load(AlbumTrack.class, asin);

        if (albumTrack == null) {
            throw new AlbumTrackNotFoundException("Could not find an album with ASIN " + asin);
        }

        return albumTrack;
    }

}
