package SecondTaskArchitecture;

@FunctionalInterface
interface GroupCriterion {
    int getPersonKey(Person person);
}