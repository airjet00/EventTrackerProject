# EventTrackerProject
- [x] Create Gradel Project and Spring Boot Project
- [x] Create JPA entity and tests
- [x] Create REST API controllers, service, and Spring Data repository w/logic
- [x] Test CRUD operation and controller logic in postman
- [ ] Deploy project to EC2 instance.
- [ ] LINK TO DEPLOYED APP, LOGIN INFO IF NEEDED
- [ ] Buildout for nested CRUD
- [ ] Build front end
- [ ] create methods to calculate financials.
## Overview
Financial Tracker Event Tracker Project. An application to view
current income, expense, and view current available. Have a basic
profile page which would display total available, received income and expense with links to add income or expense.   

## How to Run

Currently tested REST API using postman with information to create postman test below.

![Image of Postman Testing](https://github.com/airjet00/EventTrackerProject/blob/main/Postman%20testing.png)Format: ![Alt Text](url)

## REST API

| **HTTP Method** | **Resource URI** | **Request Body** | **Returns**        |
|-------------|--------------|--------------|----------------|
| Get         | 'api/income' |              | List&lt;Income&gt;|
| Get         | 'api/income/id' |              | &lt;Income&gt;|
| Post         | 'api/income' |   new income resource   | &lt;Income&gt;|
| Put         | 'api/income/id' | new version of income | &lt;Income&gt;|
| Delete         | 'api/income/id' |              | Void  |
| Get         | 'api/expense' |              | List&lt;Income&gt;|
| Get         | 'api/expense/id' |              | &lt;Income&gt;|
| Post         | 'api/expense' |  new expense resource   | &lt;Income&gt;|
| Put         | 'api/expense/id' | new version of expense | &lt;Income&gt;|
| Delete         | 'api/expense/id' |              | Void  |
| Get         | 'api/manager' |              | List&lt;Income&gt;|
| Get         | 'api/manager/id' |              | &lt;Income&gt;|
| Post         | 'api/manger' |  new manager resource    | &lt;Income&gt;|
| Put         | 'api/manager/id' | new version of expense | &lt;Income&gt;|
| Delete         | 'api/manager/id' |              | Void  |
