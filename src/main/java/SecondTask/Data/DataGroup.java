package SecondTask.Data;

import SecondTask.Person.GroupCriterion;
import SecondTask.Person.Person;

public class  DataGroup {

    Person[][] elementData;

     final int CAPACITY = 33;

     DataGroup() {
          elementData = new Person[CAPACITY][];
          for (int i = 0; i < CAPACITY; i++) {
               elementData[i] = new Person[10];
          }

     }

     @Override
     public void addPerson(Person person ) {
          if(elementData[][elementData[person.groupKey()].length -1] != null) {
               GroupCriterion[] newData = new GroupCriterion[elementData[person.groupKey()].length * 2];
               System.arraycopy(elementData[person.groupKey()], 0, newData, 0, elementData[person.groupKey()].length);
          }
          for (int i = 0; i < elementData[person.groupKey()].length - 1; i++) {


               if (elementData[person.groupKey()][i] == null) {
                    elementData[person.groupKey()][i] = person;
                    break;
               }
          }

          
     }

     @Override
     public GroupCriterion[] getPersons(int id) {
          return elementData[id];
     }
}
