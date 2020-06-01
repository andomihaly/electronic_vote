package hu.am.userauthentication.exception;

public class InvalidEmailException extends UserAuthenticationException {
    public InvalidEmailException() {
        super(ErrorCode.INVALID_EMAIL);
    }
}
