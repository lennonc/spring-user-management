#### Setup

This sample project was built using Java's spring framework. Please visit [this page](https://spring.io/guides) for details
on how to setup spring on your local machine.

Next `cd` into the directory and run `gradle bootRun`. This should start up the web app and mount it on `http://localhost:8080`

#### Implementation Details
This sample project uses the [h2 database](http://www.h2database.com/html/main.html) because it's lightweight and easy to setup.

It is setup to provide a JSON api that can be consumed but a number of different clients.

##### Models
Each model has an associated DAO (Data Access Object) which implements the raw sql queries (separating the User object from its queries seems like a good idea). The `list` method returns a List of `User` objects. The `get` method also returns a java `User` object.

##### Controllers
The `UsersController` currently implements two routes. `/users` and `/users/new`

The `/users` route returns the list of all users as a JSON object.
The `/users/new` route is a post endpoint that accepts a json object and persists it in the database. Below is a sample reqeust to the `/users/new` endpoint.

```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
"firstName": "Josiah",
"lastName": "Bartlet",
"email": "jed.bartlet@usa.gov",
"role": "President"
}' "http://localhost:8080/users/new"
```
