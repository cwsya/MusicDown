package org.cwsya.hifiadmin.pojo.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


/**
 * 
 * 
 * @author cws
 */
@TableName("m_data")
public class MDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 歌曲名称
	 */
	private String name;
	/**
	 * 歌曲地址
	 */
	private String url;
	/**
	 * 来源
	 */
	private String source;
	/**
	 * 是否可用
	 */
	private Integer usable;
	/**
	 * 数据
	 */
	private String data;

	@Override
	public String toString() {
		return "MDataEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", url='" + url + '\'' +
				", source='" + source + '\'' +
				", usable=" + usable +
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getUsable() {
		return usable;
	}

	public void setUsable(Integer usable) {
		this.usable = usable;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public MDataEntity() {

	}

	public MDataEntity(Integer id, String name, String url, String source, Integer usable, String data) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.source = source;
		this.usable = usable;
		this.data = data;
	}
}
