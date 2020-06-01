package hu.am.userauthentication.exception;

public abstract class UserAuthenticationException extends RuntimeException {
    public ErrorCode errorCode;

    public UserAuthenticationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
