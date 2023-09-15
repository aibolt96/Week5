public class Recursion {
    public static int recursionSearch(String item, String[] itemList, int index){
        if (index >= itemList.length){
            return -1;
        }
        if (itemList[index].equals(item)){
            return index;
        }
        return recursionSearch(item, itemList, index + 1);
    }
    public static int recursionSearch(String item, String[] itemList){
        return recursionSearch(item, itemList, 0);
    }
    public static void main(String[] args){
        String[] itemList = {"hey", "there", "you"};

        System.out.println(recursionSearch("hey", itemList));
        System.out.println(recursionSearch("parcupine", itemList));
    }
}
