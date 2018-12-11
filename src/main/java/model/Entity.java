package model;

import java.io.Serializable;

public class Entity implements Serializable {
	private static final long serialVersionUID = 1L;
		private Long Id;

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}
		
	}

