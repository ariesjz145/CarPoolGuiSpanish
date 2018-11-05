package newuser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator {

  private Pattern pattern;
  private Matcher matcher;

  /**
   * must have @ symbol.
   * */
  private static final String EMAIL_FORMAT= "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
      + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"
      + "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\"
      + "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])"
      + "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\"
      + "[(?:(?:25[0-5]|2[0-4][0-9]|"
      + "[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:"
      + "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\"
      + "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

  public EmailValidator(){

    pattern = Pattern.compile(EMAIL_FORMAT);
  }

  /**
   * Validates the the input of the user.
   * @param email user email.
   * @return true if user input == correct format.
   */
  @Override
  public boolean Validate(String email) {

    matcher = pattern.matcher(email);
    return matcher.matches();
  }
}
