package com.ypp.service;

import com.ypp.payload.ApiResponse;
import com.ypp.payload.PagedResponse;
import com.ypp.payload.PhotoRequest;
import com.ypp.payload.PhotoResponse;
import com.ypp.security.UserPrincipal;

public interface PhotoService {

	
	PagedResponse<PhotoResponse> getAllPhotos(int page, int size);

	PhotoResponse getPhoto(Long id);

	PhotoResponse updatePhoto(Long id, PhotoRequest photoRequest, UserPrincipal currentUser);

	PhotoResponse addPhoto(PhotoRequest photoRequest, UserPrincipal currentUser);

	ApiResponse deletePhoto(Long id, UserPrincipal currentUser);

	PagedResponse<PhotoResponse> getAllPhotosByAlbum(Long albumId, int page, int size);

}