import java.util.Scanner;
public class CustomerTest {
    
    public static void main(String[] args) {
        CustomerInfo testing = new CustomerInfo();
        CustomerInfo[] customerInfoDtb = new CustomerInfo[3];
        
        Scanner input = new Scanner(System.in);
        
        
        for (int i = 0; i < customerInfoDtb.length; i++) {
            System.out.println("NEW ACCOUNT REGISTRATION");
            System.out.println("Enter 1 = Create a new account \nEnter 2 = Reveal created new account(s)(If no new accounts are created yet '2' is entered, it will lead to new account creation section.)\nEnter 3 = Exit the program ");
            String exit = input.nextLine();
            
            
            switchLoop: while (!exit.equals("1") || !exit.equals("2")) {
                switch (exit) {
                    case "1":
                    break switchLoop;
                    case "2":
                    	for ( int j = 0; j < customerInfoDtb.length; j++) {
                    		for (CustomerInfo c: customerInfoDtb) {
                    	
                        if (null != c) {
                        	System.out.println("CustomerID: " + c.getCustomerID());
                            System.out.println("Name: " + c.getCustomerName());
                            System.out.println("Gender: " + c.getGender());
                            System.out.println("Date of birth: " + c.getDob());
                            System.out.println("Phone Number: " + c.getPhoneNo());
                            System.out.println("Email address: " + c.getEmail());
                            System.out.println("Mailing address: " + c.getAddress() + "\n");
                        } else {
                        	
                            break switchLoop;
                             
                        }
                    	}
                    
                        
                    }
                    	System.out.println("Enter 1 = Create a new account \nEnter 2 = Reveal created new account(s)\nEnter 3 = Exit the program ");
                        exit = input.nextLine();
                    case "3":
                    System.exit(0);
                    break switchLoop;
                    default:
                    System.out.println("Invalid input. Try again. Enter 1 to continue; Enter 2 to exit: ");
                    exit = input.nextLine();
                    
                    
                }
            }
            
            testing.setCustomerID();
            testing.setCustomerName();
            testing.setGender();
            testing.setDob();
            testing.setPhoneNo();
            testing.setEmail();
            testing.setAddress();
            
            customerInfoDtb[i] = new CustomerInfo(testing.getCustomerID(), testing.getCustomerName(), testing.getGender(), testing.getDob(), testing.getPhoneNo(), testing.getEmail(), testing.getAddress());
        }
        
    }
}

