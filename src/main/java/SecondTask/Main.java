package SecondTask;

import java.io.IOException;

import static FirstTaskDataStructure.ClassroomDataGroups.solveTaskOne;
import static FirstTaskDataStructure.PersonAgeDataGroups.solveTaskTwo;
import static FirstTaskDataStructure.PersonNameDataGroups.solveTaskThree;


/*
Классы устроены следующим образом - первый хранит двумерный массив обьектов Person, в котором в качестве первого
индекса при добавлении берется номер класса, второй качестве первого индекса берется возраст, а в третьем -
первая буква фамилии. Когда мы решаем первую задачу, то берем первый класс, так как большинство данных не нужно
проверять, а доступ к элементам массива (в данном случае, к подмассиву Person) выполняется за фиксированное время
 - О(1). Аналогично дела обстоят с остальными.
*/
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(solveTaskOne());
        solveTaskTwo();
        solveTaskThree();

    }
}
