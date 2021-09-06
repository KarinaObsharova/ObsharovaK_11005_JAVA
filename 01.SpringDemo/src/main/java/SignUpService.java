
public class SignUpService {
    private PasswordBlackList passwordBlackList;
    private EmailValidator emailValidator;

    public SignUpService(PasswordBlackList passwordBlackList, EmailValidator emailValidator) {
        this.passwordBlackList = passwordBlackList;
        this.emailValidator = emailValidator;
    }

    public void singUp(String email, String password){
        if(passwordBlackList.contains(password)) {
            System.err.println("Пароль не подходит");
        } else
            System.out.println("Пароль хороший");

        if(emailValidator.isValid(email)) {
            System.out.println("Email хороший");
        } else
            System.err.println("Email не подходит");
    }
}
