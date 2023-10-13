/* 
1667. Fix Names in a Table

Table: Users

+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| user_id        | int     |
| name           | varchar |
+----------------+---------+
user_id is the primary key (column with unique values) for this table.
This table contains the ID and the name of the user. The name consists of only lowercase and uppercase characters.
 

Write a solution to fix the names so that only the first character is uppercase and the rest are lowercase.

Return the result table ordered by user_id.

The result format is in the following example.

 

Example 1:

Input: 
Users table:
+---------+-------+
| user_id | name  |
+---------+-------+
| 1       | aLice |
| 2       | bOB   |
+---------+-------+
Output: 
+---------+-------+
| user_id | name  |
+---------+-------+
| 1       | Alice |
| 2       | Bob   |
+---------+-------+
Accepted
154.8K
Submissions
244.9K
Acceptance Rate

*/
SELECT USER_ID, 
        CONCAT(UPPER(SUBSTR(NAME, 1, 1)), 
                LOWER(SUBSTR(NAME, 2))) AS NAME
FROM USERS

-- concat() 글자 이어붙이기 
-- substr(string, start_position, length) >> length는 생략 가능하다. 
-- 첫번째 글자를 대문자로, 두번째 글자부터 소문자로 