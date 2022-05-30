package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Follow {
    @Id
    private int followerId;
    @Id
    private int followingId;
    private long createdAt;
}
