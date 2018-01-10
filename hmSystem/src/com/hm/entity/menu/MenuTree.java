package com.hm.entity.menu;

import java.util.List;

/**
 * Created by limiao on 2017-07-05.
 */
public class MenuTree {

    private String name;

    private String id;

    private List<MenuTree> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }
}
