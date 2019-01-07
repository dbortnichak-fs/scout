package com.djb.scout.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FollowerPK implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id")
    private User follower;

    public FollowerPK(User user, User follower) {
        this.user = user;
        this.follower = follower;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FollowerPK)) return false;
        FollowerPK that = (FollowerPK) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(follower, that.follower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, follower);
    }
}
