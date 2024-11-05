class Movie {

    // fields 
    String movieName;
    String movieNameForUrl;
    String movieScreenshotFilename;
    
    Movie(Movie movies) {
        this.movieName = movieName;
        this.movieNameForUrl = getMovieNameForURL();
        this.movieScreenshotFilename = getMovieFilename();
    }

    public Movie(String string) {
        
    }

    /* If there are spaces in the movie, the URL parsing fails.
     * Use String methods to replace any spaces in the movieName to 
     * "%20" or plus signs "+" to make it URL-safe, and return that string.
     * see https://www.w3schools.com/tags/ref_urlencode.ASP
     */
    String getMovieNameForURL() {
        // FILL IN CODE HERE
        return movieName.replace(" ", "%20");
    } 

    /* If the movie doesn't have an extension, you cannot view it in VSCode correctly. 
    This method should add a ".jpg" or ".png" extension to the movie name to make it clear this is a picture.
    Also, remove spaces since spaces in filenames are ANNOYING. maybe replace with underscores?
    */
    String getMovieFilename() {
        // FILL IN CODE HERE
        return movieName.replace(" ", "_") + ".jpg";
    } 
}
