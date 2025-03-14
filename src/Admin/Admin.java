package admin;

public class Admin {
    private String firstName, lastName, mobile, gender, email, password;
    private int failedCount = 0;
    private boolean isLocked = false;

    public Admin(String firstName, String lastName, String mobile, String gender, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getFailedCount() { return failedCount; }
    public boolean isLocked() { return isLocked; }

    public void incrementFailedCount() { failedCount++; }
    public void lockAccount() { isLocked = true; }
}
