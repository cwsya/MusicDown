package org.cwsya.hifiadmin.pojo.VO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author 陈文生
 */

public class RoleUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户角色关系id
	 */
	private Integer id;
	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 创建时间
	 */
	private Date createdTime;

	@Override
	public String toString() {
		return "UserRoleEntity{" +
				"id=" + id +
				", rid=" + uid +
				", createdTime=" + createdTime +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public RoleUserEntity() {
	}

	public RoleUserEntity(Integer id, Integer uid, Date createdTime) {

		this.id = id;
		this.uid = uid;
		this.createdTime = createdTime;
	}
}
