package com.vaibhav.joblisting.Repository;

import com.vaibhav.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
}
