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
Oracle Cloud offers the production environment where the whole project is containerized by Docker.
Finally, take the Nginx as the reverse proxy server, transferring data from port 80 to port 8081.


For the detail of this back-end project, it has three typical layers namely
Controller, Service, Repository. MongoDB is used for the data storage.


The purpose of its existence is to provide RESTful APIs of irish publish statistics. 
The organized data from those APIs will be better to support many end-clients
like Android, IOS, Browser, etc. Developers are able to take advantage of them
to illustrate data in magnificent ways to users.

## Data Source
* [Employment Permits](https://enterprise.gov.ie/en/what-we-do/workplace-and-skills/employment-permits/statistics/)
  - [x] 2023
  - [x] 2022
  - [x] 2021
  - [x] 2020
* Population(under construction)

## Development Environment
* Java
* Spring-boot
* Docker
* Maven
* Oracle Cloud
* IntelliJ IDEA ULTIMATE 2023.2.1

## API

### Basic Rules
* The project contains a united prefix(project name): `/ireland_statistics`
* Then following by the string(api version): `/api/v1`
* End with the business type such as: `employment-permit`
* Factual example on Oracle Cloud: [2023 Work Permits for Amazon](http://141.148.240.29/ireland_statistics/api/v1/employment-permit/company/2023/Amazon)

#### /employment-permit/company
| URI               | Method | Description                                                                          | Example                                                                            |
|-------------------|--------|--------------------------------------------------------------------------------------|------------------------------------------------------------------------------------|
| /{year}           | GET    | the employment permit data for all the companies in the specific year in Ireland | /ireland_statistics/api/v1/employment-permit/company/2023?page=0&pageSize=10       |
| /{year}/{company} | GET    | the employment permit data with specific company in the specific year in Ireland | /ireland_statistics/api/v1/employment-permit/company/2023/google?page=0&pageSize=10 |
| /all/{company}    | GET    | the employment permit data with specific company in Ireland | /ireland_statistics/api/v1/employment-permit/company/all/Ernst%20&%20Young                    |

#### /employment-permit/nationality
| URI                   | Method | Description                                                                                | Example                                                             |
|-----------------------|--------|--------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
| /{year}               | GET    | the employment permit data for all nationalities in the specific year in Ireland   | /ireland_statistics/api/v1/employment-permit/nationality/2023       |
| /{year}/{nationality} | GET    | the employment permit data with specific nationality in the specific year in Ireland | /ireland_statistics/api/v1/employment-permit/nationality/2023/Japan |
| /all/{nationality}    | GET    | the employment permit data with specific nationality in Ireland | /ireland_statistics/api/v1/employment-permit/nationality/all/Japan  |

#### /employment-permit/county
| URI            | Method | Description                                                                                      | Example                                                          |
|----------------|--------|------------------------------------------------------------------------------------------|------------------------------------------------------------------|
| /{year}        | GET    | the employment permit data for all counties in the specific year in Ireland      | /ireland_statistics/api/v1/employment-permit/county/2023         |
| /{year}/{county} | GET    | the employment permit data with specific county in the specific year in Ireland  | /ireland_statistics/api/v1/employment-permit/county/2023/Kildare |
| /all/{county}  | GET    | the employment permit data with specific county in Ireland     | /ireland_statistics/api/v1/employment-permit/county/all/Kildare  |

#### /employment-permit/sector
| URI            | Method | Description                                                                    | Example                                                    |
|----------------|--------|--------------------------------------------------------------------------------|------------------------------------------------------------|
| /{year}        | GET    | the employment permit data for all sectors in the specific year in Ireland     | /ireland_statistics/api/v1/employment-permit/sector/2023   |
| /{year}/{sector} | GET    | the employment permit data with specific sector in the specific year in Ireland | /ireland_statistics/api/v1/employment-permit/sector/2023/A |
| /all/{sector}  | GET    | the employment permit data with specific sector in Ireland | /ireland_statistics/api/v1/employment-permit/sector/all/H%20-%20Transport%20&%20Storage |

## License

[Apache-2.0](http://opensource.org/licenses/Apache-2.0)

