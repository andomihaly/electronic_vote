package hu.am.userauthentication.exception;

public class NonExistentUserNameException extends UserAuthenticationException {
    public NonExistentUserNameException() {
        super(ErrorCode.NON_EXISTENT_USER_NAME);
    }
}
