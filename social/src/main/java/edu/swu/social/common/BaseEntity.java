package edu.swu.social.common;

import java.io.Serializable;

/**
 * Created by neusoft on 15-6-1.
 */
public abstract class BaseEntity implements Serializable {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
