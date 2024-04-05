package VisitorExample;

public class Farm {
    int count = 10;
    Animal[] animals;
    Farm(){
        animals = new Animal[count ];

        for (int i = 0; i < count; i++) {
            int which = (int) (Math.random() * 3);
            boolean gender = (int) (Math.random() * 2) == 1;
            switch (which) {
                case 0 -> animals[i] = new Cattle(gender);
                case 1 -> animals[i] = new Chicken(gender);
                case 2 -> animals[i] = new Pig(gender);
            }
        }
    }

    public void acceptVisitor(Visitor v){
        for(int i = 0;i < count ; i++) {
            animals[i].accept(v);
        }
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for( Animal a : animals)
            str.append(a).append("\n");

        return str.toString();

    }


    public static void main(String[] args) {

        Farm farm = new Farm();
        System.out.println(farm);
        CountMales visitor = new CountMales();
        farm.acceptVisitor(visitor);
        System.out.println("Number of males: " + visitor.getCount());


    }
}
