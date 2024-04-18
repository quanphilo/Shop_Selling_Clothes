package DTO;

public class PermissionDTO {
	private String id_permission;
	private String name;

	public PermissionDTO(String id_permission, String name) {
		super();
		this.id_permission = id_permission;
		this.name = name;
	}

	

	public PermissionDTO(String id_permission) {
		this.id_permission = id_permission;
	}



	public PermissionDTO() {
		super();
	}

	public String getId_permission() {
		return id_permission;
	}

	public void setId_permission(String id_permission) {
		this.id_permission = id_permission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
