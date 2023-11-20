package SecondTaskArchitecture;

public class DataGroup {
    private final Person[][] elementData;
    private final GroupCriterion groupCriterion;

    DataGroup(GroupCriterion groupCriterion) {
        this.groupCriterion = groupCriterion;
        int CAPACITY = 33;
        elementData = new Person[CAPACITY][];
        for (int i = 0; i < CAPACITY; i++) {
            elementData[i] = new Person[10];
        }

    }
    static Person[] growArr(Person[] arr) {
        Person[] newArr = new Person[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    public void addPerson(Person person) {
        int key = groupCriterion.getPersonKey(person);

        if (elementData[key][elementData[key].length - 1] != null) {
            elementData[key] = growArr(elementData[key]);
        }
        for (int i = 0; i < elementData[key].length; i++) {
            {

                if (elementData[key][i] == null) {
                    elementData[key][i] = person;
                    break;
                }
            }

        }
    }

    public Person[] getPersons(int key) {

        return elementData[key];
    }


}