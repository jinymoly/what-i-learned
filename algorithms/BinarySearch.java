package algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] myList = {87, 21, 45, 93};

        System.out.println(binarySearch(myList, 93)); // 3번째 위치 
        System.out.println(binarySearch(myList, 16));
    }

    public static int binarySearch(int[] list, int item){
        if(isListEmpty(list)){
            return -1;
        }

        // 먼저 low ~ high 전체를 탐색한다 
        int low = 0;
        int high = list.length -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];
            
            if(guessEqualsItem(guess, item)){
                return mid;
            } else if(guessGreaterThanItem(guess, item)){
                high = mid -1; // 찾으려는 값이 mid값 보다 아래 있으면 mid의 한 칸 전이 새 high로 변경 
            } else if(guessLessThanItem(guess, item)){
                low = mid + 1; // 찾으려는 값이 mid값보다 위에 있으면 mid바로 다음 칸이 새 low가 된다.
            }
        }
        return -1;

    }

    public static boolean isListEmpty(int[] myList){
        int listSize = myList.length;

        if(listSize == 0) {
            return true;
        } 
        return false;
    }

    public static boolean guessEqualsItem(int guess, int item) {
        if(guess != item){
            return false;
        }
        return true;
    }

    public static boolean guessGreaterThanItem(int guess, int item){
        if(guess < item) {
            return false;
        }
        return true;
    }

    public static boolean guessLessThanItem(int guess, int item){
        if(guess > item){
            return false;
        }
        return true;
    }
}

