SELECT s1.score AS Score, COUNT(*) AS Rank
FROM Scores AS s1
LEFT JOIN (SELECT DISTINCT SCORE FROM Scores) AS s2 ON s1.Score <= s2.Score
GROUP BY s1.id
ORDER BY s1.score DESC
