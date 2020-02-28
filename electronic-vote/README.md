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
  4. step: Create the domain dictionary
  
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
    | érvénytelen szavazat   | invalid vote      | when somebody voting but none of the possibilities acceptable for you            |
    | félbehagyott szavazás  | unfinished voting | get the questionnaire but the voting does not happened                           |
    | azonosítás             | authentication    ||
    | eredmény               | result            ||
    | főpogármester          | lord mayor        | mayor for capital city |
    | polgármester           | mayor             | mayor for a town or a city or a district in the capital city |
    | körzeti képviselő      | delegate          | area responsible | 