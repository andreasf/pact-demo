Pact example project
====================

This is an example project demonstrating how to test-drive a new endpoint on a
Spring Boot provider, starting from the consumer side.


How to use this repository
--------------------------

Like a real project, commits in this repository incrementally add tests and
implementation.  Use a tool of your choice to view the diffs between each
commit.

Some of the commits have failing tests to highlight intermediate steps and to
show how failing tests inform us about the next steps.


About the provider test
-----------------------

The provider test is implemented as an integration test, running the whole
application in the `pact` Spring profile. In a real app, this profile should
stub out external dependencies to prevent side effects and to make the test
predictable and robust.

Running contract tests as integration tests is definitely controversial. In my
experience, I have seen more up- than downsides to this approach: it's usually
not more complicated to set up preconditions in the database vs. setting up
mocks. The tests are also not brittle if the application is designed to be
testable and if its output is reproducible (e.g. list item order needs to be
stable). On the plus side, this approach allows having an integration-like test
for every response case of each endpoint. And who would say no to free
integration tests?
