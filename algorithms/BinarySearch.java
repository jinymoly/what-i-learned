package algorithms;

/**
 * 이진 탐색 
 * 배열 내부의 데이터가 정렬되어 있어야만 사용 가능
 * 찾으려는 데이터아 중간점 위치에 있는 데이터를 반복적으로 비교
 * 범위를 새로 정할 때 마다 탐색 범위는 1/2씩 줄어든다 ---> O(log n)
 * 
 */
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
            
            if(guessEqualsItem(guess, item)){ // 원하는 값을 찾은 경우
                return mid; // 인덱스 반환
            } else if(guessGreaterThanItem(guess, item)){
                high = mid -1; // 찾으려는 값이 mid값 보다 작으면 mid의 한 칸 전(왼쪽)이 새 high로 변경 
            } else if(guessLessThanItem(guess, item)){
                low = mid + 1; // 찾으려는 값이 mid값보다 크면 mid바로 다음 칸(오른쪽)이 새 low가 된다.
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

