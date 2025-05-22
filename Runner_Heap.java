public class Runner_Heap {
    public static void main(String[] args) {

    }

}

class Heap {
    public int[] arr;
    public int size;

    public Heap(int n) {
        arr = new int[n];
        size = n;
    }

    public void insert(Heap heap, int key) {
        if (isfull(heap)) {
            System.out.println("Heap is full");
        } else {
            heap.size++;
            heap.arr[heap.size - 1] = key;
            int i = heap.size - 1;
            while (i >= 0) {
                int parent = (i - 1) / 2;
                if (heap.arr[parent] < heap.arr[i]) {
                    int temp = heap.arr[i];
                    heap.arr[i] = heap.arr[parent];
                    heap.arr[parent] = temp;
                    i = parent;
                } else {
                    break;
                }

            }

        }
    }

    public Boolean isfull(Heap heap) {
        return heap.size == heap.arr.length;
    }

    public void Heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            Heapify(arr, n, largest);

        }
    }

    public void delete(Heap heap) {
        if (heap.size == 0) {
            System.out.println("Heap is empty");
        } else {
            heap.arr[0] = heap.arr[heap.size - 1];
            heap.size--;
            Heapify(heap.arr, heap.size, 0);

        }

    }

    public void Heapsort(Heap heap) {
        for (int i = heap.size - 1; i >= 0; i--) {
            int temp = heap.arr[0];
            heap.arr[0] = heap.arr[i];
            heap.arr[i] = temp;
            Heapify(heap.arr, i, 0);
        }
    }
}
