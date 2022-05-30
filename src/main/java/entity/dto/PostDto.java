package entity.dto;

import entity.Post;

public class PostDto {
    private long id;
    private String description;
    private UserDto owner;
    private String image;
    private long createdAt;
    private boolean liked;

    public PostDto() {
    }

    public PostDto(Post post, UserDto user, boolean isLike) {
        this.id = post.getId();
        this.description = post.getDescription();
        this.owner = user;
        this.image = post.getImage();
        this.createdAt = post.getCreatedAt();
        this.liked = isLike;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDto getOwner() {
        return owner;
    }

    public void setOwner(UserDto owner) {
        this.owner = owner;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
