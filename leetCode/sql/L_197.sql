/* 
197. Rising Temperature

Table: Weather

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+
id is the column with unique values for this table.
This table contains information about the temperature on a certain day.
 

Write a solution to find all dates' Id with higher temperatures compared to its previous dates (yesterday).

Return the result table in any order.

The result format is in the following example.

 

Example 1:

Input: 
Weather table:
+----+------------+-------------+
| id | recordDate | temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+
Output: 
+----+
| id |
+----+
| 2  |
| 4  |
+----+
Explanation: 
In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
In 2015-01-04, the temperature was higher than the previous day (20 -> 30).
*/
select id 
from
    (select id, temperature, 
            lag(temperature) over(order by recordDate) as prev_temperature
    from weather)
where temperature > prev_temperature;

-- LAG() : 윈도우 함수 중 하나, 데이터 비교, 누적 및 통계 연산과 같은 분석적인 작업을 수행하는 데 유용
-- 현재 행의 이전 행(직전 행)의 값을 검색
-- OVER 절과 함께 사용되며, 특정 열을 기준으로 정렬된 결과 집합에서 이전 행의 값을 가져온다.