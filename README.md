# IrelandStatistics-Backend
<p>
<a href="https://img.shields.io/badge/statue-developing-yellow"><img alt="" src="https://img.shields.io/badge/statue-developing-yellow"/></a>
<a href="https://github.com/freestyletime"><img alt="author" src="https://img.shields.io/badge/author-Chris Chen-blue.svg"/></a>
<a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html"><img alt="JDK" src="https://img.shields.io/badge/JDK-17-orange.svg"/></a>
<a href="https://docs.spring.io/spring-boot/docs/3.1.4.RELEASE/reference/html/"><img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4.RELEASE-brightgreen.svg"/></a>
<a href="https://github.com/freestyletime/IrelandStatistics-Backend/blob/main/LICENSE"><img alt="LICENSE" src="https://img.shields.io/github/license/freestyletime/IrelandStatistics-Backend.svg"/></a>
</p>
This project aims to demonstrate diverse statistics in an organized way in Ireland.
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
  - [x] 2023
  - [x] 2022
  - [ ] 2021
  - [ ] 2020
  - [ ] 2019
  - [ ] 2018
  - [ ] 2017
  - [ ] 2016
  - [ ] 2015
* Population(under construction)

## Development Environment
* Java
* Spring-boot
* Docker
* Maven
* IntelliJ IDEA ULTIMATE 2023.2.1

## API

### Basic Rules
* The project contains a united prefix(project name): `/ireland_statistics`
* Then following by the string(api version): `/api/v1`
* End with the business type such as: `employment-permit`

#### /employment-permit/company
| URI                    | Des                                                                                      | Example                                                                      |
|------------------------|------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|
| /{year}                | look up the employment permit data for all the companies in the specific year in Ireland | /ireland_statistics/api/v1/employment-permit/company/2023?page=0&pageSize=10 |
| /{year}/{company} | look up the employment permit data with specific company in the specific year in Ireland | ireland_statistics/api/v1/employment-permit/company/2023/google?page=0&pageSize=10             |

#### /employment-permit/nationality
| URI   | Des                                                                                      | Example                                                         |
|-------|------------------------------------------------------------------------------------------|-----------------------------------------------------------------|
|/{year}| look up the employment permit data for all nationalities in the specific year in Ireland | /ireland_statistics/api/v1/employment-permit/nationality/2023       |
|/{year}/{nationality}| look up the employment permit data with specific nationality in the specific year in Ireland | ireland_statistics/api/v1/employment-permit/nationality/2023/Japan |

#### /employment-permit/county
| URI   | Des                                                                                          | Example                                                         |
|-------|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------|
|/{year}| look up the employment permit data for all counties in the specific year in Ireland          | /ireland_statistics/api/v1/employment-permit/county/2023        |
|/{year}/{county}| look up the employment permit data with specific county in the specific year in Ireland | ireland_statistics/api/v1/employment-permit/county/2023/Kildare |

## License

[Apache-2.0](http://opensource.org/licenses/Apache-2.0)

