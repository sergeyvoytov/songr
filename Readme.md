#SongR application

Is application created using Spring.


##Tuesday lab :

Fullfilled tasks:

- Created a hello world route at /hello
- Created a route that turns words into UPPER CASE.
- Created a basic splash page for the Songr app, available at the root route
- Created an Album class to act as a model in our app.
- An Album has a title, an artist, a songCount, a length (in seconds), and an imageUrl that is a link to that album’s art.

Routes:

/hello, /capitalize/n, and /albums

##Wednsday Lab

Created mapping for albums with get and post routes and redirect view.

Application writes to Database and retrieves data from Dtabase and outputs tit to the page(albums)
To run - please clone and run from IntelliJJ


## Thursday Lab

- Created Song Class, pulls information from the database
- The relashionship between Songs and albums are one to many 


###Paths:

/allsongs
/song
/albums

### App Logic:

- When the user get to the web app at /albums route then the user will be presented with the list of all albums
- User could add new album to the Database
- Then user could click on the link to be taken to more detailed page of the album at ("/albums/{id}")
- Then user will see the specified album and could add specified song to the album
- After hitting submit button, then app will redirect to the album detail page with all songs output

###To test:
Please run app in the InteliJJ to spin up the server and then proceed to localhost http://localhost:8080/albums

