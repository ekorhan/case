package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Post extends BaseEntity {
    private String description;
    private Long userId;
    private String image;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
