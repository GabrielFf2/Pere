package org.example;

public class MockStudent implements Demandant{

    @Override
    public int addStudent() {
        return 1;
    }

    @Override
    public boolean removeStudent() {
        return true;
    }
}
