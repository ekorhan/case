package entity.dto;

import entity.User;

public class UserDto {
    private long id;
    private String userName;
    private String fullName;
    private String profilePicture;
    private boolean followed;

    public UserDto(User user, boolean isFollow) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.fullName = user.getFullName();
        this.profilePicture = user.getProfilePicture();
        this.followed = isFollow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}
