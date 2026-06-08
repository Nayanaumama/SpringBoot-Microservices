public record RecordNewFeature(int id,String name) {
    private static String address;
    private static int age;
    public void show (String address,int age)
    {
        System.out.println(address + " " + age);
    }

}
