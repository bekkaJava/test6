import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Scanner;

public class EmailGenerator {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String password;
    private String department;
    private String email;
    final static private int defaultPasswordSize = 8;
    static private final String emailSuffix = "@gmail.com";


    public EmailGenerator(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.department = department();
        System.out.println("Your department is " + this.department);
        this.password = randomPasswordGenerator();
        System.out.println("Your password is: " + this.password);
        this.email =   firstName.toLowerCase() + lastName.toLowerCase() +
                        (LocalDate.now().getYear() - birthDate.getYear())
                            + this.department + emailSuffix;
        System.out.println("Your email is: " + this.email);
    }

    public String department() {

        System.out.println("Hello " + this.firstName + " " + this.lastName + " Please Choose the department");
        System.out.println("1 for IT, 2 for Finance, 3 for Sales, 4 for Aml");
        Scanner input = new Scanner(System.in);

        int dep = input.nextInt();

        if (dep == 1) {
            return "IT";
        } else if (dep == 2) {
            return "Finance";

        } else if (dep == 3) {
            return "Sales";
        } else if (dep == 4) {
            return "Aml";

        } else return "";
    }

    public String randomPasswordGenerator() {
        int passwordSize = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the password size");

        passwordSize = input.nextInt();
        if (passwordSize < 8) {
            passwordSize = defaultPasswordSize;
        }


        String passwordGenerator = "abcdefghijklmNBSpqrstuvwxyzALOMBSGQIODAOPQRSTUVWXYZ" +
                                    "0123456789!@#$%^&*()_+-={}[]\\\\|;:'\\\"<>,.?/\"";
        SecureRandom rnd = new SecureRandom();
        char[] password = new char[passwordSize];
        for (int i = 0; i < passwordSize; i++) {
            password[i] = passwordGenerator.charAt(rnd.nextInt(passwordGenerator.length() - 1));
        }
        return new String(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return "Your are in " + department + " department";
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "Email{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}