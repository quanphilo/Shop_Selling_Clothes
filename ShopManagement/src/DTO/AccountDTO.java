package DTO;

public class AccountDTO {
	private String id_user;
	private String usename;
	private String password;
	private int status;

	public AccountDTO() {
		super();
	}	

	public AccountDTO(String id_user) {
		this.id_user = id_user;
	}

	public AccountDTO(String usename, String password) {
		this.usename = usename;
		this.password = password;
	}

	public AccountDTO(String id_user, String usename, String password) {
		super();
		this.id_user = id_user;
		this.usename = usename;
		this.password = password;
	}
	public AccountDTO(String id_user, String usename, String password, int status) {
		super();
		this.id_user = id_user;
		this.usename = usename;
		this.password = password;
		this.status = status;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "AccountDTO [id_user=" + id_user + ", usename=" + usename + ", password=" + password + ", status="
				+ status + "]";
	}
	
	
	
}
