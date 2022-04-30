package org.cwsya.hifiadmin.pojo.VO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author 陈文生
 */

public class RoleAccessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 角色权限对应唯一标识
	 */

	private Integer id;
	/**
	 * 权限id
	 */
	private Integer aid;

	private Date createdTime;

	@Override
	public String toString() {
		return "RoleAccessEntity{" +
				"id=" + id +
				", aid=" + aid +
				", createdTime=" + createdTime +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public RoleAccessEntity() {
	}

	public RoleAccessEntity(Integer id, Integer aid, Date createdTime) {
		this.id = id;
		this.aid = aid;
		this.createdTime = createdTime;
	}
}
