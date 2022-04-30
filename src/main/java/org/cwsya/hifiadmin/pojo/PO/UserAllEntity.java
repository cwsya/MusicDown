package org.cwsya.hifiadmin.pojo.PO;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.List;


/**
 * @author cws
 * 用户名 角色以及权限
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class UserAllEntity implements Serializable {
    private Integer id;
    private String name;
    private List<String> role;
    private List<String> access;

    @Override
    public String toString() {
        return "UserAllEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", access=" + access +
                '}';
    }

    public UserAllEntity() {
    }

    public UserAllEntity(Integer id, String name, List<String> role, List<String> access) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.access = access;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public List<String> getAccess() {
        return access;
    }

    public void setAccess(List<String> access) {
        this.access = access;
    }
}
