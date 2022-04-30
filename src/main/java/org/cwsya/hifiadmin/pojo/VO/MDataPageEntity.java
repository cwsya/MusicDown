package org.cwsya.hifiadmin.pojo.VO;

import java.io.Serializable;


/**
 *
 *
 * @author cws
 */

public class MDataPageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 歌曲名称
	 */
	private String name;

	@Override
	public String toString() {
		return "MDataPageEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
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

	public MDataPageEntity() {
	}

	public MDataPageEntity(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
}
