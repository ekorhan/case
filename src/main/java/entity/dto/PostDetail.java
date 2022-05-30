package entity.dto;

import entity.Post;
import entity.User;

import java.io.Serializable;

public class PostDetail implements Serializable {
    private UserDto user;
    private PostDto post;

    public PostDetail(UserDto user, PostDto post) {
        this.user = user;
        this.post = post;
    }

    public PostDetail(Post post, User user, boolean isLike, boolean isFollow) {
        this.user = new UserDto(user, isFollow);
        this.post = new PostDto(post, this.user, isLike);
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto post) {
        this.post = post;
    }
}
