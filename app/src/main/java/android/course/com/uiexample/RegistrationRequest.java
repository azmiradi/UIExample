package android.course.com.uiexample;

public class RegistrationRequest extends LoginRequest {
    private final String name;
    private final String address;
    private final String phone;
    private final boolean visibilityAddress;
    private final Gender gender;

    public RegistrationRequest(String email, String password, String name, String address, String phone, boolean visbilityAddress, Gender gender) {
        super(email, password);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.visibilityAddress = visbilityAddress;
        this.gender = gender;
    }

    public boolean isVisibilityAddress() {
        return visibilityAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public void printInformation() {
        System.out.println("RegistrationRequest{" +
                "gender='" + gender + '\'' +
                ", is Visibility Address='" + visibilityAddress + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}');
    }


}
