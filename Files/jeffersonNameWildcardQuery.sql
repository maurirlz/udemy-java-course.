SELECT artists.name, albums.name, songs.track, songs.title FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
WHERE artists.name LIKE 'jefferson%' 
ORDER BY artists.name, albums.name, songs.track;