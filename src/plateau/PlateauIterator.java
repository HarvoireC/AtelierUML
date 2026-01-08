package plateau;

import java.util.List;

class PlateauIterator implements Iterator {
    private List<Case> cases;
    private int position = 0;

    public PlateauIterator(List<Case> cases) {
        this.cases = cases;
    }

    public boolean hasNext() {
        return position < cases.size();
    }

    public Case next() {
        if (hasNext()) {
            return cases.get(position++);
        }
        return null;
    }
}