Feature: Tests for the application loggings behaviour

  Scenario: Log in Silent level
    When the log system set to Silent
    Then Log should be empty
    
  Scenario: Log in Error level
    Given the log system set to Error
    When an error occurred in the system
    Then the log contains only the Error information
    
  Scenario: Log in Info level
  	Given the log system set to Info
    When the business logic called
    Then Log system should contains the business logic name and time
    
  Scenario: Log in Info level and an error occurred
    Given the log system set to Info
    When the business logic called
    And an error occurred in the system
    Then Log system should contains the business logic name and time
    And the log contains only the Error information

  Scenario: Log in Debug level
  	Given the log system set to Debug
    When the business logic called
    Then Log system should contains the business logic name and time
    And log system should contain the parameters' values which the business logic called
    
  Scenario: Log in Anonym caller mode
  	Given the log system set to not Silent
  	And caller mode is Anonym
  	When the business logic called
  	Then the log system should not contain user and authorization information
    
  Scenario: Log in Personal caller mode
  	Given the log system set to not Silent
  	And caller mode is Personal
  	When the business logic called
  	Then the log system should contain user and authorization information
  	
  Scenario: Persistent issue occurred operation engineer is notified
    Given a fully working log system
  	When persistence problem occurred
  	Then operation engineer has notified
   
  Scenario: Continues logging when persistent problem occurred
  	Given a fully working log system
  	When persistence problem occurred
  	Then the log system continuously collects the logs
  
  Scenario: Try to store the unsaved logs in a limited working log system
  	Given a limited working log system
  	And we have log which is not stored in a persistent way
  	When a given time has come
  	Then the log system tries to store the logs in a persistent way
  	
  Scenario: Successful log system recovery from persistent issue
  	Given a limited working log system
  	And the persistent problem already solved
  	When a given time has come
  	Then the unsaved logs successfully saved in a persistent way
  	
  Scenario: Keep the logging when persistent issues still present
  	Given a limited working log system
  	And the persistent problem still present
  	When a given time has come
  	Then the unsaved logs are not saved in a persistent way
  	But it still available in unsaved logs
  	