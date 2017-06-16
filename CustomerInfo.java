import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CustomerInfo extends CustomerTest {
    private AtomicInteger uniqueID = new AtomicInteger(100000);
    private int customerID;
    private String customerName;
    private String gender;
    private String dob;
    private String tel;
    private String email;
    private String address;


    Scanner input = new Scanner(System.in); 

    public CustomerInfo() {
    
    }

    public CustomerInfo(int customerID, String customerName, String gender, String dob, String tel, String email, String address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.gender = gender;
        this.dob = dob;
        this.tel = tel;
        this.email = email;
        this.address = address;
    }
    
    public void setCustomerID() {
    	customerID = uniqueID.getAndIncrement();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerName() {
        System.out.println("Enter customer's FULL name:");
        customerName = input.nextLine();
        
        while (nameValidation(customerName) == false) {
            System.out.println("Invalid name. Please try again: ");
            customerName = input.nextLine();
        }

    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean nameValidation(String txt) {
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }

    public void setGender() {
        System.out.println("Enter customer's gender (Enter 1 for male; Enter 2 for female): ");
        String genderChoice = input.nextLine();

        switchLoop: while (!genderChoice.equals("1") || !genderChoice.equals("2")) {
            switch (genderChoice) {
                case "1":
                    gender = "Male";
                    break switchLoop;
                case "2":
                    gender = "Female";
                    break switchLoop;
                default:
                    System.out.println("Invalid input. Enter 1 for male; Enter 2 for female: ");
                    genderChoice = input.nextLine();
            }
        }

    }

    public String getGender() {
        return gender;
    }

    public void setDob() {
        System.out.println("Enter customer's date of birth (dd/MM/yyyy):");
        dob = input.nextLine();

        while (dobValidation(dob) == false) {
            System.out.println("Invalid input. Please try again (dd/MM/yyyy):");
            dob = input.nextLine();
        }

    }

    public String getDob() {
        return dob;
    }

    public boolean dobValidation(String dob) {
        String regex = "^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((1[6-9]|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$";
        Pattern a = Pattern.compile(regex);
        Matcher b = a.matcher(dob);
        return b.matches();
    }

    public void setPhoneNo() {
        System.out.println("Enter customer's phone number (Only Malaysian mobile phone is allowed, e.g 0123456789):");
        tel = input.nextLine();
        
        while (phoneNoValidation(tel) == false) {
            System.out.println("Invalid phone number. Please try again (Example: 0123456789): ");
            tel = input.nextLine();
        }

    }

    public String getPhoneNo() {
        return tel;
    }

    public boolean phoneNoValidation(String phoneNo) {
        if (phoneNo.matches("\\d{10}") && phoneNo.startsWith("0")) {
            return true;
        } else {
            return false;
        }
    }

    public void setEmail() {
        System.out.println("Enter customer's email address: ");
        email = input.nextLine();

        while (emailValidation(email) == false) {
            System.out.println("Invalid email. Please try again: ");
            email = input.nextLine();
        }

    }

    public String getEmail() {
        return email;
    }

    public boolean emailValidation(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public void setAddress() {
        System.out.println("Enter customer's mailing address (max 200 words): ");
        address = input.nextLine();
        
    }

    public String getAddress() {
        return address;
    }

    public String toCustomerInfoString() {
    	
    	return String.format("Customer ID: %d\nName: %s\nGender: %s\nDate of birth: %s\n"
				+ "Telephone: %s\nEmail: %s\nAddress: %s\n",getCustomerID(),
				getCustomerName(), getGender(), getDob(), 
				getPhoneNo(), getEmail(), getAddress());
    

}
}