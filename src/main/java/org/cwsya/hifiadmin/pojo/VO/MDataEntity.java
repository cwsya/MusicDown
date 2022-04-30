package org.cwsya.hifiadmin.pojo.VO;

import java.io.Serializable;


/**
 *
 *
 * @author cws
 */

public class MDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 歌曲名称
	 */
	private String name;

	private String data;

	@Override
	public String toString() {
		return "MDataEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", data='" + data + '\'' +
				'}';
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public MDataEntity() {
	}

	public MDataEntity(Integer id, String name, String data) {
		this.id = id;
		this.name = name;
		this.data = data;
	}
}
