package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazon.ata.music.playlist.service.helpers.AlbumTrackTestHelper;
import com.amazon.ata.music.playlist.service.helpers.PlaylistTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AlbumTrackDaoTest {
    @Mock
    private AlbumTrackDao albumTrackDao;

//    private GetPlaylistSongsActivity getPlaylistSongsActivity;

//    @BeforeEach
//    private void setup() {
//        initMocks(this);
//        getPlaylistSongsActivity = new GetPlaylistSongsActivity(playlistDao);
//    }

//    @Test
//    void handleRequest_albumTrackExists_returnsAlbumTrack() {
//        // GIVEN
//        Playlist playlist = PlaylistTestHelper.generatePlaylistWithNAlbumTracks(3);
//        String playlistId = playlist.getId();
//        GetPlaylistSongsRequest request = GetPlaylistSongsRequest.builder()
//                .withId(playlistId)
//                .build();
//        when(playlistDao.getPlaylist(playlistId)).thenReturn(playlist);
//
//        // WHEN
//        GetPlaylistSongsResult result = getPlaylistSongsActivity.handleRequest(request, null);
//
//        // THEN
//        AlbumTrackTestHelper.assertAlbumTracksEqualSongModels(playlist.getSongList(), result.getSongList());
//    }
}
