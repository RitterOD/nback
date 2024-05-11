Implement backend part of application
1. Finish write initial migration
    1. Fix problem with Liquibase start with Idea Spring Boot Configuration
    2. Adjust org.liquibase.gradle plugin: fix version, fix build.gradle etc
2. Implement DealSettingsService
3. Implement dao layer
4. Implement service layer
5. Integration Legacy code and backend part



# Notes
1. Create diff between jpa model and current database: gradle diffChangelog
# Unsolved tasks
1. Take a table name from annotation in gradle plugin
2. UUID generation in gradle plugin

# Security
1. Refactor code borrowed from sec project
1.1 Separate auth service from another code
2. Add some test