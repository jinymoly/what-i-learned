#include <stdio.h>
#include <stdlib.h>

// stack 구현

struct NODE { // Node라는 구조체 정의
    int data; 
    struct NODE *pNext; // 포인터 pNext -> 주소값을 가진 변수 
};

struct NODE *pHead; // Node라는 구조체를 가리키고 있는 포인터 변수 

void push(int data){
    struct NODE *pEnd = malloc(sizeof(struct NODE)); // malloc(동적 메모리 할당) : Node 구조체 크기 만큼 메모리 할당 -> pEnd : 새로 생성한 노드를 가리키는 포인터
    pEnd -> pNext = pHead -> pNext; // pHead가 가리키던 첫 째 노드를 pEnd로 설정 
    pEnd->data = data; // data를 pEnd로
    pHead -> pNext = pEnd; // pEnd가 새로운 스택 맨 위 노드가 되도록 
}

int pop(){
    int ret; // 반환할 데이터
    struct NODE *pDel = pHead -> pNext; // 스택 맨 위 노드를 가리키는 포인터 pDel, pHead의 다음 노드를 pDel이 가리키게 함
    pHead -> pNext = pDel -> pNext; // 스택의 맨 위 pDel이 가리키는 노드의 다음 노드로 pHead를 바꿈. 즉 그 아래 노드가 스택 맨 위 노드가 되도록 맨 위 노드를 제거 
    ret = pDel->data; // pDel이 가리키는 data를 ret에 저장
    free(pDel); // 메모리 해제
    return ret; // 반환 
}

int main() {
    int r;
    pHead = malloc(sizeof(struct NODE));
    pHead->pNext = NULL;
    
    push(10);
    push(20);
    push(30);
    
    r = pop();
    printf("%d", r);
    r = pop();
    printf("%d", r);
    r = pop();
    printf("%d", r);

    return 0;
}

// 출력결과 302010