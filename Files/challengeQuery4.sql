/* Select all the titles of all the songs by aerosmith in alphabetical order, include only the title in the output. */

SELECT songs.title FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
WHERE artists.name = "Aerosmith" 
ORDER BY songs.title;