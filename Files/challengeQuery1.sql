/* Select the titles of all the songs on the album forbidden: */

SELECT songs.title, songs.track, albums.name as Album FROM songs
INNER JOIN albums ON songs.album = albums._id
WHERE albums.name = "Forbidden"
ORDER BY songs.track, songs.title;