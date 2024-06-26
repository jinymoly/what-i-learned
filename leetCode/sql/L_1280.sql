/* 
1280. Students and Examinations

Table: Students

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| student_id    | int     |
| student_name  | varchar |
+---------------+---------+
student_id is the primary key (column with unique values) for this table.
Each row of this table contains the ID and the name of one student in the school.
 

Table: Subjects

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| subject_name | varchar |
+--------------+---------+
subject_name is the primary key (column with unique values) for this table.
Each row of this table contains the name of one subject in the school.
 

Table: Examinations

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| student_id   | int     |
| subject_name | varchar |
+--------------+---------+
There is no primary key (column with unique values) for this table. It may contain duplicates.
Each student from the Students table takes every course from the Subjects table.
Each row of this table indicates that a student with ID student_id attended the exam of subject_name.
 

Write a solution to find the number of times each student attended each exam.

Return the result table ordered by student_id and subject_name.

The result format is in the following example.

 

Example 1:

Input: 
Students table:
+------------+--------------+
| student_id | student_name |
+------------+--------------+
| 1          | Alice        |
| 2          | Bob          |
| 13         | John         |
| 6          | Alex         |
+------------+--------------+
Subjects table:
+--------------+
| subject_name |
+--------------+
| Math         |
| Physics      |
| Programming  |
+--------------+
Examinations table:
+------------+--------------+
| student_id | subject_name |
+------------+--------------+
| 1          | Math         |
| 1          | Physics      |
| 1          | Programming  |
| 2          | Programming  |
| 1          | Physics      |
| 1          | Math         |
| 13         | Math         |
| 13         | Programming  |
| 13         | Physics      |
| 2          | Math         |
| 1          | Math         |
+------------+--------------+
Output: 
+------------+--------------+--------------+----------------+
| student_id | student_name | subject_name | attended_exams |
+------------+--------------+--------------+----------------+
| 1          | Alice        | Math         | 3              |
| 1          | Alice        | Physics      | 2              |
| 1          | Alice        | Programming  | 1              |
| 2          | Bob          | Math         | 1              |
| 2          | Bob          | Physics      | 0              |
| 2          | Bob          | Programming  | 1              |
| 6          | Alex         | Math         | 0              |
| 6          | Alex         | Physics      | 0              |
| 6          | Alex         | Programming  | 0              |
| 13         | John         | Math         | 1              |
| 13         | John         | Physics      | 1              |
| 13         | John         | Programming  | 1              |
+------------+--------------+--------------+----------------+
Explanation: 
The result table should contain all students and all subjects.
Alice attended the Math exam 3 times, the Physics exam 2 times, and the Programming exam 1 time.
Bob attended the Math exam 1 time, the Programming exam 1 time, and did not attend the Physics exam.
Alex did not attend any exams.
John attended the Math exam 1 time, the Physics exam 1 time, and the Programming exam 1 time.
*/
select std.student_id as student_id, std.student_name as student_name,
        exam.subject_name as subject_name, count(exam.subject_name) as attended_exams
from students std join examinations exam on std.student_id = exam.student_id
group by attended_exams
order by std.student_id, exam.subject_name

-- 1차 수정 
select s.student_id as student_id, s.student_name as student_name, cnt.subject_name as subject_name, cnt.subject_count as attended_exams
from students s join (
select student_id, subject_name, nvl(count(*), 0) as subject_count
from examinations 
group by student_id, subject_name) cnt 
on s.student_id = cnt.student_id
order by s.student_id , cnt.subject_name

-- 2차 수정
select s.student_id as student_id, s.student_name as student_name, 
        sbj.subject_name as subject_name, coalesce(cnt.subject_count, 0) as attended_exams
from students s
cross join subjects sbj
left join(
    select student_id, subject_name, count(*) as subject_count
    from examinations 
    group by student_id, subject_name) cnt
on s.student_id = cnt.student_id 
and sbj.subject_name = cnt.subject_name
order by s.student_id, sbj.subject_name

-- nvl과 coalesce 함수의 차이 
-- 우선 같은 점 ? NULL값을 다른 값으로 대체 

-- nvl() : 두 개의 인수를 받고 첫 번째 인수가 null이면 두 번째 인수를 반환(주로 DBMS에서 사용)
-- coalesce() : 여러 인수를 받아 첫 번째 non-null 값을 반환 (이 함수는 ansi sql표준에 따라 작동하므로 여러 DBMS에서 사용 가능)

-- 근데 왜 nvl() 말고 coalesce()를 사용했니? 이식성과 가독성 
-- coalesce()는 여러 인수를 처리하는 더 일반적인 함수라 다른 DBMS로 이식할 때 더 안정적이다.
