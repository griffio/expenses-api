expenses-api
============

Expense entity example 
~~~ json

{
  "id": "97ac81fc-7fb4-11e4-b116-123b93f75cba",
  "reason": "rhubarb and sausages",
  "cash": {
    "currency": "USD",
    "amount": 1234.00
  },
  "date": "2014-08-01"
}

~~~

dropwizard ( 0.8.4 ) autovalue querydsl

'com.ewerk.gradle.plugins.auto-value' version '1.0.5'
'com.ewerk.gradle.plugins.querydsl' version '1.0.5'

versions

~~~
dropwizardVersion = 0.8.4
gradleVersion = 2.6
guavaVersion = 18.0
junitVersion = 4.11
mainClassName = griffio.expenses.configuration.Main
querydslVersion = 3.6.7
sourceCompatibility = 1.8
targetCompatibility = 1.8
version = 0.1.0
~~~