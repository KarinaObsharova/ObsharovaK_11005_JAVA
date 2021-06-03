 class Animals implements Comparable<Animals>, Printable{
        String name;
        int age;

        public Animals(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public void print() {
            System.out.println(name + " " + age);
        }

        @Override
        public int compareTo(Animals o) {
            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Animals{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
