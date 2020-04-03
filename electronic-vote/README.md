# Electronic Voting System - Complex Coding Dojo
TDD, BDD, Clean Code, Clean Architecture Dojo Project

Development method:
Iterative and incremental software development. We follow Extreme Programming and some Scrum practice.

1. Phase:
  1. step: Identified the main workflows

    [Voting]
    | start | -> | authentication | -> | choice based on district | -> | voting | -> | end |

    [Check the vote actual result]
    | start | -> | select the area | -> | view the actual voting result | -> | end |

    [Notified the first 3 winner]
    | start | -> | when the voting is close | -> | notified the 3 winner about the result | -> | end |

    [Check the vote result]
    | start | -> | select the area | -> | view the voting result | -> | end |

  2. step: Set the release goal:
    We will develop the [Voting] and [Check the vote actual result] workflow mayor without county delegates and referendum flow only

  3. step: Start BDD
    With the customer we create the first few features with scenarios on system test level
    
  4. step: Create the domain dictionary (see end of the readme file)
  
  5. step: Based on the workflow and the collected examples we do a simplified user story mapping to find the MVP.
  
   Here is one example: 
    
    [Voting]
    | start | -> | authentication | -> | choice based on district | -> | voting | -> | end |
  
   MVP and USs for the [Voting] workflow:
   
    | authentication |:
    As a voting manager I would like to authenticate each user to know who is s/he because just the authenticated user should vote
    | choice based on district |:
    As a voting manager I would like to give the proper questions for the voter based on where s/he live because s/he can vote only her / his areas' questions
    As a government I would like to create questions for voting because the government need to know which direction should go 
    | voting |:
    As a voter I would like to vote so I can influence which direction the country goes
    
   Based on XP value we would like to get feedback to reach that we have to show a real case (which is valuable for the customer so it's end to end workflow) 
   
   INVEST: Here is the lesson learn for those who can't understand what is MVP and Negotiable -> working from customer point of view, but not releasable because it's not enough mature 
        
    | authentication |:
    User name is a text which is not empty and for each user the password is "vote"
    | choice based on district |:
    Create one question referendum so the area and multiple questions is irrelevant
    | voting |:
    Store the votes in a simple text file: username | vote format and 1 line 1 vote
  
  Domain dictionary:
  
    | Hun                    | Eng               | Note          |
    |------------------------|-------------------|---------------|
    | ország                 | country           ||
    | megye                  | county            ||
    | város                  | city              ||
    | település              | settlement        | town or city or village or district of the capital city |
    | kerület                | district          | small city has no district                                                       |
    | körzet                 | area              | if the district is big (several people live there) it is split to several areas  | 
    | kérdőív                | questionnaire     ||
    | kérdés                 | question          ||
    | szavazás               | voting            | when you finalize and send the vote                                              |
    | szavazat               | vote              | accepted vote                                                                    |
    | érvénytelen válasz     | invalid answer    | when somebody voting but none of the possibilities acceptable for you            |
    | félbehagyott szavazás  | unfinished voting | get the questionnaire but the voting does not happened                           |
    | azonosítás             | authentication    ||
    | eredmény               | result            ||
    | főpogármester          | lord mayor        | mayor for capital city |
    | polgármester           | mayor             | mayor for a town or a city or a district in the capital city |
    | körzeti képviselő      | delegate          | area responsible | 
