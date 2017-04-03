Enterprise easyb
================

About Enterprise easyb
-----------------
Enterprise easyb is an attempt to revitalize the easyb project.

The initial goals are to:

- Update the website and documentation
- Modernize the tools for better Maven and IDE integration
- Add additional features and plugins to make simplify use in an enterprise environment

Initial Changes
-------------
- Old website now hosted at https://www.easyb.io/
- Version updated to 2.0-SNAPSHOT
- The org.easyb packages have been refactored to io.easyb
- All plugins and dependencies have been updated to the latest (as of 4/1/2017) versions

easyb-core
----------
This project contains the main code for easyb. 

Building
--------
If you are building a released version of easyb-core, it will be enough
to check out this project and build it.

If you are building a SNAPSHOT version, you'll have to checkout and install (mvn install) the following projects before:
- easyb-parent
- easyb-maven-parent
- easyb-ast
- easyb-composite-groovy
