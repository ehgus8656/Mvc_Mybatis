package spring;

public class AuthInfo {
	private Long id;
	private String email;
	private String name;
	private String password;
	public AuthInfo(Long id, String email, String name, String password) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
}
