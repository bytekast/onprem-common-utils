
[![Build Status](https://travis-ci.org/bytekast/onprem-common-utils.svg)](https://travis-ci.org/bytekast/onprem-common-utils)

[![Coverage Status](https://coveralls.io/repos/bytekast/onprem-common-utils/badge.svg?branch=feature-num2string&service=github)](https://coveralls.io/github/bytekast/onprem-common-utils?branch=feature-num2string)


Number to String
================

Using your language of choice, produce a library that has the following capability within it:

**given some integer (N) as an argument, return a string representation of that integer.**

For example, using the capability in a scala REPL (implemented as a function called _int2str_) may look like this:
```
scala> int2str(5)
res0: String = five

scala> int2str(55)
res1: String = fifty-five
```


As a part of the submission, treat the library as though it were an API (which may have new capabilities in the future) that will be used within an organization for production use.  Given that, it should include an appropriate level of professional cleanliness that you would stand behind for a published library.

As far as the workflow for submission:

1. Create a branch, using a branch name you feel is appropriate.
2. Once you're satisfied with your solution, create a pull request against _master_