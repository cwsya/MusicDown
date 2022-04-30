package org.cwsya.hifiadmin.pojo.VO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cws
 * 实体类
 */

public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */

	private Integer id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户状态
	 */
	private Integer status;

	/**
	 * 更新时间
	 */

	private Date updatedTime;
	/**
	 * 创建时间
	 */

	private Date createdTime;

	@Override
	public String toString() {
		return "UserEntity{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", status=" + status +
				", updatedTime=" + updatedTime +
				", createdTime=" + createdTime +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public UserEntity() {
	}

	public UserEntity(Integer id, String userName, Integer status, Date updatedTime, Date createdTime) {
		this.id = id;
		this.userName = userName;
		this.status = status;
		this.updatedTime = updatedTime;
		this.createdTime = createdTime;
	}
}
