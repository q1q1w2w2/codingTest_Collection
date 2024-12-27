package realization;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

// 최소 힙 구현
public class Heap<E> {

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private Object[] array;

    // 초기 공간 할당하지 않는 생성자
    public Heap() {
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {
        array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    // 초기 공간 할당하는 생성자
    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    // 받은 인덱스의 부모 노드 반환
    private int getParent(int index) {
        return index / 2;
    }

    // 받은 인덱스의 왼쪽 자식 노드 반환
    private int getLeftChild(int index) {
        return index * 2;
    }

    // 받은 인덱스의 오른쪽 자식 노드 반환
    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    private void resize(int newCapacity) {
        this.array = Arrays.copyOf(array, newCapacity);
    }

    /**
     * 추가 메서드
     * 1. 마지막 인덱스에 노드 추가
     * 2. 부모 노드와 비교(부모가 더 클 때까지)
     */
    private void add(E value) {
        // 용량이 꽉 차있다면 두 배로
        if (size + 1 == array.length) {
            resize(array.length * 2);
        }

        siftUp(size + 1, value);
        size++;
    }

    private void siftUp(int idx, E target) {
        if (comparator != null) {
            siftUpComparator(idx, target, comparator);
        } else {
            siftUpComparable(idx, target);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
        // root 노드보다 클 때 까지만 탐색
        while (idx > 1) {
            int parent = getParent(idx);
            Object parentVal = array[parent];

            // 타겟 값이 부모보다 크면 종료
            if (comp.compare(target, (E) parentVal) >= 0) {
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = target;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int idx, E target) {
        // 타겟노드가 비교 될 수 있도록 한 변수를 만든다.
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while(idx > 1) {
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal) >= 0) {
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = comp;
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        if(array[1] == null) {	// 만약 root가 비어있을경우 예외를 던지도록 함
            throw new NoSuchElementException();
        }

        E result = (E) array[1];	// 삭제된 요소를 반환하기 위한 임시 변수
        E target;	// 타겟이 될 요소
        if(size == 1) {
            target = null;
        }
        else {
            target = (E) array[size];
        }
        array[size] = null;	// 타겟 노드를 비운다.

        // 삭제할 노드의 인덱스와 이후 재배치 할 타겟 노드를 넘겨준다.
        siftDown(1, target);	// 루트 노드가 삭제되므로 1을 넘겨준다.

        return result;
    }


    /**
     * @param idx	삭제할 노드의 인덱스
     * @param target	재배치 할 노드
     */
    private void siftDown(int idx, E target) {
        // comparator가 존재할 경우 comparator 을 인자로 넘겨준다.
        if(comparator != null) {
            siftDownComparator(idx, target, comparator);
        }
        else {
            siftDownComparable(idx, target);
        }
    }

    // Comparator을 이용한 sift-down
    @SuppressWarnings("unchecked")
    private void siftDownComparator(int idx, E target, Comparator<? super E> comp) {

        array[idx] = null;	// 삭제 할 인덱스의 노드를 삭제
        size--;

        int parent = idx;	// 삭제노드부터 시작 할 부모를 가리키는 변수
        int child;	// 교환 될 자식을 가리키는 변수

        // 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
        while((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);	// 오른쪽 자식 인덱스

            Object childVal = array[child];	// 왼쪽 자식의 값 (교환 될 값)

            /*
             *  오른쪽 자식 인덱스가 size를 넘지 않으면서
             *  왼쪽 자식이 오른쪽 자식보다 큰 경우
             *  재배치 할 노드는 작은 자식과 비교해야하므로 child와 childVal을
             *  오른쪽 자식으로 바꿔준다.
             */
            if(right <= size && comp.compare((E) childVal, (E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            // 재배치 할 노드가 자식 노드보다 작을경우 반복문을 종료한다.
            if(comp.compare(target ,(E) childVal) <= 0){
                break;
            }

            /*
             *  현재 부모 인덱스에 자식 노드 값을 대체해주고
             *  부모 인덱스를 자식 인덱스로 교체
             */
            array[parent] = childVal;
            parent = child;
        }

        // 최종적으로 재배치 되는 위치에 타겟이 된 값을 넣어준다.
        array[parent] = target;

        /*
         *  용적의 사이즈가 최소 용적보다는 크면서 요소의 개수가 전체 용적의 1/4일경우
         *  용적을 반으로 줄임(단, 최소용적보단 커야함)
         */
        if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

    }

    // Comparable을 이용한 sift-down
    @SuppressWarnings("unchecked")
    private void siftDownComparable(int idx, E target) {

        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);

            Object childVal = array[child];

            if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if(comp.compareTo((E) childVal) <= 0){
                break;
            }
            array[parent] = childVal;
            parent = child;

        }
        array[parent] = comp;

        if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if(array[1] == null) {
            throw new NoSuchElementException();
        }
        return (E)array[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size + 1);
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(20);
        heap.add(5);
        heap.add(11);
        heap.add(10);
        heap.add(3);
        heap.add(1);

        System.out.println("heap.peek = " + heap.peek());
        System.out.println(heap.getParent(4));
    }
}
