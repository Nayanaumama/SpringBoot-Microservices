public class MainForRecord {
    public static void main(String[] args) {
        RecordNewFeature recordNewFeature = new RecordNewFeature(1,"nbhag");
        RecordNewFeature recordNewFeature1 = new RecordNewFeature(1,"nbhag");
        System.out.println(recordNewFeature1.equals(recordNewFeature));
        System.out.println(recordNewFeature.id());
        System.out.println(recordNewFeature.name());
        recordNewFeature.show("Jercey City",36);


    }
}
