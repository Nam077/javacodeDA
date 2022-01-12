package Class;

public class User {
	
	private Integer id;
	private String name;
	private String email;
	private String pass;
	private String role;
	private String phone;
	private String address;
	private String cmnd;
	private String date;
	public User(Integer id, String name, String email, String pass, String role, String phone, String address,
			String cmnd, String date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.phone = phone;
		this.address = address;
		this.cmnd = cmnd;
		this.date = date;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
