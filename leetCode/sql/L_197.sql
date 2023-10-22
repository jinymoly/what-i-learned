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
-- 오답 쿼리
select id 
from weather
where temperature > (
        select case
            when temperature > lag(temperature) over (order by recordDate) then temperature
            else lag(temperature) over(order by recordDate)
        end as max_temp
        from weather
)

-- LAG() : 윈도우 함수 중 하나, 데이터 비교, 누적 및 통계 연산과 같은 분석적인 작업을 수행하는 데 유용
-- 현재 행의 이전 행(직전 행)의 값을 검색
-- OVER 절과 함께 사용되며, 특정 열을 기준으로 정렬된 결과 집합에서 이전 행의 값을 가져온다.

-- "single-row subquery returns more than one row" 오류는 하위 쿼리(subquery)가 여러 행을 반환하고, 
-- 메인 쿼리에서는 단일 값을 예상할 때 발생 
-- 위 쿼리의 경우, LAG 함수를 사용한 하위 쿼리가 여러 행을 반환하여 발생한 문제임 

-- 정답 쿼리
-- 그냥 단순하게 셀프 조인하여 where절로 날짜차이만 조건으로 걸어줘도 됐던 문제였다.. 
select w.id as id
from weather w, weather w2
where (w.recordDate - w2.recordDate) = 1
and w.temperature > w2.temperature