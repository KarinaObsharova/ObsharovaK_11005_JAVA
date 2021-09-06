public class EmailValidatorRegexImpl implements EmailValidator{

    private String regex;

    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean isValid(String email) {
        return email.matches(regex);
    }
}
