# Shouty Test

This project tests an existing application with Cucumber.

This is a way to learn how to use Cucumber as a testing tool,
using Selenium WebDriver and SOAP.

This project does *not* teach you how to do BDD, which is
a process where the tests are written *before* the application,
and the application is written under guidance by tests.

Instead, you will learn how to use Cucumber as a testing tool.

## Exercise 1 - Manual Testing

We'll start by exploring the application, which has a
*very* rudimentary user interface.

Open two browsers and go to the following URLs:

* http://shouty.cucumber.io/people/Sean
* http://shouty.cucumber.io/people/Lucy

Manually try to follow the steps in `hear_shout.feature`

Answer the following questions:

* Does the system work as intended?
* Did anything surprise you?

## Exercise 2 - Run Cucumber

Open up a shell (command prompt) and type the following command:

    mvn test

Answer the following questions:

* What information do you get when you do that?
* How do you think The `mvn` tool runs Cucumber? (Hint: Look at `RunCukesTest.java`)
* Examine the files under `src/test/java`. What's the purpose of each class?
* Draw a class diagram of the 5 classes in there.
* Why do you think the class structure is the way it is?

## Exercise 3 - Implement Step Definitions

When you ran Cucumber, it printed some snippets. Paste them into `ShoutSteps.java`,
but don't write anything in the method body (leave it as-is).
Run Cucumber again. How is the result different now?

Now, implement the `Given` step definition by invoking methods on the `shoutyApi`
object. Run Cucumber again. Do you get a new result this time?

## Exercise 4 - Implement the driver

Our step definitions are delegating to the `shoutyApi`, which is an instance
of `SoapShouty`. As you can see, this class has unfinished methods. We're
going to delegate to a SOAP client.

First off, generate the SOAP client:

    # Take a look inside that file - there may be some hints
    ./wsdl2java

Now that we have a SOAP client, delegate to it in every method in `SoapShouty`.

Run Cucumber again. What happens now?

## Exercise 5 - Start with a blank slate

Some of the scenarios are failing. Why? Could this be related to the surprise
you had in Exercise 1?

Try adding the following code to the `@Before` method in `ShoutSteps`:

```java
// http://unirest.io/java.html
Unirest.post("http://shouty.cucumber.io/reset").asString();
```
Answer the following questions:
* What do you think this code does?
* What do you think about this approach?
* Are your scenarios passing yet?

## Exercise 6 - Automate with Selenium

We've gained some confidence that our server is working correctly,
but our scenarios don't verify that the UI is working.

Run the scenarios again, but tell Cucumber to use Selenium rather than SOAP:

    mvn test -Dautomation=selenium

What happens now? Why?

Implement all the step definitions using the WebDriver API. Don't give up
until all scenarios are passing.

* What tools and techniques did you use to figure out what code to write?
* How does the selenium test stack up against the SOAP one? Pros and cons.

## Exercise 7 - New requirement

The team who wrote Shouty have misunderstood a requirement. Users are
reporting that they don't hear already shouted messages when they get
close to the person who shouted them.

Write a scenario to reproduce this bug.

* Should this scenario pass or fail?

## Exercise 8 - Bugfix!

The development team say they have fixed the bug. Can you trust them?

## Exercise 9 - Tiny upgrade

The developers have upgraded the UI framework to a new version.
Manual testing suggests everything still works as before.

Is everything still good?

## Exercise 10 - Comparison

You've run the same scenarios through both SOAP and Selenium WebDriver

What are the pros and cons of each approach?

* Development cost
* Maintainance cost
* Execution time
* Confidence
* Diagnostic precision

Can you think of a 3rd way this could have been automated that would be
better in all aspects?