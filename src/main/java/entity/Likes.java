package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Likes extends BaseEntity {
    private int postId;
    private int userId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
