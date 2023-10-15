class ChildB extends Parent {

    void decrementByTwo() {
        super.incrementValue();  // This is intentional; just for illustration
        super.incrementValue();
    }
}