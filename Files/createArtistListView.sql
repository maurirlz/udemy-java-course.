CREATE VIEW IF NOT EXISTS artist_list AS
SELECT artists.name AS artist, albums.name AS album, songs.track, songs.title FROM songs 
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
ORDER BY artists.name, albums.name, songs.track;
