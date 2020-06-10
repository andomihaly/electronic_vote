package hu.am.userauthentication.exception;

public class ReservedUserNameException extends UserAuthenticationException {
    public ReservedUserNameException() {
        super(ErrorCode.RESERVED_USER_NAME);
    }
}
