package org.mcginn.arch.comply.products;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Product implements Serializable {

	private static final long serialVersionUID = 3013872124943053913L;
	
	@Id
	private String id;
	private String name;
	private String description;
	private boolean active;
	private Date createdTimestamp;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description="
				+ description + ", active=" + active + ", createdTimestamp="
				+ createdTimestamp + "]";
	}
	public static class Builder {
		
		private String id;
		private String name;
		private String description;
		private boolean active = true;
		private Date createdTimestamp = new Date();
		
		public Product build() {
			Product p = new Product();
			p.setId(id);
			p.setName(name);
			p.setDescription(description);
			p.setActive(active);
			p.setCreatedTimestamp(createdTimestamp);
			return p;
		}
		
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		public Builder active(boolean active) {
			this.active = active;
			return this;
		}
		public Builder createdTimestamp(Date createdTimestamp) {
			this.createdTimestamp = createdTimestamp;
			return this;
		}
	}
}
