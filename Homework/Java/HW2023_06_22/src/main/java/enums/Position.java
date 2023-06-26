package enums;

public enum Position {
    JUNIOR {
        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Position next() {
            return MIDDLE;
        }
    },
    MIDDLE {
        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Position next() {
            return SENIOR;
        }
    },
    SENIOR {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Position next() {
            return null;
        }
    };

    public abstract  boolean hasNext();

    public abstract Position next();
}
