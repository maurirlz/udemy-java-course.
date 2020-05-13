/* Display all the songs for the band " Deep Purple "*/

SELECT songs.title as trackTitle, artists.name FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
WHERE artists.name = "Deep Purple"
ORDER BY songs.title, artists.name;