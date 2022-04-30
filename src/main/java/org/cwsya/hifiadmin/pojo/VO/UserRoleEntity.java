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
@TableName("user_role")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户角色关系id
	 */
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
		return "UserRoleEntity{" +
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

	public UserRoleEntity() {
	}

	public UserRoleEntity(Integer id, Integer rid, Date createdTime) {

		this.id = id;
		this.rid = rid;
		this.createdTime = createdTime;
	}
}
