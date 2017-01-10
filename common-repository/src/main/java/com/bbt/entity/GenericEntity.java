package com.bbt.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericEntity {

	public GenericEntity() {
	}

	@Column(name = "created_date")
	private Date createDate;

	@Column(name = "updated_date")
	private Date updateDate;

	@Column(name = "active")
	private boolean active = true;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
