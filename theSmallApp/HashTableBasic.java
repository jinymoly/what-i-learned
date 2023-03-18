package theSmallApp;

import java.util.LinkedList;

public class HashTableBasic {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("나", "He is cute");
        h.put("무", "He is a apple");
        h.put("늘", "He is an angel");
        h.put("보", "He is pretty");
        System.out.println(h.get("나"));
        System.out.println(h.get("무"));
        System.out.println(h.get("늘"));
        System.out.println(h.get("보"));
        System.out.println(h.get("아빠가방에들어있다."));

    }
}

class HashTable {

    class Node {
        String key; // 검색 키 
        String value; // 검색 결과 

        public Node(String key, String value){ // 생성자
            this.key = key;
            this.value = value;
        }
        String value() { // getter
            return value;
        }
        void value(String value) { // setter
            this.value = value;
        }
    }

    LinkedList<Node>[] data; // node가 들어감 
    HashTable(int size) {
        this.data = new LinkedList[size]; // 정해진 크기의 배열방을 만든다 
    }

    int getHashCode(String key) { // 해시 알고리즘을 가지고 있는 해시함수 : key를 받아서 hashCode 반환 
        int hashcode = 0; // 해시코드 초기화 
        for(char c : key.toCharArray()) { // 입력 받은 key(문자열) 각 letter의 아스키 값을 가져와서 
            hashcode += c; // 해시코드에 더해준다 
        }
        return hashcode;
    }

    int convertToIndex(int hashcode){ // 해시코드를 받아서 인덱스로 변환하는 함수
        return hashcode % data.length; // 해시코드를 배열방의 크기로 나눈 나머지가 배열방의 index가 된다. 
    }

    // index로 배열방을 찾은 이후 배열방의 노드가 여러 개 존재하는 경우 
    // 검색key로 해당 노드를 찾아오는 함수 
    Node searchKey(LinkedList<Node> list, String key) {
        if(list == null) 
            return null; // 배열방이 null이면 null을 반환 
        for(Node node : list) { // 아니라면 배열방의 linkedList를 탐색 
            if(node.key.equals(key)){ // 노드의 key가 검색하는 key와 같은지 확인 
                return node; // 같은 노드를 반환 
            }
        }
        return  null;
    }
    
    void put(String key, String value) { // 본격적으로 데이터를 받아서 저장하는 함수 
        int hashcode = getHashCode(key); // key로 hashCode를 받아온다 
        int index = convertToIndex(hashcode); // 받은 hashCode로 저장할 배열방 번호를 받아온다
        
        System.out.println(key + ", hashcode (" + hashcode + "), index (" + index + ")");
        
        LinkedList<Node> list = data[index]; //배열방 번호로 기존 배열방에 있는 데이터를 가져온다 
        if(list == null) {
            list = new LinkedList<Node>(); //배열방이 null이면 linkedList 생성 
            data[index] = list; // 해당 list를 배열방에 넣어준다 
        }
        Node node = searchKey(list, key); // 기존의 해당key로 데이터를 가지고 있는지 노드를 받아온다 
        if(node == null) {
            list.addLast(new Node(key, value)); // 데이터가 없으니 받아온 정보로 노드를 생성하고 list에 추가한다
        } else {
            node.value(value); // 해당 node가 있다면 그 값을 대체함으로 중복 키를 처리 
        }
    }
    String get(String key) { // key로 데이터를 가져오는 함수 
        int hashcode = getHashCode(key); 
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "Not found" : node.value(); // node를 못 찾았으면 "Not found", 아니면 찾은 value를 반환 
    }
}