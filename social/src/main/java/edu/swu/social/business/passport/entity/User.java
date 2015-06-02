package edu.swu.social.business.passport.entity;

import edu.swu.social.common.BaseEntity;

/**
 * Created by neusoft on 15-6-1.
 */
public class User extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
