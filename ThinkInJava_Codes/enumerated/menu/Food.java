package enumerated.menu;

public interface Food{
    enum Appetizer implements Food{
	SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food{
	LASAGNE, BURRITO, PAD_THAI, LENTILS;
    }

    enum Dessert implements Food{
	GALATO, FRUIT;
    }

    enum Coffee implements Food {
	BALCK_COFFEE, WRITE_COFFEE;
    }
}