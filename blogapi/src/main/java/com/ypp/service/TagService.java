package com.ypp.service;

import com.ypp.model.Tag;
import com.ypp.payload.ApiResponse;
import com.ypp.payload.PagedResponse;
import com.ypp.security.UserPrincipal;

public interface TagService {

	PagedResponse<Tag> getAllTags(int page, int size);

	Tag getTag(Long id);

	Tag addTag(Tag tag, UserPrincipal currentUser);

	Tag updateTag(Long id, Tag newTag, UserPrincipal currentUser);

	ApiResponse deleteTag(Long id, UserPrincipal currentUser);

}
