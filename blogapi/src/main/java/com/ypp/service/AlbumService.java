package com.ypp.service;

import com.ypp.model.Album;
import com.ypp.payload.AlbumResponse;
import com.ypp.payload.ApiResponse;
import com.ypp.payload.PagedResponse;
import com.ypp.payload.request.AlbumRequest;
import com.ypp.security.UserPrincipal;

import org.springframework.http.ResponseEntity;

public interface AlbumService {

	PagedResponse<AlbumResponse> getAllAlbums(int page, int size);

	ResponseEntity<Album> addAlbum(AlbumRequest albumRequest, UserPrincipal currentUser);

	ResponseEntity<Album> getAlbum(Long id);

	ResponseEntity<AlbumResponse> updateAlbum(Long id, AlbumRequest newAlbum, UserPrincipal currentUser);

	ResponseEntity<ApiResponse> deleteAlbum(Long id, UserPrincipal currentUser);

	PagedResponse<Album> getUserAlbums(String username, int page, int size);

}
