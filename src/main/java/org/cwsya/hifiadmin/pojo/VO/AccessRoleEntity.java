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
public class AccessRoleEntity implements Serializable {
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
	 * 创建时间
	 */

	private Date createdTime;

	@Override
	public String toString() {
		return "AccessRoleEntity{" +
				"id=" + id +
				", rid=" + rid +
				", createdTime=" + createdTime +
				'}';
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public AccessRoleEntity() {
	}

	public AccessRoleEntity(Integer id, Integer rid, Date createdTime) {
		this.id = id;
		this.rid = rid;
		this.createdTime = createdTime;
	}
}
