class ChildA extends Parent {
    void incrementByTwo() {
        super.incrementValue();  // Calls the Parent's method
        super.incrementValue();  // Calls the Parent's method again
    }
}

