# IrelandStatistics-Backend
<p>
<a href="https://img.shields.io/badge/statue-developing-yellow"><img alt="" src="https://img.shields.io/badge/statue-developing-yellow"/></a>
<a href="https://github.com/freestyletime"><img alt="author" src="https://img.shields.io/badge/author-Chris Chen-blue.svg"/></a>
<a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html"><img alt="JDK" src="https://img.shields.io/badge/JDK-17-orange.svg"/></a>
<a href="https://docs.spring.io/spring-boot/docs/3.1.4.RELEASE/reference/html/"><img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4.RELEASE-brightgreen.svg"/></a>
</p>
This project is aiming to demonstrate diverse statistics in an organized way in Ireland.
This repository only involves the back-end code. 
It adopts Spring-boot as the framework, GitHub Action as CI/CD. 
Oracle Cloud offers the production environment where
the whole project is containerized by Docker.

For the detail of this back-end project, it has three typical layers namely
Controller, Service, Repository. MongoDB is used for the data storage.

The purpose of its existence is to provide RESTful APIs. 
The organized data from those APIs will be better to support many end-clients
like Android, IOS, Browser, etc. Developers are able to take advantage of them
to illustrate data in magnificent ways to users.

## Data Source
* [Employment Permits](https://enterprise.gov.ie/en/what-we-do/workplace-and-skills/employment-permits/statistics/)
* Population(under construction)