// 输入一个班至少15人的三门功课的成绩，输入信息包括姓名、语文成绩、数学成绩、英语成绩。为每个学生计算总分，计算班级的平均分，按总分从高到低排序，并给出名次，总分相同，名次相同。相同总分的学生排名位置依次按语文分数、数学分数、英语分数从高到低排列。
import java.util.*;

class Student{
        String name;
        int chinese;
        int math;
        int english;
        int sum;

        Student(String name, int chinese, int math, int english) {
            this.name = name;
            this.chinese = chinese;
            this.math = math;
            this.english = english;
            this.sum = this.chinese + this.math + this.english;
        }
}

class cmp implements Comparator<Student>{
    public int compare(Student a, Student b) {
        if (a.sum == b.sum) {
            if (a.chinese == b.chinese) {
                if (b.math == a.math) {
                    if (a.english == b.english) {
                        return 0;
                    } else {
                        return a.english < b.english ? 1 : -1;
                    }
                } else {
                    return a.math < b.math ? 1 : -1;
                }
            } else {
                return a.chinese < b.chinese ? 1 : -1;
            }
        } else {
            return a.sum < b.sum ? 1 : -1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // students' total

        ArrayList<Student> students = new ArrayList<Student>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int chinese = scanner.nextInt();
            int math = scanner.nextInt();
            int english = scanner.nextInt();


            students.add(i, new Student(name, chinese, math, english));
        }

        Collections.sort(students, new cmp());

        int rank = 1;
        int pre_sum = 0;
        int class_sum = 0;

        for (Student s : students) {
            if (pre_sum != 0 && s.sum != pre_sum) {
                rank++;
            }
            pre_sum = s.sum;
            class_sum += s.sum;
            System.out.println(rank + " " + s.name);
        }

        System.out.println("class average: " + class_sum / n);
    }

}
