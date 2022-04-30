package org.cwsya.hifiadmin.pojo.PO;

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
@TableName("role_access")
public class RoleAccessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 角色权限对应唯一标识
	 */
	@TableId
	private Integer id;
	/**
	 * 角色id
	 */
	private Integer rid;
	/**
	 * 权限id
	 */
	private Integer aid;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createdTime;

	@Override
	public String toString() {
		return "RoleAccessEntity{" +
				"id=" + id +
				", rid=" + rid +
				", aid=" + aid +
				", createdTime=" + createdTime +
				'}';
	}

	public RoleAccessEntity() {
	}

	public RoleAccessEntity(Integer id, Integer rid, Integer aid, Date createdTime) {
		this.id = id;
		this.rid = rid;
		this.aid = aid;
		this.createdTime = createdTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
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
}
