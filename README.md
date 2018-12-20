# algorithm
算法


## 排序

### 冒泡排序

	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		
		for(int i = 1; i < array.length; i++) {
			boolean flag = true;
			
			for(int j = 0; j < array.length - i; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
		
		return array;
	}
	

### 选择排序

	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		int length = array.length;
		//N-1轮
		for(int i = 0; i < length-1; i++) {
			int min = i;
			//N-i轮
			for(int j = i + 1; j < length; j++) {
				//使用下标来记录数组的数据
				if(array[min] > array[j]) {
					min = j;
				}
			}
			
			if(min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		return array;
	}
	
	
### 插入排序

	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		for(int i = 1; i < array.length; i++) {
			//用一个数来记录将要插入的数
			int temp= array[i];
			int j = i;
			//前面的数已经有序了，只要小于前面一个数即可
			while(j > 0 && temp < array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			if(j != i) {
				array[j] = temp;
			}
		}
		return array;
	}
  
  
  ### 希尔排序
  
  	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		
        for(int gap = array.length / 2; gap > 0; gap /= 2) {
        	
        	for(int i = gap; i < array.length; i++) {
        		int temp = array[i];
        		int j = i - gap;
        		while(j >= 0 && temp < array[j]) {
        			array[j+gap] = array[j];
        			j -= gap;
        		}
        		array[j + gap] = temp;
        	}
        }

        return array;
    }
  
