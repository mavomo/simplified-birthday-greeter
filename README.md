# Dependency Inversion Principle (Quick) Kata

## DIP Basics

- DIP = D of SOLI**D**
- The DIP states that:
  > **A.** High level module should not depend upon low-level modules. Both should depend on abstractions. <br>
  > **B.** Abstractions should not depend on details. Details should depend on abstractions.

## Guidance

1. We would like to stop sending emails and send SMS instead

    The content of the SMS should be : 
    >'Happy birthday, my dear x ! ';

2. We would like to structure the classes in packages so that the "high level module" (business) still compiles while the "low level module" is moved elsewhere
or deleted.

## If you are done 
We assume that the email feature loads the friends to greet from a csv file like below: 
````
| last_name |  first_name |  date_of_birth |  email               | 
|-----------|-------------|----------------|----------------------| 
| Doe       |  John       |  1982/10/08    |  john.doe@foobar.com | 
| Ann       |  Mary       |  1975/09/11    |  mary.ann@foobar.com | 

````

3. We would like the SMS feature to load its contacts from a flat file, represented as:

  ```json
  [
    {
      " first_name": " John",
      " email": " john.doe@foobar.com",
      " date_of_birth": " 1982/10/08",
      "last_name": "Doe"
    },
    {
      " first_name": " Mary",
      " email": " mary.ann@foobar.com",
      " date_of_birth": " 1975/09/11",
      "last_name": "Ann"
    }
  ]
  ```
 
  Separate the *Business logic* from the *implementation detail* for the load feature. 
  
  ## Credit: 
- http://matteo.vaccari.name/blog/archives/154
- https://github.com/ivanbadia/solid-kata