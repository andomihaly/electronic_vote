# Electronic Voting System - Complex Coding Dojo
TDD, BDD, Clean Code, Clean Architecture Dojo Project

Development method:
Iterative and incremental software development. We follow Extreme Programming and some Scrum practice.

1. Phase:
  1. step: Identified the main workflows

    [Voting]
    | start | -> | authentication | -> | choice based on district | -> | voting | -> | end |

    [Check the vote result]
    | start | -> | select the area | -> | view the actual voting result | -> | end |

    [Notified the first 3 winner]
    | start | -> | when the voting is close | -> | notified the 3 winner about the result | -> | end |

  2. step: Set the release goal:
    We will develop the [Voting] and [Check the vote result] workflow

  3. step: Start BDD
    With the customer we create the first few features with scenarios on system test level
  4. step: Craete the domain disctionary
  
    | Hun                    | Eng               | Desription                                                                       |
    | ország                 | country           |
    | megye                  | county            |
    | város                  | city              |
    | kerület                | district          | small city has no district                                                       |
    | körzet                 | area              | if the disctrict is big (several people live there) it is split to several areas | 
    | kérdőív                | questionnaire     |
    | kérdés                 | question          |
    | szavazás               | voting            | when you finalize and send the vote                                              |
    | szavazat               | vote              | accepted vote                                                                    |
    | érvénytelen szavazat   | invalid vote      | when somebody voting but non of the possibilities acceptable for you             |
    | félbehagyott szavazás  | unfinished voting | get the questionnare but the voting does not happend                             |
    | azonosítás             | authetication     |
    | eredmény               | result            |
