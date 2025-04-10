package com.vaibhav.joblisting.Repository;

import com.vaibhav.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
