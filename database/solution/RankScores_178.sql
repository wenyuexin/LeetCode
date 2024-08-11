# Write your MySQL query statement below

SELECT A.Score, B.Rank
FROM Scores AS A
LEFT JOIN (SELECT Score, @n := @n + 1 Rank
    FROM (SELECT DISTINCT Score FROM Scores)  a, (SELECT @n := 0) m
    Order BY Score DESC) AS B
    ON A.Score = B.Score
ORDER BY A.Score DESC