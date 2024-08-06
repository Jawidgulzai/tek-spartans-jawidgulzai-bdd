package tek.bdd.utility;

public class RandomData {

    public static String emailAddress(String firstName, String lastName) {
        int random = (int) (Math.random() * 100000);
        return firstName + lastName + random + "@tekschool.us";
    }

//    public static String generateRandomEmail() {
//        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        Random random = new Random();
//        StringBuilder randomString = new StringBuilder(10);
//
//        for (int i = 0; i < 10; i++) {
//            int index = random.nextInt(characters.length() );
//            randomString.append(characters.charAt(index));
//        }
//        return randomString.toString() + "@gmail.com";
//    }
}
