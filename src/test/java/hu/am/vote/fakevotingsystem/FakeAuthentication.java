package hu.am.vote.fakevotingsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.am.vote.Authentication;

public class FakeAuthentication implements Authentication {
	private final Logger logger = LoggerFactory.getLogger(FakeAuthentication.class);
    @Override
    public void login(String name, String password) {
    	logger.info("Logged in: {}",name);
    }
}
