
How to develop a SOAP client from Alfresco Repository
=====================================================

**Background**

This project has been developed as a sample to build a SOAP client from Alfresco Repository. So it's not intended to be used in real environments.

This project has nothing to see with Alfresco SOAP API (unavailable from Alfresco 5) or Alfresco SOAP CMIS (only available as 1.0 spec).

**Description**

With every new version, Alfresco Repository WAR introduces changes for used Java libraries, so it's safer to use an standard way for building a SOAP client. [JAX-WS](https://docs.oracle.com/javaee/6/tutorial/doc/bnayl.html) is an standard provided by Java out-of-the-box. This project includes an standard SOAP client built from WSDL by using [wsimport](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/wsimport.html) tool and an Alfresco Repository Module to expose SOAP Web Services as REST invocations (Web Scripts).

[Global Weather](http://www.webservicex.net/globalweather.asmx?WSDL) sample web service (from [WEBSERVICEX.NET](http://www.webservicex.com/New/)) has been selected as endpoint to test developing process.

**License**
The plugin is licensed under the [LGPL v3.0](http://www.gnu.org/licenses/lgpl-3.0.html). 

**State**
Current patch release is 1.0.0

**Compatibility** 
The current version has been developed using Alfresco 201605 and Alfresco SDK 2.2.0

***Original Alfresco resources have NOT been overwritten***

Downloading the ready-to-deploy-plugin
--------------------------------------
The binary distribution is made of one AMP file for the Alfresco repository:

* [repo AMP](https://github.com/angelborroy/alfresco-soap-client/releases/download/1.0.0/soap-client-repo-1.0-SNAPSHOT.amp)

You can install it by stopping Alfresco, copying AMP repo file to `$ALFRESCO_HOME/amps`, executing `$ALFRESCO_HOME/bin/apply_amps.sh` and starting Alfresco.

Building the artifacts
----------------------

`global-weather-wsdl-client` is an standard JAX-WS SOAP client packaged as a JAR library. In order to be available for `soap-client-repo` (Alfresco Repository Module) compilation, you need to install it first.

```
$ cd global-weather-wsdl-client
$ mvn clean install
```

Once the library is installed in your local Maven repository, you can build Alfresco artifact from source code using maven

```
$ cd soap-client-repo
$ mvn clean package
$ ls target/*.amp
target/soap-client-repo-1.0.0.amp
```

